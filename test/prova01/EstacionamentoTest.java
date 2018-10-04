package prova01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class EstacionamentoTest {

    private Estacionamento estacionamentoPadrao;
    private String localizacaoPadrao;
    private String placaCarroPadrao;

    @BeforeEach
    void initTest() {
        this.estacionamentoPadrao = new Estacionamento();
        this.localizacaoPadrao = "A1";
        this.placaCarroPadrao = "AAA-0101";
    }

    @Test
    void testCriarEstacionamentoPadrao() {
        Estacionamento estacionamento = new Estacionamento();
    }

    @Test
    void testCriarEstacionamentoComNumVagas() {
        Estacionamento estacionamento = new Estacionamento(10);
    }

    @Test
    void testEstacionarCarro() {
        assertFalse(estacionamentoPadrao.vagaEstaOcupada(localizacaoPadrao));
        estacionamentoPadrao.estacionarCarro(localizacaoPadrao, placaCarroPadrao, LocalTime.now());
        assertTrue(estacionamentoPadrao.vagaEstaOcupada(localizacaoPadrao));
    }

    @Test
    void testLiberarVaga() {
        this.testEstacionarCarro();
        estacionamentoPadrao.liberarVaga(localizacaoPadrao);
        assertFalse(estacionamentoPadrao.vagaEstaOcupada(localizacaoPadrao));
    }

    @Test
    void testGetPainelVagasLivres() {
        Estacionamento estacionamento = new Estacionamento(2);
        assertEquals("A1"+ System.lineSeparator() + "A2", estacionamento.getPainelVagasLivres());
        estacionamento.estacionarCarro(localizacaoPadrao, placaCarroPadrao, LocalTime.now());
        assertEquals("A2", estacionamento.getPainelVagasLivres());
    }

    @Test
    void testLocalizarCarroIdeal() {
        this.testEstacionarCarro();
        assertEquals(localizacaoPadrao, estacionamentoPadrao.localizarCarro(placaCarroPadrao));
    }

    @Test
    void testLocalizarCarroInexistente() {
        assertThrows(NullPointerException.class, () -> {
           estacionamentoPadrao.localizarCarro(placaCarroPadrao);
        });
    }

    @Test
    void testGetLucro() {
        assertEquals(0, estacionamentoPadrao.getLucro());
        testLiberarVaga();
        assertEquals(5, estacionamentoPadrao.getLucro());
        testLiberarVaga();
        assertEquals(10, estacionamentoPadrao.getLucro());
    }

    @Test
    void testEqualsObjetosIguais() {
        Estacionamento estacionamento = new Estacionamento();
        assertEquals(estacionamento, estacionamentoPadrao);
    }

    @Test
    void testEqualsObjetosDiferentes() {
        Estacionamento estacionamento = new Estacionamento(10);
        assertNotEquals(estacionamento, estacionamentoPadrao);
    }

    @Test
    void testEqualsMesmoObjeto() {
        assertEquals(estacionamentoPadrao, estacionamentoPadrao);
    }

    @Test
    void testEqualsClassesDiferentes() {
        assertNotEquals(estacionamentoPadrao, "TEST");
    }


    @Test
    void testHashCodeObjetosIguais() {
        Estacionamento estacionamento = new Estacionamento();
        assertEquals(estacionamento.hashCode(), estacionamentoPadrao.hashCode());
    }

    @Test
    void testHashCodeObjetosDiferentes() {
        Estacionamento estacionamento = new Estacionamento(10);
        assertNotEquals(estacionamento.hashCode(), estacionamentoPadrao.hashCode());
    }

    @Test
    void testHashCodeMesmoObjeto() {
        assertEquals(estacionamentoPadrao.hashCode(), estacionamentoPadrao.hashCode());
    }

    @Test
    void testToString() {
        testGetLucro();
        assertEquals("Lucro total: R$10,00", estacionamentoPadrao.toString());
    }

}