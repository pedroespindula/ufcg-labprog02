package lab04;

import java.util.Objects;

/**
 * Classe de representação de um aluno.
 *
 * @author João Pedro Santino Espíndula - 118110035
 */
public class Aluno {

    /**
     * A matrícula do aluno. É usada como identificador do objeto.
     */
    private final String matricula;

    /**
     * O nome do aluno.
     */
    private final String nome;

    /**
     * O curso do aluno.
     */
    private final String curso;

    /**
     * Construtor que cria um aluno a partir de uma matrícula, de um nome e de um curso.
     *
     * @param matricula A matrícula do aluno.
     * @param nome O nome do aluno.
     * @param curso O curso do aluno.
     */
    public Aluno(String matricula, String nome, String curso) {

        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    /**
     * Compara se um objeto é igual ao objeto no qual o metodo foi chamado.
     * Ele faz essa comparação através da comparação do atributo matricula
     * dos dois objetos. Se o objeto comparado não for da classe Aluno o
     * método retorna false.
     *
     * @param obj O objeto a ser comparado.
     * @return Um booleano se o objeto é igual a Agenda em questão.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Aluno aluno = (Aluno) obj;
        return Objects.equals(matricula, aluno.matricula);
    }

    /**
     * Gera o HashCode do objeto a partir do atributo matrícula do objeto.
     *
     * @return O HashCode gerado.
     */
    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    /**
     * Retorna a representação do objeto Aluno que segue o modelo:
     * Matrícula - Nome - Curso
     *
     * @return a representação do objeto Aluno.
     */
    @Override
    public String toString() {
        return this.matricula + " - " + this.nome + " - " + this.curso;
    }
}
