package br.com.zupacademy.caio.transacao.dominio;

public class EstabelecimentoRequest {
    private String nome;
    private String cidade;
    private String endereco;

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public EstabelecimentoRequest(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public EstabelecimentoRequest() {
    }

    public Estabelecimento toEstabelecimento() {
        return new Estabelecimento(this.nome, this.cidade, this.endereco);
    }

    @Override
    public String toString() {
        return "Estabelecimento{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
