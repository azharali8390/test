package com.MockService.SimahBank.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String requestPath = request.getRequestURI();

        if (requestPath.equals("/api/v1/Identity/login")) {
            return true; // Allow access to the login endpoint without token validation
        }
        String token = request.getHeader("Authorization");
        if (isValidToken(token)) {
            return true;
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false; // Reject the request
        }
    }

    private boolean isValidToken(String token) {
        return token != null;
    }
}
