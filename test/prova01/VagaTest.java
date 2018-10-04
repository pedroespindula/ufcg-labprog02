package prova01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class VagaTest {

    private String setorPadrao;
    private int valorNumericoPadrao;
    private String placaCarroPadrao;
    private Vaga vagaPadrao;

    @BeforeEach
    void initTest() {
        this.setorPadrao = "A";
        this.valorNumericoPadrao = 1;
        this.placaCarroPadrao = "AAA-0101";
        this.vagaPadrao = new Vaga(setorPadrao, valorNumericoPadrao);
    }

    @Test
    void testGetPlacaCarro() {
        vagaPadrao.estacionarCarro(placaCarroPadrao, LocalTime.now());

        assertEquals(placaCarroPadrao, vagaPadrao.getPlacaCarro());
    }

    @Test
    void testGetLocalizacao() {
        assertEquals(setorPadrao + valorNumericoPadrao, vagaPadrao.getLocalizacao());
    }

    @Test
    void testEstaOcupadaFalse() {
        assertFalse(vagaPadrao.estaOcupada());
    }

    @Test
    void testEstaOcupadaTrue() {
        assertFalse(vagaPadrao.estaOcupada());
        vagaPadrao.estacionarCarro(placaCarroPadrao, LocalTime.now());
        assertTrue(vagaPadrao.estaOcupada());
    }

    @Test
    void testLiberarVagaAgora() {
        vagaPadrao.estacionarCarro(placaCarroPadrao, LocalTime.now());
        assertEquals(5, vagaPadrao.liberarVaga());
        assertFalse(vagaPadrao.estaOcupada());
    }

    @Test
    void testEqualsObjetosIguais() {
        Vaga novaVaga = new Vaga(setorPadrao, valorNumericoPadrao);
        assertEquals(novaVaga, vagaPadrao);
    }

    @Test
    void testEqualsObjetosDiferentes() {
        Vaga novaVaga = new Vaga(setorPadrao, valorNumericoPadrao + 1);
        assertNotEquals(novaVaga, vagaPadrao);
    }

    @Test
    void testEqualsMesmoObjeto() {
        assertEquals(vagaPadrao, vagaPadrao);
    }

    @Test
    void testEqualsClassesDiferentes() {
        assertNotEquals(vagaPadrao, "TEST");
    }


    @Test
    void testHashCodeObjetosIguais() {
        Vaga novaVaga = new Vaga(setorPadrao, valorNumericoPadrao);
        assertEquals(novaVaga.hashCode(), vagaPadrao.hashCode());
    }

    @Test
    void testHashCodeObjetosDiferentes() {
        Vaga novaVaga = new Vaga(setorPadrao, valorNumericoPadrao + 1);
        assertNotEquals(novaVaga.hashCode(), vagaPadrao.hashCode());
    }

    @Test
    void testHashCodeMesmoObjeto() {
        assertEquals(vagaPadrao.hashCode(), vagaPadrao.hashCode());
    }

    @Test
    void testToString() {
        Vaga novaVaga = new Vaga(setorPadrao, valorNumericoPadrao);
        assertEquals(novaVaga.toString(), vagaPadrao.toString());
    }
}