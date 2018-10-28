package lab05.saga;

import lab05.identificavel.CRUDGeneral;

public class CRUDFornecedor extends CRUDGeneral {

    public String adiciona(String nome, String email, String telefone) {
        Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
        return this.adiciona(fornecedor);
    }

}
