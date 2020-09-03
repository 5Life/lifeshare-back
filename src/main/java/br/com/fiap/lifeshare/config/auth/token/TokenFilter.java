package br.com.fiap.lifeshare.config.auth.token;

import br.com.fiap.lifeshare.model.User;
import br.com.fiap.lifeshare.repository.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenFilter extends OncePerRequestFilter {
    private TokenService tokenService;
    private UserRepository userRepository;

    public TokenFilter(TokenService tokenService, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = retrieveToken(httpServletRequest);
        boolean valid = tokenService.isTokenValid(token);
        if (valid)
            authenticate(token);
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private String retrieveToken(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        if (token == null || token.isEmpty() || !token.startsWith("Bearer "))
            return null;
        return token.substring(7, token.length());
    }

    private void authenticate(String token) {
        Long userId = tokenService.getUserId(token);
        User user = userRepository.findById(userId).get();
        UsernamePasswordAuthenticationToken authenticatedUser =
                new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }
}
