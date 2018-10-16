package lab04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de testes da classe Aluno.
 *
 * @author João Pedro Santino Espíndula - 118110035
 */
class AlunoTest {

    /**
     * A matricula padrão usada nos testes.
     */
    private String matriculaPadrao;

    /**
     * O nome padrão usado nos testes.
     */
    private String nomePadrao;

    /**
     * O curso padrão usado nos testes.
     */
    private String cursoPadrao;

    /**
     * O aluno padrão usado nos testes.
     */
    private Aluno alunoPadrao;

    /**
     * Prepara o ambiente antes de cada metodo de teste.
     */
    @BeforeEach
    void init() {
        this.matriculaPadrao = "1";
        this.nomePadrao = "Nome";
        this.cursoPadrao = "Curso";
        this.alunoPadrao = new Aluno(matriculaPadrao, nomePadrao, cursoPadrao);
    }

    // EQUALS
    /**
     * Testa o equals num cenário ideal.
     */
    @Test
    void testEqualsIgual() {
        Aluno alunoIgual = new Aluno(matriculaPadrao, nomePadrao, cursoPadrao);
        assertNotSame(alunoPadrao, alunoIgual);
        assertEquals(alunoPadrao, alunoIgual);
    }

    /**
     * Testa o equals onde apenas a matrícula é igual.
     */
    @Test
    void testEqualsMatriculaIgual() {
        Aluno alunoIgual = new Aluno(matriculaPadrao, nomePadrao + "X", cursoPadrao + "X");
        assertNotSame(alunoPadrao, alunoIgual);
        assertEquals(alunoPadrao, alunoIgual);
    }

    /**
     * Testa o equals com matriculas diferentes.
     */
    @Test
    void testEqualsMatriculaDiferente() {
        Aluno alunoIgual = new Aluno(matriculaPadrao + "1", nomePadrao, cursoPadrao);
        assertNotSame(alunoPadrao, alunoIgual);
        assertNotEquals(alunoPadrao, alunoIgual);
    }

    /**
     * Testa o equals com a comparação do mesmo objeto.
     */
    @Test
    void testEqualsMesmoObjeto() {
        assertEquals(alunoPadrao, alunoPadrao);
    }

    /**
     * Testa o equals com a comparação com um null.
     */
    // HASHCODE
    @Test
    void testEqualsObjetoNull() {
        assertNotEquals(alunoPadrao, null);
    }

    /**
     * Testa o equals com um objeto de uma classe diferente.
     */
    @Test
    void testEqualsClasseDiferente() {
        assertNotEquals(alunoPadrao, "1");
    }

    //HASHCODE
    /**
     * Testa o hashCode num cenário ideal.
     */
    @Test
    void testHashcodeIgual() {
        Aluno alunoIgual = new Aluno(matriculaPadrao, nomePadrao, cursoPadrao);
        assertNotSame(alunoPadrao, alunoIgual);
        assertEquals(alunoPadrao.hashCode(), alunoIgual.hashCode());
    }

    /**
     * Testa o hashCode quando a matricula é a mesma.
     */
    @Test
    void testHashcodeMatriculaIgual() {
        Aluno alunoIgual = new Aluno(matriculaPadrao, nomePadrao + "X", cursoPadrao + "X");
        assertNotSame(alunoPadrao, alunoIgual);
        assertEquals(alunoPadrao.hashCode(), alunoIgual.hashCode());
    }

    /**
     * Testa o hashCode quando a matrícula é diferente.
     */
    @Test
    void testHashcodeMatriculaDiferente() {
        Aluno alunoIgual = new Aluno(matriculaPadrao + "1", nomePadrao, cursoPadrao);
        assertNotSame(alunoPadrao, alunoIgual);
        assertNotEquals(alunoPadrao.hashCode(), alunoIgual.hashCode());
    }

    /**
     * Testa o toString.
     */
    @Test
    void testToString() {
        assertEquals("1 - Nome - Curso", alunoPadrao.toString());
    }
}