package lab02;

/**
 * Representação da saude de uma pessoa.
 *
 * @author João Pedro Santino Espíndula - 188110035
 */
public class Saude {

    /**
     * A saúde mental da pessoa. É definida por padrão como boa.
     */
    private String saudeMental = "boa";

    /**
     * A saúde física da pessoa. É definida por padrão como boa.
     */
    private String saudeFisica = "boa";

    /**
     * O emoji que representa o humor da pessoa.
     */
    private String emoji = "";

    /**
     * Flag que indica se um emoji foi registrado ou não.
     */
    private boolean emojiRegistrado = false;


    /**
     * Define a saude mental da pessoa a partir de um valor.
     *
     * @param valor o valor da saude mental.
     */
    public void defineSaudeMental(String valor) {

        this.verificaEmoji(this.saudeMental, valor);
        this.saudeMental = valor;

    }

    /**
     * Define a saúde física da pessoa a partir de um valor.
     *
     * @param valor o valor da saúde física.
     */
    public void defineSaudeFisica(String valor) {

        this.verificaEmoji(this.saudeFisica, valor);
        this.saudeFisica = valor;

    }

    /**
     * Define um emoji de humor para a saúde.
     *
     * @param emoji o emoji.
     */
    public void definirEmoji(String emoji) {

        this.emoji = emoji;
        emojiRegistrado = true;

    }

    /**
     * Verifica se um emoji vai vai ser resetado. Um emoji é resetado se
     * a saude for alterada.
     *
     * @param saude a saúde que tem possibilidade de ser alterada.
     * @param valor o valor que vai ser atribuido a saúde.
     */
    private void verificaEmoji(String saude, String valor) {

        if (!valor.equals(saude)) {
            emoji = "";
            emojiRegistrado = false;
        }

    }

    /**
     * Retorna e define o status geral da saúde da pessoa. O status geral
     * segue os seguintes aspectos:
     * 1. BOA: Se ambas as saúdes (Mental e física) forem boas.
     * 2. OK: Se as saúdes (Mental e física) forem diferentes.
     * 3. RUIM: Se ambas as saúdes (Mental e física) forem ruins.
     *
     * E se houver emoji registrado, ele adiciona esse emoji ao status.
     *
     * @return o status geral da sáude da pessoa.
     */
    public String getStatusGeral() {

        String stringRetorno = "";

        if (saudeFisica.equals(saudeMental)) {
            stringRetorno += saudeFisica;
        } else {
            stringRetorno += "ok";
        }

        if (emojiRegistrado) {
            stringRetorno += " " + emoji;
        }

        return stringRetorno;

    }

    /**
     * Representação da saúde de uma pessoa.
     *
     * @return representação da saúde de uma pessoa.
     */
    @Override
    public String toString() {

        return getStatusGeral();
    }


}
