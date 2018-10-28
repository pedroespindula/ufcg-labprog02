package lab05.saga;


public class SAGAFacade {

    private CRUDCliente CRUDCliente;
    private CRUDFornecedor CRUDFornecedor;
    private ProdutoController produtoController;
    private ErrorThrower errorThrower;

    public SAGAFacade() {
        this.CRUDCliente = new CRUDCliente();
        this.CRUDFornecedor = new CRUDFornecedor();
        this.produtoController = new ProdutoController();
        this.errorThrower = new ErrorThrower();
    }

    // CLIENTE
    public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
        errorThrower.adicionaCliente(cpf, nome, email, localizacao, CRUDCliente);
        return this.CRUDCliente.adiciona(cpf, nome, email, localizacao);
    }

    public String exibeCliente(String cpf) {
        errorThrower.exibeCliente(cpf, CRUDCliente);
        return this.CRUDCliente.exibe(cpf);
    }

    public String exibeClientes() {
        return this.CRUDCliente.exibeTodos();
    }

    public void editaCliente(String cpf, String atributo, String novoValor) {
        errorThrower.editaCliente(cpf, atributo, novoValor, CRUDCliente);
        this.CRUDCliente.edita(cpf, atributo, novoValor);
    }

    public void removeCliente(String cpf) {
        errorThrower.removeCliente(cpf);
        this.CRUDCliente.remove(cpf);
    }


    // FORNECEDOR
    public String adicionaFornecedor(String nome, String email, String telefone) {
        errorThrower.adicionaFornecedor(nome, email, telefone, CRUDFornecedor);
        this.produtoController.cadastrarNovoCrud(nome);
        return this.CRUDFornecedor.adiciona(nome, email, telefone);
    }

    public String exibeFornecedor(String nome) {
        errorThrower.exibeFornecedor(nome, CRUDFornecedor);
        return this.CRUDFornecedor.exibe(nome);
    }

    public String exibeFornecedores() {
        return this.CRUDFornecedor.exibeTodos();
    }

    public void editaFornecedor(String nome, String atributo, String novoValor) {
        errorThrower.editaFornecedor(nome, atributo, novoValor, CRUDFornecedor);
        this.CRUDFornecedor.edita(nome, atributo, novoValor);
    }

    public void removeFornecedor(String nome) {
        errorThrower.removeFornecedor(nome);
        this.CRUDFornecedor.remove(nome);
        this.produtoController.removeCRUDFornecedor(nome);
    }


    //PRODUTO
    public String adicionaProduto(String fornecedor, String nome, String descricao, String preco) {
        errorThrower.adicionaProduto(fornecedor, nome, preco, descricao, produtoController);
        return this.produtoController.adiciona(fornecedor, nome, preco, descricao);
    }

    public String exibeProduto(String nome, String descricao, String fornecedor) {
        errorThrower.exibeProduto(fornecedor, nome, descricao, produtoController);
        return this.produtoController.exibeProduto(fornecedor, nome, descricao);
    }

    public String exibeProdutosFornecedor(String fornecedor) {
        errorThrower.exibeProdutosFornecedor(fornecedor, produtoController);
        return this.produtoController.exibeProdutosFornecedor(fornecedor);
    }

    public String exibeProdutos() {
        return this.produtoController.exibeProdutos();
    }

    public void editaProduto(String nome, String descricao, String fornecedor, String novoValor) {
        errorThrower.editaProduto(fornecedor, nome, descricao, novoValor, produtoController);
        this.produtoController.edita(fornecedor, nome, descricao, novoValor);
    }

    public void removeProduto(String nome, String descricao, String fornecedor) {
        errorThrower.removeProduto(fornecedor, nome, descricao, produtoController);
        this.produtoController.remove(fornecedor, nome, descricao);
    }


}
