package lab05.identificavel;

public interface Identificavel extends Comparable<Identificavel> {

    String getId();

    void setAtributo(String nomeAtributo, String novoValor);

    String getAtributo(String nomeAtributo);
}
