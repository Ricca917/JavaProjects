package com.FootballTeam.footballTeam.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        System.out.println("DEBUG JwtFilter: Inizio doFilterInternal per richiesta: " + request.getRequestURI());

        String jwt = getJwtFromRequest(request);

        if (StringUtils.hasText(jwt)) {
            System.out.println("DEBUG JwtFilter: JWT estratto: " + jwt.substring(0, Math.min(jwt.length(), 20)) + "..."); // Stampa solo l'inizio per sicurezza
            if (jwtProvider.validateToken(jwt)) {
                String username = jwtProvider.getUsernameFromJwt(jwt);
                System.out.println("DEBUG JwtFilter: Token valido, username: " + username);

                UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
                System.out.println("DEBUG JwtFilter: UserDetails caricato per: " + userDetails.getUsername() + ", Ruoli: " + userDetails.getAuthorities());

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
                System.out.println("DEBUG JwtFilter: Autenticazione impostata in SecurityContextHolder per: " + SecurityContextHolder.getContext().getAuthentication().getName() + " con ruoli: " + SecurityContextHolder.getContext().getAuthentication().getAuthorities());
            } else {
                System.out.println("DEBUG JwtFilter: Token presente ma non valido o validazione fallita. Non autenticato.");
            }
        } else {
            System.out.println("DEBUG JwtFilter: Nessun token JWT nella richiesta o formato non valido. Non autenticato.");
        }

        filterChain.doFilter(request, response);
        System.out.println("DEBUG JwtFilter: Dopo filterChain.doFilter(). Autenticazione nel contesto: " + (SecurityContextHolder.getContext().getAuthentication() != null ? SecurityContextHolder.getContext().getAuthentication().getName() : "null") + " per richiesta: " + request.getRequestURI());
    }

    // Metodo helper per estrarre il JWT dall'header Authorization
    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}