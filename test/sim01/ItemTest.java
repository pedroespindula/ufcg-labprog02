package sim01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    private String nomePadrao;
    private int caloriasPadrao;
    private Item itemPadrao;

    @BeforeEach
    void constroiAtributosPadrao() {
        this.nomePadrao = "ITEM";
        this.caloriasPadrao = 100;
        this.itemPadrao = new Item(this.nomePadrao, this.caloriasPadrao);
    }

    @Test
    void testGetNome() {
        assertEquals(this.nomePadrao, this.itemPadrao.getNome());
    }

    @Test
    void testGetCalorias() {
        assertEquals(this.caloriasPadrao, this.itemPadrao.getCalorias());
    }

    @Test
    void testEqualsIdeal() {
        Item novoItem = new Item(this.nomePadrao, this.caloriasPadrao);
        assertEquals(this.itemPadrao, novoItem);
    }

    @Test
    void testEqualsNomeIgualCaloriaDiferente() {
        Item novoItem = new Item(this.nomePadrao, this.caloriasPadrao + 10);
        assertEquals(this.itemPadrao, novoItem);
    }

    @Test
    void testEqualsNomeDiferenteCaloriaIgual() {
        Item novoItem = new Item("NOVOITEM", this.caloriasPadrao);
        assertNotEquals(this.itemPadrao, novoItem);
    }

    @Test
    void testEqualsNullObject() {
        assertNotEquals(this.itemPadrao, null);
    }

    @Test
    void testEqualsClasseDiferente() {
        assertNotEquals(this.itemPadrao, this.itemPadrao.toString());
    }

    @Test
    void testEqualsMesmoObjeto() {
        assertEquals(this.itemPadrao, this.itemPadrao);
    }

    @Test
    void testHashCode() {
        assertEquals(Objects.hash(this.nomePadrao), itemPadrao.hashCode());
    }

    @Test
    void testToString() {
        Item arrozBranco = new Item("arroz branco", 100);
        assertEquals("arroz branco - 100 calorias/porção", arrozBranco.toString());
    }
}