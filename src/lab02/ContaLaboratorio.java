package lab02;

/**
 * Representação de uma conta de laboratório, mais especificamente da UFCG.
 * Toda conta precisa ter um nome e uma cota de espaço armazenado. Essa cota
 * é definida por padrão como sendo 2000 MB.
 *
 * @author João Pedro Santino Espíndula - 118110035
 */
public class ContaLaboratorio {

    /**
     * Nome do laboratório da conta.
     */
    private String nomeLaboratorio;

    /**
     * Cota da conta. É definida por padrão como 2000 MB mas pode ser
     * alterada na criação de um objeto da classe ContaLaboratorio através
     * do construtor.
     */
    private int cota = 2000; // em MB

    /**
     * Espaço de armazenamento ocupado pela conta.
     */
    private int espacoOcupado = 0;


    /**
     * Constroi uma conta de laboratório a partir do nome do laboratório.
     *
     * @param nomeLaboratorio o nome do laboratório
     */
    public ContaLaboratorio(String nomeLaboratorio) {
        this.nomeLaboratorio = nomeLaboratorio;
    }

    /**
     * Constroi uma conta de laboratório a partir do nome do laboratório e da cota.
     *
     * @param nomeLaboratorio o nome do laboratório.
     * @param cota            a cota do laboratório.
     */
    public ContaLaboratorio(String nomeLaboratorio, int cota) {
        this.nomeLaboratorio = nomeLaboratorio;
        this.cota = cota;
    }


    /**
     * Consome espaço na conta de laboratório.
     *
     * @param mbytes quantidade de espaço consumido.
     */
    public void consomeEspaco(int mbytes) {
        this.espacoOcupado += mbytes;
    }

    /**
     * Libera espaço na conta de laboratório.
     *
     * @param mbytes quantidade de espaço liberado.
     */
    public void liberaEspaco(int mbytes) {
        if (this.espacoOcupado - mbytes < 0) {
            this.espacoOcupado = 0;
        } else {
            this.espacoOcupado -= mbytes;
        }
    }

    /**
     * Retorna se a conta atingiu a cota estipulada.
     *
     * @return se atingiu a cota da conta ou não.
     */
    public boolean atingiuCota() {
        return espacoOcupado >= cota;
    }

    /**
     * A representação da conta de laboratório segue o formato
     * "NOME DO LABORATORIO - ESPAÇO OCUPADO - COTA"
     *
     * @return a representação da conta de laboratório.
     */
    @Override
    public String toString() {
        return this.nomeLaboratorio + " " + this.espacoOcupado + "/" + this.cota;
    }

}
