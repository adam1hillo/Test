package be.vdab.personeel.kader;

import be.vdab.personeel.Bediende;
import be.vdab.util.Functietitel;
import be.vdab.util.Geslacht;
import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.math.BigDecimal;

public class Kaderlid extends Bediende {

    private Functietitel functietitel;
    public Kaderlid(WerknemersDatum datumInDienst, String naam, Geslacht geslacht, int personeelsNummer, BigDecimal maandwedde, Functietitel functietitel) {
        super(datumInDienst, naam, geslacht, personeelsNummer, maandwedde);
        setFunctietitel(functietitel);
    }

    public Functietitel getFunctietitel() {
        return functietitel;
    }

    public final void setFunctietitel(Functietitel functietitel) {
        if (functietitel == null) {
            throw new WerknemerException("Functie titel moet ingevuld zijn");
        }
        this.functietitel = functietitel;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + functietitel;
    }
}
