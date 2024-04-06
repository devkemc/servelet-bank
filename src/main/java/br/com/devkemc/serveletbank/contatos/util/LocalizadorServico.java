package br.com.devkemc.serveletbank.contatos.util;

import br.com.devkemc.serveletbank.contatos.dominio.Contatos;
import br.com.devkemc.serveletbank.contatos.dominio.casosDeUso.*;
import br.com.devkemc.serveletbank.contatos.infraestrutura.persistencia.ContatosJPA;
import br.com.devkemc.serveletbank.comum.infraestrutura.persistencia.JPAHelper;


public class LocalizadorServico {
    public static CadastrarContato cadastrarContato() {
        return new CadastrarContato(contatos());
    }

    public static Contatos contatos() {
        return new ContatosJPA(JPAHelper.getEntityManager());
    }

    public static EditarContato editarContato() {
        return new EditarContato(contatos());
    }

    public static ListarContatos listarContatos() {
        return new ListarContatos(contatos());
    }

    public static ExcluirContato excluirContato() {
        return new ExcluirContato(contatos());
    }

    public static BuscarContato buscarContato() {
        return new BuscarContato(contatos());
    }
}
