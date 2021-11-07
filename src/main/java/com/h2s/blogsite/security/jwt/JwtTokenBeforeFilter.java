package com.h2s.blogsite.security.jwt;

import com.h2s.blogsite.repository.UserRepository;
import com.h2s.blogsite.security.SecurityUserDetailsService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtTokenBeforeFilter extends OncePerRequestFilter {

    private final JwtTokenProvider tokenProvider;

    private final UserRepository userRepository;

    private final SecurityUserDetailsService securityUserDetailsService;

    public JwtTokenBeforeFilter(JwtTokenProvider tokenProvider, UserRepository userRepository, SecurityUserDetailsService securityUserDetailsService) {
        this.tokenProvider = tokenProvider;
        this.userRepository = userRepository;
        this.securityUserDetailsService = securityUserDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = JwtTokenProvider.getJwtFromRequest(request);
            if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
                String account = tokenProvider.getUserIdFromJWT(jwt);

                UserDetails userDetails = securityUserDetailsService.loadUserByUsername(account);

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception ex) {
            logger.error("Could not set user authentication in security context", ex);
        }
        filterChain.doFilter(request,response);
    }
}