package br.com.zupacademy.caio.transacao.dominio;

public class CartaoRequest {
    private String id;
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public CartaoRequest(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public CartaoRequest() {
    }

    public Cartao toCartao() {
        return new Cartao(this.id, this.email);
    }
}
