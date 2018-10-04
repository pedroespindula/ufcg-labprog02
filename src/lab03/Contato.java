package lab03;

/**
 * Representação de um contato.
 */
public class Contato {

    /**
     * O nome do contato.
     */
    private String nome;

    /**
     * O sobrenome do contato.
     */
    private String sobrenome;

    /**
     * O telefone do contato.
     */
    private String telefone;

    /**
     * Constroi um contato a partir do nome, sobrenome e do telefone.
     *
     * @param nome O nome do contato.
     * @param sobrenome O sobrenome do contato.
     * @param telefone O telefone do contato.
     */
    public Contato(String nome, String sobrenome, String telefone) {

        this.garantirIntegridadeDados(nome, sobrenome, telefone);

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
    }

    /**
     * Garante que os dados que chegam no construtor sejam validos. Se não forem, o metodo lança exceções.
     *
     * @param nome O nome do contato.
     * @param sobrenome O sobrenome do contato.
     * @param telefone O telefone do contato.
     */
    public void garantirIntegridadeDados(String nome, String sobrenome, String telefone) {

        if (nome == null || sobrenome == null || telefone == null) {
            throw new NullPointerException("Argumento nulo");
        }

        if (nome.equals("") || sobrenome.equals("") || telefone.equals("")) {
            throw new IllegalArgumentException("Argumento vazio");
        }

    }

    /**
     * Retorna o nome do contato.
     *
     * @return O nome do contato.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o sobrenome do contato.
     *
     * @return O sobrenome do contato.
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * Retorna o nome completo do contato.
     *
     * @return O nome completo do contato.
     */
    public String getNomeCompleto() { return  nome + " " + sobrenome; }

    /**
     * Retorna o telefone do contato.
     *
     * @return O telefone do contato.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Compara se um objeto é igual ao objeto no qual o metodo foi chamado.
     * Ele faz essa comparação através da comparação da representação de
     * strings dos dois objetos.
     *
     * @param obj O objeto a ser comparado.
     * @return Um booleano se o objeto é igual ao Contato em questão.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Contato)) {
            return false;
        }
        Contato contato = (Contato)obj;
        return contato.toString().equals(this.toString());
    }

    /**
     * Representação do Contato em string.
     *
     * @return A string do contato.
     */
    @Override
    public String toString() {
        return this.nome + " " + this.sobrenome + " - " + this.telefone;
    }

}
