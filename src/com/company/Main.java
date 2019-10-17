package com.company;

import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.constraint.LMinMax;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.StrRegEx;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.prefs.CsvPreference;
import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        AlumnosController ac= new AlumnosController();
        ac.presentMenuObtenerResultado();
        ac.presentarListaAlumnos();

    }

}

