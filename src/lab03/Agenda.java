package lab03;


/**
 * Classe para manipulação de contatos da classe Contato atraves de um array.
 *
 * @author João Pedro Santino Espíndula - 118110035
 */
public class Agenda {

    /**
     * Array de contatos da classe Contato.
     */
    private Contato[] contatos;

    /**
     * Cria uma agenda a partir da quantidade de contatos.
     *
     * @param qntContatos A quantidade de contatos.
     */
    public Agenda (int qntContatos) {
        this.contatos = new Contato[qntContatos];
    }

    /**
     * Cria uma agenda com quantidade de contatos padrão igual a 99.
     */
    public Agenda () {
        this.contatos = new Contato[99];
    }

    public int getLenght() {
        return contatos.length;
    }

    /**
     * Cadastra um contato na agenda em questão.
     *
     * @param nome O nome do contato.
     * @param sobrenome O sobrenome do contato.
     * @param telefone O telefone do contato.
     * @param posicao A posição do contato na agenda.
     */
    public void cadastrarContato(String nome, String sobrenome, String telefone, int posicao) {

        Contato contato = new Contato(nome, sobrenome, telefone);

        this.contatos[posicao - 1] = contato;

    }

    /**
     * Retorna um contato da agenda a partir da posição dele.
     *
     * @param posicao A posição do contato.
     * @return O contato procurado.
     */
    public Contato acharContato(int posicao) {
        return this.contatos[posicao - 1];
    }

    /**
     * Compara se um objeto é igual ao objeto no qual o metodo foi chamado.
     * Ele faz essa comparação através da comparação da representação de
     * strings dos dois objetos.
     *
     * @param obj O objeto a ser comparado.
     * @return Um booleano se o objeto é igual a Agenda em questão.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Agenda)) {
            return false;
        }
        Agenda agenda = (Agenda) obj;
        return agenda.toString().equals(this.toString());
    }

    /**
     * Representação da Agenda em string.
     *
     * @return A string da agenda.
     */
    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder(100);

        for (int i = 0; i < contatos.length; i++) {
            Contato contato = contatos[i];
            if (contato != null) {
                stringBuilder.append(i + 1);
                stringBuilder.append(" - ");
                stringBuilder.append(contato.getNomeCompleto());
                stringBuilder.append(System.lineSeparator());
            }
        }

        String stringRetorno = stringBuilder.toString().trim();

        if (stringRetorno.equals("")) {
            return "Agenda vazia.";
        } else {
            return stringRetorno;
        }
    }

}
