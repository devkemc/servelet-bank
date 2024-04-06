package br.com.devkemc.serveletbank.contatos.infraestrutura.web;

public enum Acao {
    EDITAR ("EDITAR"),
    LISTAR ("LISTAR"),
    EXCLUIR ("EXCLUIR"),
    CADASTRAR("CADASTRAR");

    private final String valor;
    private Acao(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public static Acao fromValor(String valor) {
        for (Acao acao : values()) {
            if (acao.valor.equals(valor)) {
                return acao;
            }
        }
        throw new IllegalArgumentException("Nenhuma correspondência encontrada para o valor: " + valor);
    }
}
