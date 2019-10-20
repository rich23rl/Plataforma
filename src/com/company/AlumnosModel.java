package com.company;

import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.prefs.CsvPreference;
import org.w3c.dom.ls.LSOutput;

import javax.management.modelmbean.InvalidTargetObjectTypeException;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class AlumnosModel {
    AlumnosView av = new AlumnosView();
    private ArrayList<Alumnos> alumnos;

    public ArrayList<Alumnos> getAlumnos(){
        return alumnos;
    }

    AlumnosModel(){
        alumnos = new ArrayList<>();
        try {
            leerArchivo();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void  leerArchivo() throws IOException {
        File file = new File("Archivos.csv");
        FileReader fileReader = new FileReader(file);

        CsvPreference.Builder builder = new CsvPreference.Builder('\'',',',"\n");
        CsvBeanReader beanReader = new CsvBeanReader(fileReader,CsvPreference.STANDARD_PREFERENCE);

        final String[] header = beanReader.getHeader(true);
        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(), // nombre
                new NotNull(), // cuenta
                new NotNull(), // clase
        };

        Alumnos alumno = null;

        while ((alumno = beanReader.read(Alumnos.class,header,processors))
                != null){
            alumnos.add(alumno);
        }

        beanReader.close();
        fileReader.close();
        file = null;
    }
    private void agregarDatos (File archivo, ArrayList<Alumnos> alumnos) throws IOException {

    }

    public void createAlumno(String nombre, String cuenta, String clase){
        alumnos.add(new Alumnos(nombre,cuenta,clase));
    }

    public void updateAlumno(int index, String nombre, String cuenta, String clase) {
        alumnos.set(index, new Alumnos(nombre,cuenta,clase));
    }

    public ArrayList<Alumnos> readAlumos(int start, int end){
        for (int i = start; i < end ; i++) {
            System.out.println(alumnos.get(i));
        }
        return null;
    }

    public void readAlumno(int index){
        System.out.println(alumnos.get(index));
    }

    public void deleteAlumno(int index){ alumnos.remove(index); }


    public void persist(){

    }

}


