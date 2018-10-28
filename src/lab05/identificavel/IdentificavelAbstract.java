package lab05.identificavel;

import java.util.Objects;

public abstract class IdentificavelAbstract implements Identificavel {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentificavelAbstract that = (IdentificavelAbstract) o;
        return Objects.equals(this.getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }


    @Override
    public int compareTo(Identificavel o) {
        return this.getId().compareTo(o.getId());
    }
}
