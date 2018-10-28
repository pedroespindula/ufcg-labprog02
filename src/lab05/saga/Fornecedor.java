package lab05.saga;

import lab05.identificavel.IdentificavelAbstract;

public class Fornecedor extends IdentificavelAbstract {

    private String nome;
    private String email;
    private String telefone;

    public Fornecedor(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    @Override
    public String getId() {
        return this.nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public void setAtributo(String nomeAtributo, String novoValor) {
        switch (nomeAtributo.toLowerCase()) {
            case "nome":
                throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
            case "email":
                this.email = novoValor;
                break;
            case "telefone":
                this.telefone = novoValor;
                break;
            default:
                throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
        }
    }

    @Override
    public String getAtributo(String nomeAtributo) {
        switch (nomeAtributo) {
            case "nome":
                return this.nome;
            case "email":
                return this.email;
            case "telefone":
                return this.telefone;
            default:
                throw new IllegalArgumentException("Erro no acesso de atributo do fornecedor: atributo nao existe.");
        }
    }


    @Override
    public String toString() {
        return this.nome + " - " + this.email + " - " + this.telefone;
    }

}
