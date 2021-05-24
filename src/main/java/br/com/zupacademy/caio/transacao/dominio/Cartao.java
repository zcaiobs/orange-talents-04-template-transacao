package br.com.zupacademy.caio.transacao.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cartao {
    @Id
    private String id;
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Cartao(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public Cartao() {
    }
}
