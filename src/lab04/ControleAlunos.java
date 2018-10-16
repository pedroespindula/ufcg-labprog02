package lab04;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe para manipulação de Alunos e Grupos.
 */
public class ControleAlunos {

    /**
     * O mapa de alunos.
     */
    private HashMap<String, Aluno> mapaAlunos = new HashMap<>();

    /**
     * O mapa de grupos.
     */
    private HashMap<String, Grupo> mapaGrupos = new HashMap<>();

    /**
     * A lista de alunos que responderam à alguma pergunta no quadro.
     */
    private ArrayList<Aluno> listaAlunosResponderam = new ArrayList<>();

    /**
     * Verifica se o controle contem o aluno em questão.
     *
     * @param matricula A matrícula do aluno.
     * @return Se o controle contem o aluno.
     */
    public boolean contemAluno(String matricula) {

        return this.mapaAlunos.containsKey(matricula);

    }

    /**
     * Verifica se o controle contem o grupo em questão.
     *
     * @param nomeGrupo O nome do grupo.
     * @return Se o controle contem o grupo.
     */
    public boolean contemGrupo(String nomeGrupo) {

        return this.mapaGrupos.containsKey(nomeGrupo.toUpperCase());

    }

    /**
     * Retorna o objeto Aluno a partir de uma matrícula.
     *
     * @param matricula A matrícula do aluno.
     * @return O objeto Aluno procurado.
     */
    public Aluno getAluno(String matricula) {
        return this.mapaAlunos.get(matricula);
    }

    /**
     * Retorna a String de todos os alunos do grupo a partir do nome do grupo..
     *
     * @param nomeGrupo O nome do grupo.
     * @return A String de todos os alunos do grupo.
     */
    public String getStringAlunosGrupo(String nomeGrupo) {

        return this.mapaGrupos.get(nomeGrupo.toUpperCase()).getStringAlunos();

    }

    /**
     * Retorna a String de todos os alunos que responderam uma questão no quadro.
     *
     * @return A String dos alunos que responderam uma questão no quadro.
     */
    public String getStringAlunosResponderam() {

        return this.enumElements(this.listaAlunosResponderam);

    }

    /**
     * Cadastra um aluno no controle de alunos.
     *
     * @param matricula A matrícula do aluno.
     * @param nomeAluno O nome do aluno.
     * @param curso O nome do curso do aluno.
     */
    public void cadastrarAluno(String matricula, String nomeAluno, String curso) {

        Aluno novoAluno = new Aluno(matricula, nomeAluno, curso);

        this.mapaAlunos.put(matricula, novoAluno);

    }

    /**
     * Cadastra um grupo no controle de alunos.
     *
     * @param nomeGrupo O nome do grupo.
     */
    public void cadastrarGrupo(String nomeGrupo) {

        Grupo novoGrupo = new Grupo(nomeGrupo);

        this.mapaGrupos.put(nomeGrupo.toUpperCase(), novoGrupo);

    }

    /**
     * Aloca um aluno já registrado no controle em um grupo que também está registrado
     * no controle.
     *
     * @param nomeGrupo O nome do grupo.
     * @param matricula A matricula do aluno.
     */
    public void alocarAluno(String nomeGrupo, String matricula) {
        Grupo grupo = this.mapaGrupos.get(nomeGrupo.toUpperCase());
        Aluno aluno = this.mapaAlunos.get(matricula);

        grupo.alocarAluno(aluno);

    }

    /**
     * Cadastra a resposta de um aluno.
     *
     * @param matricula A matricula do aluno que respondeu.
     */
    public void cadastrarRespostaAluno(String matricula) {
        Aluno aluno = this.mapaAlunos.get(matricula);
        this.listaAlunosResponderam.add(aluno);
    }

    /**
     * Enumera elementos de um ArrayList
     *
     * @param arrayList O arrayList
     * @return A String enumerada de todos os elementos.
     */
    private String enumElements(ArrayList arrayList) {

        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (Object object : arrayList) {
            stringBuilder.append(++i);
            stringBuilder.append(". ");
            stringBuilder.append(object.toString());
            stringBuilder.append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();

    }

}
