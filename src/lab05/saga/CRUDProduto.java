package lab05.saga;

import lab05.identificavel.CRUDGeneral;

public class CRUDProduto extends CRUDGeneral {

    private String nomeFornecedor;

    public CRUDProduto(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String adiciona(String nomeProduto, String preco, String descricao) {
        Produto produto = new Produto(nomeProduto, preco, descricao);
        return this.adiciona(produto);
    }

    @Override
    public String exibeTodos() {
        return this.stringFactory.mapToString(this.mapaIdentificavel, nomeFornecedor);
    }

}
