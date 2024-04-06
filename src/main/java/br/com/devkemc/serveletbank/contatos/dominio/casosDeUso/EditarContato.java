package br.com.devkemc.serveletbank.contatos.dominio.casosDeUso;

import br.com.devkemc.serveletbank.contatos.dominio.Contato;
import br.com.devkemc.serveletbank.contatos.dominio.Contatos;
import br.com.devkemc.serveletbank.contatos.dominio.casosDeUso.excecoes.ExcecaoContatoNaoExiste;

public class EditarContato {
    private final Contatos contatos;

    public EditarContato(Contatos contatos) {
        this.contatos = contatos;
    }


    public void executar(Contato contato) throws ExcecaoContatoNaoExiste {
        contatos.iniciarTransacao();
        contatos.consultar(contato.getId()).orElseThrow(() -> new ExcecaoContatoNaoExiste("Contato não encontrado"));
        contatos.atualizar(contato);
        contatos.confirmarTransacao();
    }
}
