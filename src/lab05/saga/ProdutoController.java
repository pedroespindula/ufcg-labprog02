package lab05.saga;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProdutoController {

    private Map<String, CRUDProduto> mapaCRUDProduto;

    public ProdutoController() {
        this.mapaCRUDProduto = new TreeMap<>();
    }

    public void cadastrarNovoCrud(String nomeFornecedor) {
        this.mapaCRUDProduto.putIfAbsent(nomeFornecedor, new CRUDProduto(nomeFornecedor));
    }

    public String adiciona(String nomeFornecedor, String nomeProduto, String preco, String descricao) {
        return this.getCRUDProduto(nomeFornecedor).adiciona(nomeProduto, preco, descricao);
    }

    public String exibeProduto(String nomeFornecedor, String nomeProduto, String descricaoProduto) {
        return this.getCRUDProduto(nomeFornecedor).exibe(this.getProdutoId(nomeProduto, descricaoProduto));
    }

    public String exibeProdutosFornecedor(String nomeFornecedor) {
        return this.getCRUDProduto(nomeFornecedor).exibeTodos();
    }

    public String exibeProdutos() {

        String stringRetorno = "";

        for (CRUDProduto crudProduto : mapaCRUDProduto.values()) {
            stringRetorno += crudProduto.exibeTodos() + " | ";
        }

        if (stringRetorno.length() > 3) {
            return stringRetorno.substring(0, stringRetorno.length() - 3);
        }
        return "";
    }

    public void edita(String nomeFornecedor, String nomeProduto, String descricaoProduto, String novoValor) {
        this.getCRUDProduto(nomeFornecedor).edita(this.getProdutoId(nomeProduto, descricaoProduto),"preco", novoValor);
    }

    public void remove(String nomeFornecedor, String nomeProduto, String descricaoProduto) {
        this.getCRUDProduto(nomeFornecedor).remove(this.getProdutoId(nomeProduto, descricaoProduto));
    }

    public void removeCRUDFornecedor(String nome) {
        this.mapaCRUDProduto.remove(nome);
    }

    public boolean contains(String fornecedor) {
        return mapaCRUDProduto.containsKey(fornecedor);
    }

    public boolean crudContains(String fornecedor, String nome, String descricao) {
        return this.getCRUDProduto(fornecedor).contains(getProdutoId(nome, descricao));
    }

    private String getProdutoId(String nomeProduto, String descricaoProduto) {
        return nomeProduto + " - " + descricaoProduto;
    }

    private CRUDProduto getCRUDProduto(String nomeFornecedor) {
        return this.mapaCRUDProduto.get(nomeFornecedor);
    }

    public void adicionaCombo(String fornecedor, String nome, String descricao, String fator, String produtos) {
        
    }
}
