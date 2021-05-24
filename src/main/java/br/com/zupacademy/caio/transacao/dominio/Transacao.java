package br.com.zupacademy.caio.transacao.dominio;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Transacao {
    @Id
    private String id;
    private BigDecimal valor;
    @OneToOne @Cascade(CascadeType.MERGE)
    private Estabelecimento estabelecimento;
    @OneToOne @Cascade(CascadeType.MERGE)
    private Cartao cartao;
    private Date efetivadaEm;

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public Date getEfetivadaEm() {
        return efetivadaEm;
    }

    public Transacao(String id, BigDecimal valor, Estabelecimento estabelecimento,
                            Cartao cartao, Date efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public Transacao() {
    }
}
