package br.com.devkemc.serveletbank.contatos.dominio.casosDeUso;

import br.com.devkemc.serveletbank.contatos.dominio.Contato;
import br.com.devkemc.serveletbank.contatos.dominio.Contatos;

public class CadastrarContato {
    private final Contatos contatos;

    public CadastrarContato(Contatos contatos) {
        this.contatos = contatos;
    }

    public void executar(Contato contato) {
        contatos.iniciarTransacao();
        contatos.adicionar(contato);
        contatos.confirmarTransacao();
    }
}
