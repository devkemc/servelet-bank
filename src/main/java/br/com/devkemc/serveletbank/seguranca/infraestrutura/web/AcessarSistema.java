package br.com.devkemc.serveletbank.seguranca.infraestrutura.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AcessarSistema extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        if(email.equals("admin@sistema.com") && senha.equals("10203040")) {
            request.getSession().setAttribute("AUTENTICADO", email);
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/gestaoContatos?acao=LISTAR"));
            return;
        }

        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/index.jsp?invalido=true"));
    }

}

