package com.h2s.blogsite.security.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class JwtTokenAfterFilter extends OncePerRequestFilter {

    private final JwtTokenProvider tokenProvider;

    public JwtTokenAfterFilter(JwtTokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String jwtHeader = JwtTokenProvider.getJwtFromRequest(request);

        if(null!=authentication && Objects.isNull(jwtHeader)) {
            String jwt = tokenProvider.generateToken(authentication);
            response.setHeader("Authorization", jwt);
        }
        filterChain.doFilter(request,response);
    }
}
