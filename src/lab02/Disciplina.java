package lab02;

import java.util.Arrays;

/**
 * Representação de uma disciplina de universidade.
 *
 * @author João Pedro Santino Espindula - 188110035
 */
public class Disciplina {

    /**
     * Nome da disciplina. Usado como identificador.
     */
    private String nomeDisciplina;

    /**
     * Quantidade de horas registradas.
     */
    private int horas = 0;

    /**
     * Array de notas da disciplina.
     */
    private double[] notas;

    /**
     * Array de pesos da disciplina. Como padrão os pesos são iguais a um.
     * Os pesos são usados para o cálculo da média do aluno.
     */
    private int[] pesos;


    /**
     * Constroi um objeto disciplina a partir do nome da disciplina. Os
     * pesos são definidos como um e a quantidade de notas como quatro por
     * padrão.
     *
     * @param nomeDisciplina o nome da disciplina.
     */
    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new double[4];
        this.pesos = new int[4];

        elementosIgualUm(pesos);

    }

    /**
     * Constroi um objeto disciplina a partir do nome da disciplina e da
     * quantidade de notas. Os pesos são definidos como um por padrão.
     *
     * @param nomeDisciplina o nome da disciplina.
     * @param qntNotas       a quantidade de notas.
     */
    public Disciplina(String nomeDisciplina, int qntNotas) {
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new double[qntNotas];
        this.pesos = new int[qntNotas];

        elementosIgualUm(pesos);
    }

    /**
     * Constroi um objeto disciplina a partir do nome da disciplina, da
     * quantidade de notas, e dos pesos de cada nota.
     *
     * @param nomeDisciplina o nome da disciplina.
     * @param qntNotas       a quantidade de notas.
     * @param pesos          os pesos de cada nota.
     */
    public Disciplina(String nomeDisciplina, int qntNotas, int[] pesos) {
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new double[qntNotas];
        this.pesos = pesos;

    }

    /**
     * Muda todos os elementos de um array para um.
     *
     * @param array o array a ser modificado.
     */
    private static void elementosIgualUm(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }
    }

    /**
     * Cadastra uma quantidade de horas na disciplina.
     *
     * @param horas a quantidade de horas.
     */
    public void cadastraHoras(int horas) {
        this.horas += horas;
    }

    /**
     * Cadastra uma nota na disciplina.
     *
     * @param nota      a identificação da nota a ser cadastrada
     * @param valorNota o valor da nota.
     */
    public void cadastraNota(int nota, double valorNota) { // notas possíveis: 1, 2, 3 e 4
        this.notas[nota - 1] = valorNota;
    }

    /**
     * Verifica se o aluno foi aprovado
     *
     * @return se o aluno foi aprovado.
     */
    public boolean aprovado() {
        return this.getMedia() >= 7.0;
    }

    /**
     * Calcula a média na disciplina.
     *
     * @return a média.
     */
    private double getMedia() {
        double media = 0;
        int somaPesos = 0;
        for (int i = 0; i < notas.length; i++) {
            somaPesos += this.pesos[i];
            media += this.notas[i] * this.pesos[i];
        }
        System.out.println(media);

        if (notas.length == 0) {
            media = 0;
        } else {
            media /= somaPesos;
        }

        return media;

    }

    /**
     * Representação da disciplina.
     *
     * @return a representação da disciplina.
     */
    public String toString() {
        return this.nomeDisciplina + " " + this.horas + " " + this.getMedia() + " " + Arrays.toString(this.notas);
    }
}
