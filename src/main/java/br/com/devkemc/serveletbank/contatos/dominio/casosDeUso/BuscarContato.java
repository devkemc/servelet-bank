package br.com.devkemc.serveletbank.contatos.dominio.casosDeUso;

import br.com.devkemc.serveletbank.contatos.dominio.Contato;
import br.com.devkemc.serveletbank.contatos.dominio.Contatos;

import java.util.Optional;

public class BuscarContato {
    private final Contatos contatos;

    public BuscarContato(Contatos contatos) {
        this.contatos = contatos;
    }


    public Optional<Contato> executar(Long id) {
        return contatos.consultar(id);
    }
}
