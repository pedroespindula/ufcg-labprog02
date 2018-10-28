package lab05.saga;

import lab05.identificavel.CRUDGeneral;

public class CRUDCliente extends CRUDGeneral {

    public String adiciona(String cpf, String nome, String email, String localizacao) {
        Cliente cliente = new Cliente(cpf, nome, email, localizacao);
        return this.adiciona(cliente);
    }
}
