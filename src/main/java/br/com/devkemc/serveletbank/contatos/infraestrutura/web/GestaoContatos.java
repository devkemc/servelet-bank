package br.com.devkemc.serveletbank.contatos.infraestrutura.web;

import br.com.devkemc.serveletbank.contatos.dominio.casosDeUso.excecoes.ExcecaoContatoNaoExiste;
import br.com.devkemc.serveletbank.contatos.util.LocalizadorServico;
import br.com.devkemc.serveletbank.contatos.dominio.Contato;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class GestaoContatos extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Acao acao = Acao.fromValor(request.getParameter("acao"));
        switch (acao) {
            case EXCLUIR: {
                Long id = Long.parseLong(request.getParameter("contatoId"));
                if (null == id) {
                    response.sendRedirect("/gestaoContatos?acao=LISTAR");
                    return;
                }
                try {
                    LocalizadorServico.excluirContato().executar(id);
                    response.sendRedirect("/gestaoContatos?acao=LISTAR");
                } catch (ExcecaoContatoNaoExiste e) {
                    response.sendRedirect("/gestaoContatos?acao=LISTAR&erro=Contato não encontrado");
                }

                break;
            }
            case EDITAR: {
                Long id = Long.parseLong(request.getParameter("contatoId"));
                if (null == id) {
                    response.sendRedirect("/gestaoContatos?acao=LISTAR");
                    return;
                }
                Contato contato = LocalizadorServico.buscarContato().executar(id).get();
                if (null == contato) {
                    response.sendRedirect("/gestaoContatos?acao=LISTAR");
                    return;
                }
                request.setAttribute("contato", contato);
                request.getRequestDispatcher("/restrito/contatos/contato.jsp").forward(request, response);
                break;
            }
            case LISTAR: {
                request.setAttribute("contatos", LocalizadorServico.listarContatos().executar(1, 10));
                request.setAttribute("sucesso", request.getParameter("sucesso"));
                request.setAttribute("erro", request.getParameter("erro"));
                request.getRequestDispatcher("/restrito/contatos/index.jsp").forward(request, response);
                break;
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (null != request.getParameter("adicionar")) {
            Contato contato = null;
            try {
                contato = new Contato(request.getParameter("nome"), request.getParameter("email"), request.getParameter("telefone"));
            } catch (Exception e) {
                request.setAttribute("erro", "Algum dado não foi preenchido corretamente. Tente novamente!");
                request.getRequestDispatcher("/restrito/contatos/contato.jsp").forward(request, response);
                return;
            }
            switch (Acao.fromValor(request.getParameter("acao"))) {
                case EDITAR: {
                    contato.setId(Long.parseLong(request.getParameter("contatoId")));
                    try {
                        LocalizadorServico.editarContato().executar(contato);
                    } catch (ExcecaoContatoNaoExiste e) {
                        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/gestaoContatos?erro=Contato não encontrado&acao=LISTAR"));
                        return;
                    }
                    break;
                }
                case CADASTRAR: {
                    LocalizadorServico.cadastrarContato().executar(contato);
                    break;
                }
            }
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/gestaoContatos?sucesso=Contato adicionado com sucesso!&acao=LISTAR"));
        }
    }
}
