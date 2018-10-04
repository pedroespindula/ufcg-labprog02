package lab03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de testes da classe Contato.
 */
class ContatoTest {

    /**
     * O contato principal usado nos testes.
     */
    private Contato contatoPrincipal;

    /**
     * O nome padrão do contato usado nos testes.
     */
    private String nomePadrao = "Nome";

    /**
     * O sobrenome padrão do contato usado nos testes.
     */
    private String sobrenomePadrao = "Sobrenome";

    /**
     * O telefone padrão do contato usado nos testes.
     */
    private String telefonePadrao = "(11) 22223333";


    /**
     * Instancia o contato principal.
     */
    @BeforeEach
    void initTest() {
        contatoPrincipal = new Contato(nomePadrao, sobrenomePadrao, telefonePadrao);
    }


    // CONSTRUTOR
    /**
     * Teste de criação de contato com nome Null.
     */
    @Test
    void testCriarContatoNomeNull() {
        assertThrows(NullPointerException.class, () -> {
            new Contato(null, sobrenomePadrao, telefonePadrao);
        });
    }


    /**
     * Teste de criação de contato com sobrenome Null.
     */
    @Test
    void testCriarContatoSobrenomeNull() {
        assertThrows(NullPointerException.class, () -> {
            new Contato(nomePadrao, null, telefonePadrao);
        });
    }


    /**
     * Teste de criação de contato com telefone Null.
     */
    @Test
    void testCriarContatoTelefoneNull() {
        assertThrows(NullPointerException.class, () -> {
            new Contato(nomePadrao, sobrenomePadrao, null);
        });
    }


    /**
     * Teste de criação de contato com nome vazio.
     */
    @Test
    void testCriarContatoNomeVazio() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contato("", sobrenomePadrao, telefonePadrao);
        });
    }


    /**
     * Teste de criação de contato com sobrenome vazio.
     */
    @Test
    void testCriarContatoSobrenomeVazio() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contato(nomePadrao, "", telefonePadrao);
        });
    }


    /**
     * Teste de criação de contato com telefone vazio.
     */
    @Test
    void testCriarContatoTelefoneVazio() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contato(nomePadrao, sobrenomePadrao, "");
        });
    }

    // GETTERS
    /**
     * Teste do getNome().
     */
    @Test
    void testGetNome() {
        assertEquals(nomePadrao, contatoPrincipal.getNome());
    }

    /**
     * Teste do getSobrenome().
     */
    @Test
    void testGetSobrenome() {
        assertEquals(sobrenomePadrao, contatoPrincipal.getSobrenome());
    }

    /**
     * Teste do getTelefone().
     */
    @Test
    void testGetTelefone() {
        assertEquals(telefonePadrao, contatoPrincipal.getTelefone());
    }

    // EQUALS
    /**
     * Teste de equals de forma ideal com objetos considerados iguais.
     */
    @Test
    void testEqualsIdeal() {
        Contato contato1 = new Contato(nomePadrao, sobrenomePadrao, telefonePadrao);
        Contato contato2 = new Contato(nomePadrao, sobrenomePadrao, telefonePadrao);

        assertEquals(contato1, contato2);
    }

    /**
     * Teste de equals com um unico objeto (OBJETO == OBJETO).
     */
    @Test
    void testEqualsObjetoIgual() {
        assertEquals(contatoPrincipal, contatoPrincipal);
    }

    /**
     * Teste de equals com objetos diferentes.
     */
    @Test
    void testEqualsObjetoDiferente() {
        Contato contato1 = new Contato("test", "test", "11111111111");
        assertNotEquals(contatoPrincipal, contato1);
    }


    /**
     * Teste de equals com objetos de classes diferentes.
     */
    @Test
    void testEqualsClasseDiferente() {
        assertNotEquals(contatoPrincipal, "test");
    }


    // TOSTRING
    /**
     * Teste de transformação em string do contato.
     */
    @Test
    void testToString() {
        assertEquals(nomePadrao + " " + sobrenomePadrao + " - " + telefonePadrao, contatoPrincipal.toString());
    }
}