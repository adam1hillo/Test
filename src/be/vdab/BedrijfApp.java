package be.vdab;

import be.vdab.personeel.Arbeider;
import be.vdab.personeel.Bediende;
import be.vdab.personeel.Bedrijf;
import be.vdab.personeel.Werknemer;
import be.vdab.util.*;
import be.vdab.personeel.kader.Kaderlid;

import java.math.BigDecimal;

public class BedrijfApp {
    public static void main(String[] args) {


        Bedrijf bedrijf = new Bedrijf();

        //FOUTE WERKNEMERES

        try {
            bedrijf.voegWerknemerToe(new Bediende(new WerknemersDatum(29,2,1989), "Michael", Geslacht.M, 15, BigDecimal.valueOf(2000)));
        } catch (DatumException | WerknemerException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            bedrijf.voegWerknemerToe(new Bediende(new WerknemersDatum(15,2,1322), "Michael", Geslacht.M, 15, BigDecimal.valueOf(2000)));
        } catch (DatumException | WerknemerException ex) {
            System.err.println(ex.getMessage());
        }

        try {
            bedrijf.voegWerknemerToe(new Arbeider(new WerknemersDatum(10,2,1989), "   ", Geslacht.M, 15, BigDecimal.valueOf(16.45)));
        } catch (DatumException | WerknemerException ex) {
            System.err.println(ex.getMessage());
        }

        try {
            bedrijf.voegWerknemerToe(new Arbeider(new WerknemersDatum(10,2,1989), "Michael", Geslacht.M, -52, BigDecimal.valueOf(10.45)));
        } catch (DatumException | WerknemerException ex) {
            System.err.println(ex.getMessage());
        }

        try {
            bedrijf.voegWerknemerToe(new Arbeider(new WerknemersDatum(10,2,1989), "Michael", Geslacht.M, 10, BigDecimal.valueOf(5.45)));
        } catch (DatumException | WerknemerException ex) {
            System.err.println(ex.getMessage());
        }

        try {
            bedrijf.voegWerknemerToe(new Bediende(new WerknemersDatum(10,2,1989), "Michael", Geslacht.M, 10, BigDecimal.valueOf(1000)));
        } catch (DatumException | WerknemerException ex) {
            System.err.println(ex.getMessage());
        }

        //JUISTE WERKNEMERS

        bedrijf.voegWerknemerToe(new Arbeider(new WerknemersDatum(5,5,2003), "Joey", Geslacht.M, 55, BigDecimal.valueOf(12.55)));
        bedrijf.voegWerknemerToe(new Arbeider(new WerknemersDatum(27,11,2016), "Ross", Geslacht.M, 3, BigDecimal.valueOf(15.5)));
        bedrijf.voegWerknemerToe(new Arbeider(new WerknemersDatum(10,9,2018), "Bella", Geslacht.V, 66, BigDecimal.valueOf(14.5)));
        bedrijf.voegWerknemerToe(new Bediende(new WerknemersDatum(3,1,2014), "Suzy", Geslacht.V, 10, BigDecimal.valueOf(2000.50)));
        bedrijf.voegWerknemerToe(new Bediende(new WerknemersDatum(27,6,2016), "Monica", Geslacht.V, 6, BigDecimal.valueOf(3500.55)));
        bedrijf.voegWerknemerToe(new Kaderlid(new WerknemersDatum(10,5,1995), "Phoebe", Geslacht.V, 2, BigDecimal.valueOf(7300.0), Functietitel.DIRECTEUR));
        bedrijf.voegWerknemerToe(new Kaderlid(new WerknemersDatum(2,12,1985), "Jerry", Geslacht.M, 1, BigDecimal.valueOf(15000.0), Functietitel.CEO));

        bedrijf.printLijst(bedrijf.getBedrijfslijst());
        System.out.println();
        bedrijf.printLijst(bedrijf.gesorteerdeLijst());
        System.out.println();
        bedrijf.printLijst(bedrijf.lijstVanArbeiders());
        System.out.println();
        System.out.println(bedrijf.percentageMannelijkeWerknemers());
        bedrijf.bewaarLijst();

    }
}
