package be.vdab.personeel;

import be.vdab.util.Geslacht;
import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public abstract class Werknemer implements Comparable<Werknemer>, Serializable {

    private static final long serialVersionUID = 1L;
    private WerknemersDatum datumInDienst;
    private String naam;
    private Geslacht geslacht;
    private final int personeelsnummer;

    public Werknemer(WerknemersDatum datumInDienst, String naam, Geslacht geslacht, int personeelsNummer) {
        setDatumInDienst(datumInDienst);
        setNaam(naam);
        setGeslacht(geslacht);
        if (personeelsNummer < 1) {
            throw new WerknemerException("Personeelsnummer moet groter dan 0 zijn");
        }
        this.personeelsnummer = personeelsNummer;
    }

    public abstract BigDecimal getVerloning();
    public WerknemersDatum getDatumInDienst() {
        return datumInDienst;
    }

    public final void setDatumInDienst(WerknemersDatum datumInDienst) {
        if (datumInDienst.compareTo(WerknemersDatum.OPRICHTINGSDATUM) < 0) {
            throw new WerknemerException("Datum in dienst moet groter of gelijk zijn aan oprichtingsdatum zijn");
        }
        this.datumInDienst = datumInDienst;
    }

    public String getNaam() {
        return naam;
    }

    public final void setNaam(String naam) {
        if (naam == null || naam.isBlank()) {
            throw new WerknemerException("Naam moet ingevuld zijn");
        }
        this.naam = naam;
    }

    public Geslacht getGeslacht() {
        return geslacht;
    }

    public final void setGeslacht(Geslacht geslacht) {
        if (geslacht == null) {
            throw new WerknemerException("Geslacht moet ingevuld zijn");
        }
        this.geslacht = geslacht;
    }

    @Override
    public int compareTo(Werknemer o) {
        return personeelsnummer - o.personeelsnummer;
    }

    @Override
    public String toString() {
        return personeelsnummer + "\t" + datumInDienst + "\t" + naam + "\t" + geslacht;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Werknemer w)) {
            return false;
        }
        return personeelsnummer == w.personeelsnummer;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(personeelsnummer);
    }
}

