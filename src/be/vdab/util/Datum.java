package be.vdab.util;

import java.io.Serializable;
import java.util.Objects;

public class Datum implements IDatum, Comparable<Datum>, Serializable {

    private final int dag;
    private final int maand;
    private final int jaar;


    public Datum(int dag, int maand, int jaar) {
        if (jaar < 1584 || jaar > 4099) {
            throw new DatumException("Onjuiste jaar");
        }
        this.jaar = jaar;
        if (maand < 1 || maand > 12) {
            throw new DatumException("Onjuiste maand");
        }
        this.maand = maand;
        if (!isDagGeldig(dag)) {
            throw new DatumException("Onjuiste dag");
        }
        this.dag = dag;
    }


    private boolean isDagGeldig(int dag) {
        int max = switch (maand) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> isSchrikkeljaar(jaar) ? 29 : 28;
            default -> 0;
        };
        return dag <= max && dag > 0;
    }

    private boolean isSchrikkeljaar(int jaar) {
        return ((jaar % 400 == 0) || ((jaar % 4 == 0) && (jaar % 100 != 0)));
    }

    @Override
    public int getDag() {
        return dag;
    }

    @Override
    public int getMaand() {
        return maand;
    }

    @Override
    public int getJaar() {
        return jaar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Datum d)) {
            return false;
        }
        return dag == d.dag && maand == d.maand && jaar == d.jaar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dag, maand, jaar);
    }

    @Override
    public String toString() {
        return dag + "/" + maand + "/" + jaar;
    }


    @Override
    public int compareTo(Datum o) {
        if (jaar == o.jaar && maand == o.maand) {
            return dag - o.dag;
        } else if (jaar == o.jaar) {
            return maand-o.maand;
        }
        return jaar-o.jaar;
    }
}
