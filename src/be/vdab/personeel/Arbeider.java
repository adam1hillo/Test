package be.vdab.personeel;

import be.vdab.util.Geslacht;
import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Arbeider extends Werknemer{

    private BigDecimal uurloon;

    public Arbeider(WerknemersDatum datumInDienst, String naam, Geslacht geslacht, int personeelsNummer, BigDecimal uurloon) {
        super(datumInDienst, naam, geslacht, personeelsNummer);
        setUurloon(uurloon);
    }

    public BigDecimal getUurloon() {
        return uurloon;
    }

    public final void setUurloon(BigDecimal uurloon) {
        if (uurloon.compareTo(BigDecimal.valueOf(9.76)) < 0) {
            throw new WerknemerException("Het minimum uurloon is 9,76EUR.");
        }
        this.uurloon = uurloon;
    }

    @Override
    public BigDecimal getVerloning() {
        return uurloon.multiply(BigDecimal.valueOf(7.6)).multiply(BigDecimal.valueOf(65)).divide(BigDecimal.valueOf(3), RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + uurloon + "\t" + getVerloning();
    }
}
