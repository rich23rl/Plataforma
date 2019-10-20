package com.company;

import com.company.Alumnos;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.prefs.CsvPreference;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MaestrosModel {
    private ArrayList<Maestros> maestros;

    public ArrayList<Maestros> getMaestros(){
        return maestros;
    }

    MaestrosModel(){
        maestros = new ArrayList<>();
        try {
            leerArchivo();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void  leerArchivo() throws IOException {
        File file = new File("Archivos_1.csv");
        FileReader fileReader = new FileReader(file);

        CsvPreference.Builder builder = new CsvPreference.Builder('\'',',',"\n");
        CsvBeanReader beanReader = new CsvBeanReader(fileReader,CsvPreference.STANDARD_PREFERENCE);

        final String[] header = beanReader.getHeader(true);
        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(), // cargo
                new NotNull(), // nombre
        };

        Maestros maestro = null;

        while ((maestro = beanReader.read(Maestros.class,header,processors))
                != null){
            maestros.add(maestro);
        }

        beanReader.close();
        fileReader.close();
        file = null;
    }
    public void createMaestro(String cargo, String nombre){
        maestros.add(new Maestros(cargo, nombre));
    }
    public void updateMaestro(int index, String cargo, String nombre){
        maestros.set(index, new Maestros(cargo,nombre));
    }
    public void readMaestro (int index){
        System.out.println(maestros.get(index));
    }
    public void deleteMestro (int index){
        maestros.remove(index);
    }
}
