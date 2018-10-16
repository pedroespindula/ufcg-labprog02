package lab04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de testes para a classe Grupo.
 */
class GrupoTest {

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
     * O aluno padrão usado nos testes.
     */
    private Aluno alunoPadrao;

    /**
     * O nome de grupo padrão usado nos testes.
     */
    private String nomeGrupoPadrao;

    /**
     * O grupo padrão usado nos testes.
     */
    private Grupo grupoPadrao;

    /**
     * Prepara o ambiente antes de cada metodo de teste.
     */
    @BeforeEach
    void init() {
        this.matriculaPadrao = "1";
        this.nomeAlunoPadrao = "Aluno";
        this.cursoPadrao = "Curso";
        this.alunoPadrao = new Aluno(matriculaPadrao, nomeAlunoPadrao, cursoPadrao);

        this.nomeGrupoPadrao = "Grupo";
        this.grupoPadrao = new Grupo(nomeGrupoPadrao);
    }

    /**
     * Testa o alocarAluno em um cenário ideal.
     */
    @Test
    void testAlocarAluno() {
        grupoPadrao.alocarAluno(alunoPadrao);
        assertTrue(grupoPadrao.contemAlunoGrupo(alunoPadrao));
    }

    /**
     * Testa o getAlunos em um cenário ideal.
     */
    @Test
    void testGetAlunos() {
        testAlocarAluno();
        assertEquals("Alunos do grupo Grupo:" + System.lineSeparator() +
                              "* 1 - Aluno - Curso", grupoPadrao.getStringAlunos());
    }

    // EQUALS

    /**
     * Testa o equals em um cenário ideal.
     */
    @Test
    void testEqualsIgual() {
        Grupo grupoIgual = new Grupo(nomeGrupoPadrao);
        assertNotSame(grupoPadrao, grupoIgual);
        assertEquals(grupoPadrao, grupoIgual);
    }

    /**
     * Testa o equals quando o nome dos grupos são diferentes.
     */
    @Test
    void testEqualsNomeDiferente() {
        Grupo grupoIgual = new Grupo(nomeGrupoPadrao + "X");
        assertNotSame(grupoPadrao, grupoIgual);
        assertNotEquals(grupoPadrao, grupoIgual);
    }

    /**
     * Testa o equals quando é comparado ao mesmo objeto.
     */
    @Test
    void testEqualsMesmoObjeto() {
        assertEquals(grupoPadrao, grupoPadrao);
    }

    /**
     * Testa o equals quando é comparado com um null.
     */
    @Test
    void testEqualsObjetoNull() {
        assertNotEquals(grupoPadrao, null);
    }

    /**
     * Testa o equals quando é comparado com um objeto de outra classe.
     */
    @Test
    void testEqualsClasseDiferente() {
        assertNotEquals(grupoPadrao, "1");
    }

    // HASHCODE

    /**
     * Testa o HashCode quando o nome é igual.
     */
    @Test
    void testHashcodeIgual() {
        Grupo grupoIgual = new Grupo(nomeGrupoPadrao);
        assertNotSame(grupoPadrao, grupoIgual);
        assertEquals(grupoPadrao.hashCode(), grupoIgual.hashCode());
    }

    /**
     * Testa o HashCode quando o nome é diferente
     */
    @Test
    void testHashcodeNomeDiferente() {
        Grupo grupoIgual = new Grupo(nomeGrupoPadrao + "X");
        assertNotSame(grupoPadrao, grupoIgual);
        assertNotEquals(grupoPadrao.hashCode(), grupoIgual.hashCode());
    }

    /**
     * Testa o toString.
     */
    @Test
    void testToString() {
        assertEquals("Grupo", grupoPadrao.toString());
    }
}