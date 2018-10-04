package sim01;

import java.util.Objects;

public class Item {

    private String nome;
    private int calorias;

    public Item(String nome, int calorias) {
        this.nome = nome;
        this.calorias = calorias;
    }

    public String getNome() {
        return nome;
    }

    public int getCalorias() {
        return calorias;
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }
        if (objeto == null || getClass() != objeto.getClass()) {
            return false;
        }
        Item itemComparado = (Item) objeto;
        return Objects.equals(nome, itemComparado.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return this.getNome() + " - " + this.getCalorias() + " calorias/porção";
    }
}
