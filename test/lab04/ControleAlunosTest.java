package lab04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de testes da classe ControleAlunos
 */
class ControleAlunosTest {

    /**
     * A matricula padrão usada nos testes.
     */
    private String matriculaPadrao;

    /**
     * O nome de aluno padrão usado nos testes.
     */
    private String nomeAlunoPadrao;

    /**
     * O nome de curso padrão usado nos testes.
     */
    private String cursoPadrao;

    /**
     * O nome de grupo padrão usado nos testes.
     */
    private String nomeGrupoPadrao;

    /**
     * O controle de alunos padrão usado nos testes.
     */
    private ControleAlunos controleAlunosPadrao;

    /**
     * Prepara o ambiente antes de cada metodo de teste.
     */
    @BeforeEach
    void init() {
        this.matriculaPadrao = "1";
        this.nomeAlunoPadrao = "Aluno";
        this.cursoPadrao = "Curso";
        this.nomeGrupoPadrao = "Grupo";

        this.controleAlunosPadrao = new ControleAlunos();
    }

    /**
     * Testa o cadastrarAluno em um cenário ideal.
     */
    @Test
    void testCadastrarAlunoIdeal() {
        controleAlunosPadrao.cadastrarAluno(matriculaPadrao, nomeAlunoPadrao, cursoPadrao);
        assertTrue(controleAlunosPadrao.contemAluno(matriculaPadrao));
    }

    /**
     * Testa o cadastrarGrupo em um cenário ideal.
     */
    @Test
    void testCadastrarGrupoIdeal() {
        controleAlunosPadrao.cadastrarGrupo(nomeGrupoPadrao);
        assertTrue(controleAlunosPadrao.contemGrupo(nomeGrupoPadrao));
    }

    /**
     * Testa o alocarAluno em um cenário ideal.
     */
    @Test
    void testAlocarAlunoIdeal() {
        testCadastrarAlunoIdeal();
        testCadastrarGrupoIdeal();
        controleAlunosPadrao.alocarAluno(nomeGrupoPadrao, matriculaPadrao);
        assertTrue(controleAlunosPadrao.getStringAlunosGrupo(nomeGrupoPadrao).contains(matriculaPadrao));
    }

    /**
     * Testa o alocarAluno quando se passa uma matricula de um aluno inexistente no sistema.
     */
    @Test
    void testAlocarAlunoInexistente() {
        testCadastrarGrupoIdeal();
        controleAlunosPadrao.alocarAluno(nomeGrupoPadrao, matriculaPadrao);
    }

    /**
     * Testa o getAluno num cenário ideal.
     */
    @Test
    void testGetAlunoIdeal() {
        testCadastrarAlunoIdeal();
        assertEquals("1 - Aluno - Curso", controleAlunosPadrao.getAluno(matriculaPadrao).toString());
    }

    /**
     * Testa o getAluno quando se passa uma matricula de um aluno inexistente no sistema.
     */
    @Test
    void testGetAlunoInexistente() {
        assertNull(controleAlunosPadrao.getAluno(matriculaPadrao));
    }

    /**
     * Testa o getStringAlunosResponderam num cenário ideal.
     */
    @Test
    void testGetStringAlunosResponderam() {
        testCadastrarAlunoIdeal();
        controleAlunosPadrao.cadastrarRespostaAluno(matriculaPadrao);
        assertEquals("1. 1 - Aluno - Curso", controleAlunosPadrao.getStringAlunosResponderam());
        controleAlunosPadrao.cadastrarRespostaAluno(matriculaPadrao);
        assertEquals("1. 1 - Aluno - Curso" + System.lineSeparator() +
                              "2. 1 - Aluno - Curso", controleAlunosPadrao.getStringAlunosResponderam());
    }
}