package lab05.saga;

public class ErrorThrower {

    // Cliente
    public void adicionaCliente(String cpf, String nome, String email, String localizacao, CRUDCliente crudCliente) {
        if (cpf == null || cpf.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
        }
        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
        }
        if (email == null || email.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
        }
        if (localizacao == null || localizacao.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
        }

        if (cpf.length() != 11) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
        }
        if (crudCliente.contains(cpf)) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
        }
    }

    public void exibeCliente(String cpf, CRUDCliente crudCliente) {
        if (!crudCliente.contains(cpf)) {
            throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
        }
    }

    public void editaCliente(String cpf, String atributo, String novoValor, CRUDCliente crudCliente) {
        if (cpf == null || cpf.trim().equals("")) {
            throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
        }
        if (atributo == null || atributo.trim().equals("")) {
            throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
        }
        if (novoValor == null || novoValor.trim().equals("")) {
            throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
        }

        if (!crudCliente.contains(cpf)) {
            throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
        }
    }

    public void removeCliente(String cpf) {
        if (cpf == null || cpf.trim().equals("")) {
            throw new IllegalArgumentException("Erro na remocao do cliente: cpf nao pode ser vazio ou nulo.");
        }
    }

    // Fornecedor
    public void adicionaFornecedor(String nome, String email, String telefone, CRUDFornecedor crudFornecedor) {
        if (nome == null || nome.trim().equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        }
        if (email == null || email.trim().equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        }
        if (telefone == null || telefone.trim().equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
        }

        if (crudFornecedor.contains(nome)) {
            throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
        }
    }

    public void exibeFornecedor(String nome, CRUDFornecedor crudFornecedor) {
        if (nome == null || nome.trim().equals("")) {
            throw new IllegalArgumentException("Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.");
        }

        if (!crudFornecedor.contains(nome)) {
            throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
        }
    }

    public void editaFornecedor(String nome, String atributo, String novoValor, CRUDFornecedor crudFornecedor) {
        if (nome == null || nome.trim().equals("")) {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
        }
        if (atributo == null || atributo.trim().equals("")) {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
        }
        if (novoValor == null || novoValor.trim().equals("")) {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
        }

        if (!crudFornecedor.contains(nome)) {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
        }
    }

    public void removeFornecedor(String nome) {
        if (nome == null || nome.trim().equals("")) {
            throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
        }
    }

    // Produto
    public void adicionaProduto(String fornecedor, String nome, String preco, String descricao, ProdutoController produtoController) {
        if (fornecedor == null || fornecedor.trim().equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
        }
        if (nome == null || nome.trim().equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        }
        if (descricao == null || descricao.trim().equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
        }
        if (preco == null || preco.trim().equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de produto: preco nao pode ser vazio ou nulo.");
        }

        if (Double.parseDouble(preco) < 0) {
            throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
        }
        if (!produtoController.contains(fornecedor)) {
            throw new NullPointerException("Erro no cadastro de produto: fornecedor nao existe.");
        }
        if (produtoController.crudContains(fornecedor, nome, descricao)) {
            throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
        }

    }


    public void exibeProduto(String fornecedor, String nome, String descricao, ProdutoController produtoController) {
        if (fornecedor == null || fornecedor.trim().equals("")) {
            throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
        }
        if (nome == null || nome.trim().equals("")) {
            throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
        }
        if (descricao == null || descricao.trim().equals("")) {
            throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
        }
        if (!produtoController.contains(fornecedor)) {
            throw new NullPointerException("Erro na exibicao de produto: fornecedor nao existe.");
        }
        if (!produtoController.crudContains(fornecedor, nome, descricao)) {
            throw new NullPointerException("Erro na exibicao de produto: produto nao existe.");
        }
    }

    public void exibeProdutosFornecedor(String fornecedor, ProdutoController produtoController) {
        if (fornecedor == null || fornecedor.trim().equals("")) {
            throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
        }
        if (!produtoController.contains(fornecedor)) {
            throw new NullPointerException("Erro na exibicao de produto: fornecedor nao existe.");
        }
    }


    public void editaProduto(String fornecedor, String nome, String descricao, String novoValor, ProdutoController produtoController) {
        if (fornecedor == null || fornecedor.trim().equals("")) {
            throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
        }
        if (nome == null || nome.trim().equals("")) {
            throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
        }
        if (descricao == null || descricao.trim().equals("")) {
            throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
        }
        if (!produtoController.contains(fornecedor)) {
            throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
        }
        if (Double.parseDouble(novoValor) < 0) {
            throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
        }
    }

    public void removeProduto(String fornecedor, String nome, String descricao, ProdutoController produtoController) {
        if (fornecedor == null || fornecedor.trim().equals("")) {
            throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
        }
        if (nome == null || nome.trim().equals("")) {
            throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
        }
        if (descricao == null || descricao.trim().equals("")) {
            throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
        }
        if (!produtoController.contains(fornecedor)) {
            throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
        }
        if (!produtoController.crudContains(fornecedor, nome, descricao)) {
            throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
        }
    }

}
