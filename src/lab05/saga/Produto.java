package lab05.saga;

import lab05.identificavel.IdentificavelAbstract;

import java.text.DecimalFormat;

public class Produto extends IdentificavelAbstract {

    private String nome;
    private double preco;
    private String descricao;

    public Produto(String nome, String preco, String descricao) {
        this.nome = nome;
        this.preco = Double.parseDouble(preco);
        this.descricao = descricao;
    }

    @Override
    public String getId() {
        return this.nome + " - " + this.descricao;
    }

    @Override
    public void setAtributo(String nomeAtributo, String novoValor) {
        switch (nomeAtributo.toLowerCase()) {
            case "nome":
                throw new IllegalArgumentException("Erro na edicao do produto: nome nao pode ser editado.");
            case "descricao":
                throw new IllegalArgumentException("Erro na edicao do produto: descricao nao pode ser editada.");
            case "preco":
                this.preco = Double.parseDouble(novoValor);
                break;
            default:
                throw new IllegalArgumentException("Erro na edicao do produto: atributo nao existe.");
        }
    }

    @Override
    public String getAtributo(String nomeAtributo) {
        switch (nomeAtributo) {
            case "nome":
                return this.nome;
            case "descricao":
                return this.descricao;
            case "preco":
                return Double.toString(this.preco);
            default:
                throw new IllegalArgumentException("Erro no acesso de atributo do produto: atributo nao existe.");
        }
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("R$#,##0.00");
        String precoFormatado = formatter.format(this.preco);
        return this.nome + " - " + this.descricao + " - " + precoFormatado;
    }

}
