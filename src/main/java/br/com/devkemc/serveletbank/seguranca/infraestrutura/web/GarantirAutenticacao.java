package br.com.devkemc.serveletbank.seguranca.infraestrutura.web;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class GarantirAutenticacao implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if(httpRequest.getSession().getAttribute("AUTENTICADO") == null) {
            httpResponse.sendRedirect(httpResponse.encodeRedirectURL(httpRequest.getContextPath() + "/index.jsp?proibido=true"));
        } else {
            chain.doFilter(request, response);
        }
    }
}
