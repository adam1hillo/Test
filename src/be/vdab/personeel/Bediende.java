package be.vdab.personeel;

import be.vdab.util.Geslacht;
import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.math.BigDecimal;

public class Bediende extends Werknemer{

    private BigDecimal maandwedde;

    public Bediende(WerknemersDatum datumInDienst, String naam, Geslacht geslacht, int personeelsNummer, BigDecimal maandwedde) {
        super(datumInDienst, naam, geslacht, personeelsNummer);
        setMaandwedde(maandwedde);
    }

    public BigDecimal getMaandwedde() {
        return maandwedde;
    }

    public final void setMaandwedde(BigDecimal maandwedde) {
        if (maandwedde.compareTo(BigDecimal.valueOf(1129.47)) < 0) {
            throw new WerknemerException("Het minimum maandwedde is 1129,47EUR.");
        }
        this.maandwedde = maandwedde;
    }

    @Override
    public BigDecimal getVerloning() {
        return maandwedde;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + getVerloning();
    }
}
