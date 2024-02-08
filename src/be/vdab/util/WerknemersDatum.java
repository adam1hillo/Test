package be.vdab.util;

public class WerknemersDatum extends Datum {

    public final static Datum OPRICHTINGSDATUM = new Datum(12,2,1977);


    public WerknemersDatum(int dag, int maand, int jaar) {
        super(dag, maand, jaar);
    }
}
