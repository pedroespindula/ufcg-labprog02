package lab04;

import java.util.HashSet;
import java.util.Objects;

/**
 * Classe de representação de um grupo de alunos.
 *
 * @author João Pedro Santino Espíndula - 118110035
 */
public class Grupo {

    /**
     * O nome do grupo. É usado como identificador do objeto.
     */
    private final String nomeGrupo;

    /**
     * O conjunto de alunos que o grupo possui.
     */
    private HashSet<Aluno> setAlunos = new HashSet<>();

    /**
     * Cria um grupo a partir de um nome.
     *
     * @param nomeGrupo O nome do grupo.
     */
    public Grupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    /**
     * Aloca um aluno no grupo que o metodo foi chamado.
     *
     * @param aluno O aluno a ser alocado.
     */
    public void alocarAluno(Aluno aluno) {
        this.setAlunos.add(aluno);
    }

    /**
     * Retorna a String da lista de todos os alunos que o grupo possui.
     *
     * @return A String da lista de todos os alunos que o grupo possui.
     */
    public String getStringAlunos() {

        String representacao = "Alunos do grupo " + this.nomeGrupo + ":" + System.lineSeparator();
        StringBuilder stringBuilder = new StringBuilder();
        for (Aluno aluno : this.setAlunos) {
            stringBuilder.append("* ");
            stringBuilder.append(aluno.toString());
            stringBuilder.append(System.lineSeparator());
        }

        representacao += stringBuilder.toString().trim();

        return representacao;
    }

    /**
     * Verifica se o grupo contem o aluno recebido como parametro.
     *
     * @param aluno O aluno procurado.
     * @return Se o grupo possui o aluno ou não.
     */
    public boolean contemAlunoGrupo(Aluno aluno) {
        return this.setAlunos.contains(aluno);
    }

    /**
     * Compara se um objeto é igual ao objeto no qual o metodo foi chamado.
     * Ele faz essa comparação através do atributo nomeGrupo.
     * Se o objeto comparado não for da classe Grupo o método retorna false.
     *
     * @param obj O objeto a ser comparado.
     * @return Um booleano se o objeto é igual a Agenda em questão.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Grupo grupo = (Grupo) obj;
        return Objects.equals(nomeGrupo, grupo.nomeGrupo);
    }

    /**
     * Gera um HashCode a partir do atributo nomeGrupo.
     *
     * @return O HashCode gerado.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nomeGrupo);
    }

    /**
     * Retorna a representação do objeto da classe Grupo que é apenas o
     * atributo nomeGrupo.
     *
     * @return A representação do objeto.
     */
    @Override
    public String toString() {
        return this.nomeGrupo;
    }
}
