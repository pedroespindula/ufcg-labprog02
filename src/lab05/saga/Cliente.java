package lab05.saga;

import lab05.identificavel.Identificavel;
import lab05.identificavel.IdentificavelAbstract;

public class Cliente extends IdentificavelAbstract {

    private String cpf;
    private String nome;
    private String email;
    private String localizacao;

    public Cliente(String cpf, String nome, String email, String localizacao) {
        super();
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.localizacao = localizacao;
    }

    @Override
    public String getId() {
        return this.cpf;
    }

    @Override
    public void setAtributo(String nomeAtributo, String novoValor) {
        switch (nomeAtributo.toLowerCase()) {
            case "cpf":
                throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
            case "nome":
                this.nome = novoValor;
                break;
            case "email":
                this.email = novoValor;
                break;
            case "localizacao":
                this.localizacao = novoValor;
                break;
            default:
                throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
        }
    }

    @Override
    public String getAtributo(String nomeAtributo) {
        switch (nomeAtributo) {
            case "cpf":
                throw new IllegalArgumentException("Erro no acesso de atributo do cliente: cpf nao pode ser acessado.");
            case "nome":
                return this.nome;
            case "email":
                return this.email;
            case "localizacao":
                return this.localizacao;
            default:
                throw new IllegalArgumentException("Erro no acesso de atributo do cliente: atributo nao existe.");
        }
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.localizacao + " - " +this.email;
    }

    @Override
    public int compareTo(Identificavel identificavel) {
        return getAtributo("nome").compareTo(identificavel.getAtributo("nome"));
    }
}
