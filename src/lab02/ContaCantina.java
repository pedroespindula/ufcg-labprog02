package lab02;

/**
 * Representação de uma conta de uma cantina.
 *
 * @author João Pedro Santino Espíndula - 118110035
 */
public class ContaCantina {

    /**
     * Nome da cantina. Usado como identificador.
     */
    private String nomeCantina;

    /**
     * Quantidade de itens comprados.
     */
    private int qtdItens = 0;

    /**
     * Valor total consumido em centavos.
     */
    private int valorConsumidoCentavos = 0;

    /**
     * Valor total que foi pago em centavos.
     */
    private int valorPagoCentavos = 0;

    /**
     * Array de detalhes sobre os lanches cadastrados.
     */
    private String[] detalhes = new String[]{"-", "-", "-", "-", "-"};


    /**
     * Constroi uma conta de uma cantina com o nome da cantina.
     *
     * @param nomeCantina o nome da cantina.
     */
    public ContaCantina(String nomeCantina) {

        this.nomeCantina = nomeCantina;

    }

    /**
     * Cadastra um lanche na conta a partir da quantidade de itens comprados
     * e do valor da compra em centavos.
     *
     * @param qtdItens      quantidade de itens comprados.
     * @param valorCentavos valor da compra em centavos
     */
    public void cadastraLanche(int qtdItens, int valorCentavos) {

        this.qtdItens += qtdItens;
        this.valorConsumidoCentavos += valorCentavos;
        this.adicionaDetalhes("-");

    }

    /**
     * Cadastra um lanche na conta a partir da quantidade de itens comprados,
     * do valor da compra em centavos e dos detalhes da compra.
     *
     * @param qtdItens      quantidade de itens comprados.
     * @param valorCentavos valor da compra em centavos
     * @param detalhe       os detalhes referente a compra.
     */
    public void cadastraLanche(int qtdItens, int valorCentavos, String detalhe) {

        this.qtdItens += qtdItens;
        this.valorConsumidoCentavos += valorCentavos;
        this.adicionaDetalhes(detalhe);

    }

    /**
     * Adiciona detalhes ao array de detalhes da conta.
     *
     * @param detalhe o detalhe a ser adicionado.
     */
    private void adicionaDetalhes(String detalhe) {

        String[] novoArray = new String[5];
        System.arraycopy(this.detalhes, 1, novoArray, 0, 4);
        novoArray[4] = detalhe;
        this.detalhes = novoArray;

    }

    /**
     * Lista os ultimos 5 detalhes da conta.
     */
    public void listarDetalhes() {

        System.out.println("Histórico de detalhes:");
        int i = 1;
        for (String detalhe : this.detalhes) {
            System.out.println(i + ". " + detalhe);
            i++;
        }

    }

    /**
     * Paga um valor em centavos na cantina da cantina.
     *
     * @param valorCentavos o valor a ser pago.
     */
    public void pagaConta(int valorCentavos) {

        this.valorPagoCentavos += valorCentavos;

    }

    /**
     * Retorna o que falta pagar na conta da cantina.
     *
     * @return o valor pago.
     */
    public int getFaltaPagar() {

        return valorConsumidoCentavos - valorPagoCentavos;

    }


    /**
     * Representação da conta da cantina.
     *
     * @return a representação da conta da cantina.
     */
    @Override
    public String toString() {

        return this.nomeCantina + " " + this.qtdItens + " " + this.valorConsumidoCentavos;

    }
}

