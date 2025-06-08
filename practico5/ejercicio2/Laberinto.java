//package practico5.ejercicio2;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//
//public class Laberinto {
//
//    Celda [][] lab;
//
//    public Laberinto() {
//        this.lab = new Celda[3][3];
//    }
//
//    public void agregarCelda(Celda celda, int posX, int posY){
//        if (!contieneCelda(celda))
//            this.lab[posX][posY] = celda;
//    }
//
//    private boolean contieneCelda(Celda celda){
//        for (int x = 0; x < lab.length; x++){
//            for (int y = 0; y < lab.length; y++){
//                if (lab[x][y] == celda)
//                    return true;
//            }
//        }
//        return false;
//    }
//
//
//
//    public void avanzarCeldaDerecha(Celda c){
//
//    }
//    public void avanzarCeldaIzquierda(int posX, int posY){
//    public void avanzarCeldaAbajo(int posX, int posY){
//    public void avanzarCeldaArriba(int posX, int posY){
//    }
//}
