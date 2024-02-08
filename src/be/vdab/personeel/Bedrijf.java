package be.vdab.personeel;

import be.vdab.util.Geslacht;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bedrijf {
    private final List<Werknemer> bedrijfslijst = new ArrayList<>();

    public List<Werknemer> getBedrijfslijst() {
        return bedrijfslijst;
    }

    public void voegWerknemerToe(Werknemer werknemer) {
        if (werknemer == null) {
            throw new IllegalArgumentException("Werknemer mag niet null zijn");
        }
        if (!bedrijfslijst.contains(werknemer)) {
            bedrijfslijst.add(werknemer);
        }
    }
    public void printLijst(List<Werknemer> werknemers) {
        werknemers.forEach(System.out::println);
    }

    public List<Werknemer> gesorteerdeLijst() {
         return bedrijfslijst.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Werknemer> lijstVanArbeiders() {
        return bedrijfslijst.stream()
                .filter(werknemer -> werknemer instanceof Arbeider)
                .collect(Collectors.toList());
    }

    public double percentageMannelijkeWerknemers() {
        long mannelijkeWerknemers = bedrijfslijst.stream()
                .filter(werknemer -> werknemer.getGeslacht() == Geslacht.M)
                .count();
        double perc = (double)mannelijkeWerknemers/ bedrijfslijst.size() * 100.0;
        BigDecimal bd = BigDecimal.valueOf(perc);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void bewaarLijst() {
        try (var stream = new ObjectOutputStream(Files.newOutputStream(Path.of("personeel.dat")))) {
            stream.writeObject(bedrijfslijst);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
