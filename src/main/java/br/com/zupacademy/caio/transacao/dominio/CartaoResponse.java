package br.com.zupacademy.caio.transacao.dominio;

public class CartaoResponse {
    private String id;
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public CartaoResponse(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public CartaoResponse() {
    }

    public static CartaoResponse converter(Cartao cartao) {
        return new CartaoResponse(cartao.getId(), cartao.getEmail());
    }
}