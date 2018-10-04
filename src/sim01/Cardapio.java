package sim01;

public class Cardapio {

    private String nomeEstabelecimento;
    private Item[] itensCardapio;
    private int qntItens;


    public Cardapio(String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
        this.itensCardapio = new Item[5];
        this.qntItens = 0;
    }

    public Cardapio(String nomeEstabelecimento, int quantidadeItensTotalCardapio) {
        this.nomeEstabelecimento = nomeEstabelecimento;
        this.itensCardapio = new Item[quantidadeItensTotalCardapio];
        this.qntItens = 0;
    }


    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    public int getQntItens() {
        return qntItens;
    }

    public void adicionaItem(Item item) {
        this.itensCardapio[this.qntItens++] = item;
    }

    public String listaCardapio() {
        StringBuilder stringBuilder = new StringBuilder(100);

        for (int i = 0; i < this.qntItens; i++) {
            Item item = this.itensCardapio[i];
            stringBuilder.append(i + 1);
            stringBuilder.append(" - ");
            stringBuilder.append(item.toString());
            stringBuilder.append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }

    public int calcularCaloriasRefeicao(String[] refeicao, String tamanhoRefeicao) {

        int totalCalorias = 0;

        for (String nomeRefeicao: refeicao) {
            Item item = this.getItem(nomeRefeicao);

            if (item == null) {
                throw new IllegalArgumentException("Array de refeições inválido.");
            }

            totalCalorias += item.getCalorias();

        }

        switch (tamanhoRefeicao) {
            case "padrao":
                totalCalorias *= 1;
                break;
            case "grande":
                totalCalorias *= 2;
                break;
            case "mega":
                totalCalorias *= 3;
                break;
            default:
                throw new IllegalArgumentException("Tamanho de refeição inválido.");
        }

        return totalCalorias;
    }

    private Item getItem(String nomeItem) {
        for (Item item: this.itensCardapio){
            if (item.getNome().equals(nomeItem)) {
                return item;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return this.getNomeEstabelecimento() + " - " + this.getQntItens() + " Itens no cardapio.";
    }
}
