package br.com.devkemc.serveletbank.contatos.dominio;

import java.util.Collection;
import java.util.Optional;

public interface Contatos {
  void iniciarTransacao();
  void confirmarTransacao();
  void cancelarTransacao();
  Contato adicionar(Contato contato);
  Contato atualizar(Contato contato);
  void apagar(long idContato);
  Optional<Contato> consultar(long idContato);
  Collection<Contato> buscarPagina(int pagina, int quantosPorPagina);
}
