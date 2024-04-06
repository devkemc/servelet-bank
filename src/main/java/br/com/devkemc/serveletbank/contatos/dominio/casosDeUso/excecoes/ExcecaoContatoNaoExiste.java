package br.com.devkemc.serveletbank.contatos.dominio.casosDeUso.excecoes;

public class ExcecaoContatoNaoExiste extends Throwable{
    public ExcecaoContatoNaoExiste(String message) {
        super(message);
    }
}
