package br.com.devkemc.serveletbank.contatos.dominio.casosDeUso;

import br.com.devkemc.serveletbank.contatos.dominio.Contatos;
import br.com.devkemc.serveletbank.contatos.dominio.casosDeUso.excecoes.ExcecaoContatoNaoExiste;

public class ExcluirContato {
    private final Contatos contatos;

    public ExcluirContato(Contatos contatos) {
        this.contatos = contatos;
    }


    public void executar(Long id) throws ExcecaoContatoNaoExiste {
        contatos.iniciarTransacao();
        contatos.consultar(id).orElseThrow(() -> new ExcecaoContatoNaoExiste("Contato não encontrado"));
        contatos.apagar(id);
        contatos.confirmarTransacao();
    }
}
