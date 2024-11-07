package com.jci.securityfilters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OptionsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Cast to HttpServletRequest and HttpServletResponse
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        httpResponse.addHeader("X-XSS-Protection", "1; mode=block");
        httpResponse.setHeader("X-Content-Type-Options", "nosniff");
        
     // Add the X-Frame-Options header to prevent clickjacking
        httpResponse.setHeader("X-Frame-Options", "DENY");
        
        // Set Strict-Transport-Security header to enforce HTTPS
        httpResponse.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains");

        // Set Cache-Control header to control caching behavior
        httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        httpResponse.setHeader("Content-Security-Policy", 
                "default-src 'self'; " +
                "img-src 'self' https://www.gstatic.com https://www.google.com; " +
                "style-src 'self' https://fonts.googleapis.com 'unsafe-inline'; " + // Allow unsafe inline styles
                "font-src 'self' https://fonts.gstatic.com; " +
                "script-src 'self' https://www.google.com https://www.gstatic.com https://www.google.com/recaptcha/api.js https://ajax.googleapis.com 'unsafe-inline'; " +
                "frame-src 'self' https://www.google.com;");

        // Add other headers as needed, such as Expires or Pragma
        httpResponse.setHeader("Expires", "0");
        httpResponse.setHeader("Pragma", "no-cache");
        
        // If the request method is OPTIONS, reject it
        if ("OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
            httpResponse.getWriter().println("HTTP Method 'OPTIONS' is not allowed.");
            httpResponse.setContentType("text/plain");
            httpResponse.setCharacterEncoding("UTF-8");
            httpResponse.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        } else {
            // Continue with the filter chain for other methods
            chain.doFilter(request, response);
        }
        
        Cookie[] cookies = httpRequest.getCookies();
        if (cookies != null) {
            // Loop through cookies and set SameSite attribute
            for (Cookie cookie : cookies) {
            	
                cookie.setSecure(true); // Use 'true' if your site is served over HTTPS
                String httpOnlyAttribute = "HttpOnly";
                String sameSiteAttribute = "SameSite=Strict"; // or "SameSite=Lax" depending on your requirements
                httpResponse.addHeader("Set-Cookie", cookie.getName() + "=" + cookie.getValue() + "; " + sameSiteAttribute + "; " + httpOnlyAttribute);
            }
        }
    }

    @Override
    public void destroy() {
        // Cleanup logic, if needed
    }
}
