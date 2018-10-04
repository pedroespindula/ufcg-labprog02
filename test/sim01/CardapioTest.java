package sim01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardapioTest {

    private String nomePadrao;
    private int quantidadeItensPadrao;
    private Cardapio cardapioPadrao;
    private Item item1;
    private Item item2;

    private Cardapio cardapioExemplo;
    private Item arrozBranco;
    private Item arrozAGrega;
    private Item macarrao;
    private Item feijoada;
    private Item feijaoVerde;
    private Item frangoAssado;
    private Item bife;
    private Item vinagrete;
    private String[] refeicaoPadrao = {"arroz branco", "feijoada", "vinagrete"};

    @BeforeEach
    void constroiAtributosPadrao() {
        this.nomePadrao = "ESTABELECIMENTO";
        this.quantidadeItensPadrao = 10;
        this.cardapioPadrao = new Cardapio(nomePadrao, quantidadeItensPadrao);
        this.item1 = new Item("ITEM1", 100);
        this.item2 = new Item("ITEM2", 50);

        this.arrozBranco = new Item("arroz branco", 100);
        this.arrozAGrega = new Item("arroz a grega", 200);
        this.macarrao = new Item("macarrao", 200);
        this.feijoada = new Item("feijoada", 150);
        this.feijaoVerde = new Item("feijao verde", 90);
        this.frangoAssado = new Item("frango assado", 90);
        this.bife = new Item("bife", 100);
        this.vinagrete = new Item("vinagrete", 0);

        this.cardapioExemplo = new Cardapio("Sim01 Rest", 8);
        this.cardapioExemplo.adicionaItem(arrozBranco);
        this.cardapioExemplo.adicionaItem(arrozAGrega);
        this.cardapioExemplo.adicionaItem(macarrao);
        this.cardapioExemplo.adicionaItem(feijoada);
        this.cardapioExemplo.adicionaItem(feijaoVerde);
        this.cardapioExemplo.adicionaItem(frangoAssado);
        this.cardapioExemplo.adicionaItem(bife);
        this.cardapioExemplo.adicionaItem(vinagrete);
    }

    @Test
    void testConstructorSemQuantidadeItens() {
        Cardapio cardapio = new Cardapio(this.nomePadrao);
    }

    @Test
    void testGetNomeEstabelecimento() {
        assertEquals(this.nomePadrao, this.cardapioPadrao.getNomeEstabelecimento());
    }

    @Test
    void testGetQntItens() {
        assertEquals(0, this.cardapioPadrao.getQntItens());
        this.cardapioPadrao.adicionaItem(item1);
        assertEquals(1, this.cardapioPadrao.getQntItens());
    }

    @Test
    void testAdicionaItemIdeal() {
        cardapioPadrao.adicionaItem(item1);
    }

    @Test
    void testAdicionaItemNull() {
        cardapioPadrao.adicionaItem(null);
    }

    @Test
    void testListaCardapioIdeal() {
        cardapioPadrao.adicionaItem(item1);
        cardapioPadrao.adicionaItem(item2);
        assertEquals("1 - " + item1.toString() + System.lineSeparator() +
                              "2 - " + item2.toString(),
                              cardapioPadrao.listaCardapio());
    }

    @Test
    void testListaCardapioExemplo() {
        String stringRetorno = "1 - arroz branco - 100 calorias/porção" +
                System.lineSeparator() +
                "2 - arroz a grega - 200 calorias/porção" +
                System.lineSeparator() +
                "3 - macarrao - 200 calorias/porção" +
                System.lineSeparator() +
                "4 - feijoada - 150 calorias/porção" +
                System.lineSeparator() +
                "5 - feijao verde - 90 calorias/porção" +
                System.lineSeparator() +
                "6 - frango assado - 90 calorias/porção" +
                System.lineSeparator() +
                "7 - bife - 100 calorias/porção" +
                System.lineSeparator() +
                "8 - vinagrete - 0 calorias/porção";

        assertEquals(stringRetorno, cardapioExemplo.listaCardapio());
    }

    @Test
    void testListaCardapioVazio() {
        assertEquals("", cardapioPadrao.listaCardapio());
    }

    @Test
    void testCalcularCaloriasRefeicaoPadrao() {
        assertEquals(250, this.cardapioExemplo.calcularCaloriasRefeicao(refeicaoPadrao, "padrao"));
    }

    @Test
    void testCalcularCaloriasRefeicaoGrande() {
        assertEquals(500, this.cardapioExemplo.calcularCaloriasRefeicao(refeicaoPadrao, "grande"));
    }

    @Test
    void testCalcularCaloriasRefeicaoMega() {
        assertEquals(750, this.cardapioExemplo.calcularCaloriasRefeicao(refeicaoPadrao, "mega"));
    }

    @Test
    void testCalcularCaloriasRefeicaoTamanhoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.cardapioExemplo.calcularCaloriasRefeicao(refeicaoPadrao, "Extremamente Mega");
        });
    }

    @Test
    void testCalcularCaloriasRefeicaoRefeicaoInvalida() {
        String[] refeicao = {"carne", "ovo", "arroz branco"};
        assertThrows(IllegalArgumentException.class, () -> {
            this.cardapioExemplo.calcularCaloriasRefeicao(refeicao, "padrao");
        });
    }

    @Test
    void testToString() {
        assertEquals("Sim01 Rest - 8 Itens no cardapio.", this.cardapioExemplo.toString());
    }
}