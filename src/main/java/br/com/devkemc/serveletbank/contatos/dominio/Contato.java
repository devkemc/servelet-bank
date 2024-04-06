package br.com.devkemc.serveletbank.contatos.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Contato implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    private Long id;
    private String nome;
    private String email;
    private String telefone;

    protected Contato() {
    }

    public Contato(String nome, String email, String telefone) {
        setNome(nome);
        setEmail(email);
        setTelefone(telefone);
    }

    public Contato(Long id) {
        setId(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        Objects.requireNonNull(nome);
        nome = nome.trim();
        if (nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Objects.requireNonNull(email);
        email = email.trim();
        if (email.isEmpty()) {
            throw new IllegalArgumentException("Email não pode ser vazio");
        }
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        Objects.requireNonNull(telefone);
        telefone = telefone.trim();
        if (telefone.isEmpty()) {
            throw new IllegalArgumentException("Telefone não pode ser vazio");
        }
        this.telefone = telefone;
    }
}
