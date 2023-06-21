package com.example.studentCouncil.config;

import com.example.studentCouncil.Services.JwtService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @Component
    @RequiredArgsConstructor
    public class JwtRequestFilter extends OncePerRequestFilter {
        private final JwtService jwtService;
        private final UserDetailsService userDetailsService ;
        @Override
        protected void doFilterInternal(
                @NonNull HttpServletRequest request,
                @NonNull HttpServletResponse response,
                @NonNull FilterChain filterChain) throws ServletException, IOException {
            final String authHeader = request.getHeader("Authorization");
            final String jwt;
            final String username;

            if(authHeader==null || !authHeader.startsWith("Bearer")){
                filterChain.doFilter(request,response);
                return;
            }
            jwt = authHeader.substring(7);
            username = jwtService.extractUsername(jwt);// todo extract the username from JWT token;
            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
                if(jwtService.isTokenValid(jwt, userDetails)){
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );
                    authenticationToken.setDetails(
                            new WebAuthenticationDetailsSource().buildDetails(request)
                    );
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
                filterChain.doFilter(request, response);
            }

        }
    }
