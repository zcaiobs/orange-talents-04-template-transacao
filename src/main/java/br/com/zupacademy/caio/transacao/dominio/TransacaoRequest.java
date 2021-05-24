package br.com.zupacademy.caio.transacao.dominio;

import java.math.BigDecimal;
import java.util.Date;

public class TransacaoRequest {
    private String id;
    private BigDecimal valor;
    private EstabelecimentoRequest estabelecimento;
    private CartaoRequest cartao;
    private Date efetivadaEm;

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoRequest getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoRequest getCartao() {
        return cartao;
    }

    public Date getEfetivadaEm() {
        return efetivadaEm;
    }

    public TransacaoRequest(String id, BigDecimal valor, EstabelecimentoRequest estabelecimento,
                            CartaoRequest cartao, Date efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public TransacaoRequest() {
    }

    public Transacao toTransacao() {
        return new Transacao(this.id, this.valor, this.estabelecimento.toEstabelecimento(),
                this.cartao.toCartao(), this.efetivadaEm);
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", estabelecimento=" + estabelecimento +
                ", cartao=" + cartao +
                ", efetivadaEm=" + efetivadaEm +
                '}';
    }
}
