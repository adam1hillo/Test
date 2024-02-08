package be.vdab;

import be.vdab.personeel.Bedrijf;
import be.vdab.personeel.Werknemer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Zusterbedrijf {
    public static void main(String[] args) {


        List<?> werknemers = new ArrayList<>();
        try (var stream = new ObjectInputStream(Files.newInputStream(Path.of("personeel.dat")))) {
            werknemers = (List<?>) stream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        werknemers.forEach(System.out::println);
    }
}
