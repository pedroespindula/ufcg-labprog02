package prova01;

import java.time.LocalTime;
import java.util.Objects;

public class Vaga {

    private String setor;
    private int valorNumerico;
    private String localizacao;
    private LocalTime horaEntrada;
    private String placaCarro;
    private boolean estaOcupada;


    public Vaga(String setor, int valorNumerico) {

        this.setor = setor;
        this.valorNumerico = valorNumerico;
        this.localizacao = setor + valorNumerico;

        this.estaOcupada = false;
    }

    public String getPlacaCarro() {
        return this.placaCarro;
    }

    public String getLocalizacao() {
        return this.localizacao;
    }

    public boolean estaOcupada() {
        return this.estaOcupada;
    }

    public void estacionarCarro(String placaCarro, LocalTime horaEntrada) {
        this.placaCarro = placaCarro;
        this.horaEntrada = horaEntrada;
        this.estaOcupada = true;
    }

    public int liberarVaga() {
        int valorAPagar = this.getValorAPagar();

        this.placaCarro = null;
        this.horaEntrada = null;
        this.estaOcupada = false;

        return valorAPagar;
    }

    private int getValorAPagar() {
        int intervaloDeTempo = LocalTime.now().getHour() - horaEntrada.getHour();
        if (intervaloDeTempo <= 2) {
            return 5;
        } else {
            return 5 + intervaloDeTempo - 2;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaga vaga = (Vaga) o;
        return Objects.equals(localizacao, vaga.localizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localizacao);
    }

    @Override
    public String toString() {
        return this.localizacao + " - " + this.estaOcupada;
    }
}
