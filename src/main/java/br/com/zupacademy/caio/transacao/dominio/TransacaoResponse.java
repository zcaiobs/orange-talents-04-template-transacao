package br.com.zupacademy.caio.transacao.dominio;

import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.Date;

public class TransacaoResponse {
    private String id;
    private BigDecimal valor;
    private EstabelecimentoResponse estabelecimento;
    private CartaoResponse cartao;
    private Date efetivadaEm;

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoResponse getCartao() {
        return cartao;
    }

    public Date getEfetivadaEm() {
        return efetivadaEm;
    }

    public TransacaoResponse(String id, BigDecimal valor, EstabelecimentoResponse estabelecimento,
                            CartaoResponse cartao, Date efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public TransacaoResponse() {
    }

    public static Page<TransacaoResponse> converter(Page<Transacao> transacoes) {
        return transacoes.map(TransacaoResponse::converter);
    }

    public static TransacaoResponse converter(Transacao transacao) {
        return new TransacaoResponse(transacao.getId(), transacao.getValor(), EstabelecimentoResponse.converter(transacao.getEstabelecimento()),
                CartaoResponse.converter(transacao.getCartao()), transacao.getEfetivadaEm());
    }
}