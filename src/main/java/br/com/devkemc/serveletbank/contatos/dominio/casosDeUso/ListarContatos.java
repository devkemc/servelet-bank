package br.com.devkemc.serveletbank.contatos.dominio.casosDeUso;

import br.com.devkemc.serveletbank.contatos.dominio.Contato;
import br.com.devkemc.serveletbank.contatos.dominio.Contatos;

import java.util.Collection;

public class ListarContatos {

    private final Contatos contatos;

    public ListarContatos(Contatos contatos) {
        this.contatos = contatos;
    }

    public Collection<Contato> executar(int pagina, int quantosPorPagina) {
        return contatos.buscarPagina(pagina, quantosPorPagina);
    }
}
