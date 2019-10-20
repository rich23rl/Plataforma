package com.company;

import com.company.AlumnosController;
import com.company.AlumnosView;
import com.company.ClaseController;
import com.company.ClaseView;
import com.company.LectorDeTeclado;
import com.company.MaestrosController;
import com.company.MaestrosView;

public class Menu2 {
    int opcion;
    LectorDeTeclado LDT = new LectorDeTeclado();
    public void Menu2(){
        System.out.println("\tPLataforma Virtual");
        System.out.println("1.Menu de Alumnos");
        System.out.println("2.Menu de Maestros");
        System.out.println("3.Menu de Clase");
    }
    public int Leeropcion() {
        opcion = LDT.getInteger("Ingrese una opción", "Intentelo de Nuevo");
        return opcion;
    }
    public int ObtenerRedultadoP(int opcion) {
        switch (opcion) {
            case 1: {
                AlumnosView av = new AlumnosView();
                AlumnosController ac = new AlumnosController();
                av.MenuAlumnos();
                System.out.println();
                ac.ObtenerResultado(ac.Leeropcion());
            }
            break;
            case 2: {
                MaestrosView mv = new MaestrosView();
                MaestrosController mc = new MaestrosController();
                mv.MenuMaestros();
                System.out.println();
                mc.ObtenerResultado(mc.Leeropcion());
            }
            break;
            case 3: {
                ClaseView cv = new ClaseView();
                ClaseController cc = new ClaseController();
                cv.MenuClase();
                System.out.println();
                cc.ObtenerResultado(cc.Leeropcion());
            }
            break;
        }
        return opcion;
    }

}