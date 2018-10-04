package prova01;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;

public class Estacionamento {

    private Vaga[] vagas;
    private int lucro;

    public Estacionamento(int numVagas) {
        this.vagas = new Vaga[numVagas];
        this.lucro = 0;
        this.inicializarVagas();
    }

    public Estacionamento() {
        this.vagas = new Vaga[50];
        this.lucro = 0;

        this.inicializarVagas();
    }

    private void inicializarVagas() {
        String setor = "A";

        for (int valorNumerico = 0; valorNumerico < vagas.length; valorNumerico++) {
            vagas[valorNumerico] = new Vaga(setor, valorNumerico + 1);
        }
    }

    public void estacionarCarro(String localizacaoVaga, String placaCarro, LocalTime horaEntrada) {
        Vaga vaga = getVaga(localizacaoVaga);
        vaga.estacionarCarro(placaCarro, horaEntrada);
    }

    public void liberarVaga(String localizacaoVaga) {
        Vaga vaga = getVaga(localizacaoVaga);
        this.lucro += vaga.liberarVaga();
    }

    private Vaga getVaga(String localizacaoVaga) {
        for (Vaga vaga: this.vagas) {
            if (vaga.getLocalizacao().equals(localizacaoVaga)) {
                return vaga;
            }
        }
        throw new NullPointerException("Vaga não encontrada");
    }

    public boolean vagaEstaOcupada(String localizacaoVaga) {
        Vaga vaga = getVaga(localizacaoVaga);
        return vaga.estaOcupada();
    }


    public String getPainelVagasLivres() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Vaga vaga: this.vagas) {
            if (!vaga.estaOcupada()){
                stringBuilder.append(vaga.getLocalizacao());
                stringBuilder.append(System.lineSeparator());
            }
        }

        return stringBuilder.toString().trim();

    }

    public String localizarCarro(String placaCarro) {
        for (Vaga vaga: this.vagas) {
            if (vaga.getPlacaCarro().equals(placaCarro)) {
                return vaga.getLocalizacao();
            }
        }
        throw new NullPointerException("Carro não encontrado");
    }

    public int getLucro() {
        return lucro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estacionamento that = (Estacionamento) o;
        return lucro == that.lucro &&
                Arrays.equals(vagas, that.vagas);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(lucro);
        result = 31 * result + Arrays.hashCode(vagas);
        return result;
    }

    @Override
    public String toString() {
        return "Lucro total: R$" + this.lucro + ",00";
    }
}