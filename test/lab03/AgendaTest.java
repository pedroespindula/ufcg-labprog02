package lab03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de testes da classe Agenda.
 */
class AgendaTest {

    /**
     * A agenda principal usada nos testes.
     */
    private Agenda agendaPrincipal;

    /**
     * O contato principal usado nos testes.
     */
    private Contato contatoPrincipal;

    /**
     * O nome do contato padrão usado nos testes.
     */
    private String nomePrincipal = "Nome";

    /**
     * O sobrenome do contato padrão usado nos testes.
     */
    private String sobrenomePrincipal = "Sobrenome";

    /**
     * O telefone do contato padrão usado nos testes.
     */
    private String telefonePrincipal = "(11) 22222-3333";

    /**
     * Instancia a agenda principal e o contato principal.
     */
    @BeforeEach
    void initTest() {
        agendaPrincipal = new Agenda();
        contatoPrincipal = new Contato(nomePrincipal, sobrenomePrincipal, telefonePrincipal);
    }


    // CONSTRUTOR
    @Test
    void testAgendaQntContatosNegativo() {
        assertThrows(NegativeArraySizeException.class, () -> new Agenda(-1));
    }


    //GETTERS

    @Test
    void testGetLenght() {
        Agenda agenda = new Agenda(5);
        assertEquals(5, agenda.getLenght());
    }


    // CADASTRARCONTATO
    /**
     * Teste de cadastro ideal de contato.
     */
    @Test
    void testCadastrarContatoIdeal() {
        agendaPrincipal.cadastrarContato(nomePrincipal, sobrenomePrincipal, telefonePrincipal, 1);
    }

    /**
     * Teste de cadastro com posição 0.
     */
    @Test
    void testCadastrarContatoZero() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            agendaPrincipal.cadastrarContato(nomePrincipal, sobrenomePrincipal, telefonePrincipal, -1);
        });
    }

    /**
     * Teste de cadastro com posição negativa.
     */
    @Test
    void testCadastrarContatoNegativo() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            agendaPrincipal.cadastrarContato(nomePrincipal, sobrenomePrincipal, telefonePrincipal, 0);
        });
    }

    /**
     * Teste de cadastro com posição maior que o comprimento do array.
     */
    @Test
    void testCadastrarContatoMaiorLenght() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            agendaPrincipal.cadastrarContato(nomePrincipal, sobrenomePrincipal, telefonePrincipal, 101);
        });
    }


    // ACHARCONTATO
    /**
     * Teste de achar contato de forma ideal.
     */
    @Test
    void testAcharContatoIdeal() {
        agendaPrincipal.cadastrarContato(nomePrincipal, sobrenomePrincipal, telefonePrincipal, 1);
        assertEquals(contatoPrincipal, agendaPrincipal.acharContato(1));
    }

    /**
     * Teste de achar contato inexistente.
     */
    @Test
    void testAcharContatoInexistente() {
        assertNull(agendaPrincipal.acharContato(1));
    }

    /**
     * Teste de achar contato com posição negativa.
     */
    @Test
    void testAcharContatoNegativo() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            agendaPrincipal.acharContato(-1);
        });
    }

    /**
     * Teste de achar contato com posição igual a zero.
     */
    @Test
    void testAcharContatoZero() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            agendaPrincipal.acharContato(0);
        });
    }

    /**
     * Teste de achar contato com posição maior que o array.
     */
    @Test
    void testAcharContatoMaiorLenght() {

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            agendaPrincipal.acharContato(101);
        });
    }


    // EQUALS
    /**
     * Teste de equals de forma ideal com objetos considerados iguais.
     */
    @Test
    void testEqualsIdeal() {
        Agenda agenda1 = new Agenda();
        agenda1.cadastrarContato(nomePrincipal, sobrenomePrincipal, telefonePrincipal, 1);
        agendaPrincipal.cadastrarContato(nomePrincipal, sobrenomePrincipal, telefonePrincipal, 1);

        assertEquals(agendaPrincipal, agenda1);
    }

    /**
     * Teste de equals com um unico objeto (OBJETO == OBJETO).
     */
    @Test
    void testEqualsObjetoIgual() {
        agendaPrincipal.cadastrarContato(nomePrincipal, sobrenomePrincipal, telefonePrincipal, 1);
        assertEquals(agendaPrincipal, agendaPrincipal);
    }

    /**
     * Teste de equals com objetos diferentes.
     */
    @Test
    void testEqualsObjetoDiferente() {
        Agenda agenda1 = new Agenda();
        agenda1.cadastrarContato(nomePrincipal, sobrenomePrincipal, telefonePrincipal, 2);

        agendaPrincipal.cadastrarContato(nomePrincipal, sobrenomePrincipal, telefonePrincipal, 1);

        assertNotEquals(agenda1, agendaPrincipal);
    }

    /**
     * Teste de equals com objetos de classes diferentes.
     */
    @Test
    void testEqualsClasseDiferente() {
        assertNotEquals(agendaPrincipal, "test");
    }


    //TOSTRING
    /**
     * Teste de transformação em string com agenda vazia.
     */
    @Test
    void testToStringVazia() {
        assertEquals("Agenda vazia.", agendaPrincipal.toString());
    }

    /**
     * Teste de transformação em string com contatos cadastrados em agenda.
     */
    @Test
    void testToStringCadastrado() {
        agendaPrincipal.cadastrarContato(nomePrincipal, sobrenomePrincipal, telefonePrincipal, 1);
        assertEquals("1 - Nome Sobrenome", agendaPrincipal.toString());
    }
}