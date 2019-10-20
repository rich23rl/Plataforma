package com.company;
import com.company.LectorDeTeclado;

public class MaestrosController {
    LectorDeTeclado LDT = new LectorDeTeclado();
    int opcion;
    private MaestrosView mv;
    private MaestrosModel mm;


    public MaestrosController(){
        mv = new MaestrosView();
        mm= new MaestrosModel();
    }

    public void presentarListaMaestros(){
        mv.verLista(mm.getMaestros());
    }


    public int Leeropcion() {
        opcion = LDT.getInteger("Ingrese una opción", "Intentelo de Nuevo");
        return opcion;
    }

    public int ObtenerResultado(int opcion){
        switch (opcion){
            case 1:{
                presentarListaMaestros();
            }
            break;
            case 2:{
                String cargo = obtenerCargo();
                String nombre = obtenernombre();
                mm.createMaestro(cargo,nombre);
                System.out.println("Se ha agregado");

            }
            break;
            case 3:{
                mv.pedirposicion();
                int posicion = obtenerPosicicon();
                mv.pedircargo();
                String cargo = obtenerCargo();
                mv.pedirnombre();
                String nombre = obtenernombre();
                mm.updateMaestro(posicion,cargo,nombre);
                System.out.println("Se ha modificado");
            }
            break;
            case 4 :{
                mv.pedirposicion();
                int posicion = obtenerPosicicon();
                mm.readMaestro(posicion);
            }
            break;
            case 5:{
                int posicion = obtenerPosicicon();
                mm.deleteMestro(posicion);
                System.out.println("Se ha eliminado");
            }
            default:
            {

            }
        }
        return opcion;
    }

    private String obtenernombre() {
        return LDT.getString("Intentelo de Nuevo");
    }
    private String obtenerCargo(){
        return LDT.getString( "Intentelo de Nuevo");
    }
    private int obtenerPosicicon(){
        return LDT.getInteger("Intentelo de Nuevo");
    }
}
