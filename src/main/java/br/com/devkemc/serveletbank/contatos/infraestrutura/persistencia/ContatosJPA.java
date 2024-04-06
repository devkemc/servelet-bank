package br.com.devkemc.serveletbank.contatos.infraestrutura.persistencia;

import br.com.devkemc.serveletbank.contatos.dominio.Contato;
import br.com.devkemc.serveletbank.contatos.dominio.Contatos;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
public class ContatosJPA implements Contatos {
  private final EntityManager entityManager;
  private EntityTransaction transacao;
  private boolean transacaoAberta;
  private boolean transacaoConfirmadaOuCancelada;

  public ContatosJPA(EntityManager entityManager) {
    this.entityManager = Objects.requireNonNull(entityManager);
  }

  @Override
  public Contato adicionar(Contato contato) {
    entityManager.persist(Objects.requireNonNull(contato));
    return contato;
  }

  @Override
  public Contato atualizar(Contato contato) {
    entityManager.merge(Objects.requireNonNull(contato));
    return contato;
  }

  @Override
  public void apagar(long idContato) {
    entityManager.remove(entityManager.find(Contato.class, idContato));
  }

  @Override
  public Optional<Contato> consultar(long idContato) {
    Query consulta = entityManager.createQuery(
            "SELECT contato FROM Contato contato WHERE contato.id=:id"
    );
    consulta.setParameter("id", idContato);

    return Optional.ofNullable((Contato) consulta.getSingleResult());
  }

  @Override
  public Collection<Contato> buscarPagina(int pagina, int quantosPorPagina) {
    Query consulta = entityManager.createQuery(
            "SELECT contato FROM Contato contato");
    consulta.setFirstResult((pagina - 1) * quantosPorPagina);
    consulta.setMaxResults(quantosPorPagina);

    return consulta.getResultList();
  }

  @Override
  public void iniciarTransacao() {
    if(transacaoAberta) {
      throw new IllegalStateException("Transação já está aberta");
    }
    transacao = entityManager.getTransaction();
    transacao.begin();
    transacaoAberta = true;
  }

  @Override
  public void confirmarTransacao() {
    if(!transacaoAberta || transacaoConfirmadaOuCancelada) {
      throw new IllegalStateException("Transação não está aberta");
    }
    transacao.commit();
    transacaoAberta = false;
    transacaoConfirmadaOuCancelada = true;
  }

  @Override
  public void cancelarTransacao() {
    if(!transacaoAberta || transacaoConfirmadaOuCancelada) {
      throw new IllegalStateException("Transação não está aberta");
    }
    transacao.rollback();
    transacaoAberta = false;
    transacaoConfirmadaOuCancelada = true;
  }
}
