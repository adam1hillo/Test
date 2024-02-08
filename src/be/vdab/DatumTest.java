package be.vdab;

import be.vdab.util.Datum;
import be.vdab.util.DatumException;

import java.util.Set;
import java.util.TreeSet;

public class DatumTest {
    public static void main(String[] args) {

        Set<Datum> datums = new TreeSet<>();

        try {
            datums.add(new Datum(40, 12, 2029));
        } catch (DatumException e) {
            System.err.println(e.getMessage());
        }

        try {
            datums.add(new Datum(29, 2, 1997));
        } catch (DatumException e) {
            System.err.println(e.getMessage());
        }

        try {
            datums.add(new Datum(31, 12, 1359));
        } catch (DatumException e) {
            System.err.println(e.getMessage());
        }

        try {
            datums.add(new Datum(31, 16, 2029));
        } catch (DatumException e) {
            System.err.println(e.getMessage());
        }

        try {
            datums.add(new Datum(32, 5, 2029));
        } catch (DatumException e) {
            System.err.println(e.getMessage());
        }

        try {
            datums.add(new Datum(31, 16, 5048));
        } catch (DatumException e) {
            System.err.println(e.getMessage());
        }

        try {
            datums.add(new Datum(15, 5, 2014));
        } catch (DatumException e) {
            System.err.println(e.getMessage());
        }

        try {
            datums.add(new Datum(15, 5, 2013));
        } catch (DatumException e) {
            System.err.println(e.getMessage());
        }

        try {
            datums.add(new Datum(15, 2, 2013));
        } catch (DatumException e) {
            System.err.println(e.getMessage());
        }

        try {
            datums.add(new Datum(31, 12, 2016));
        } catch (DatumException e) {
            System.err.println(e.getMessage());
        }

        try {
            datums.add(new Datum(22, 12, 2016));
        } catch (DatumException e) {
            System.err.println(e.getMessage());
        }

        try {
            datums.add(new Datum(2, 12, 2016));
        } catch (DatumException e) {
            System.err.println(e.getMessage());
        }

        datums.forEach(System.out::println);

    }

}
