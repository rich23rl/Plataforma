package com.company;

import com.company.AlumnosController;
import com.company.AlumnosModel;
import com.company.AlumnosView;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Menu2 mp = new Menu2();
        mp.Menu2();
        System.out.println();
        mp.ObtenerRedultadoP(mp.Leeropcion());
    }
}
