//package practico5.ejercicio2;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//public class BackTracking {
//    private List<Integer> solucion;
//    private HashMap<Celda, Boolean> visitados;
//
//
//    public BackTracking() {
//        this.solucion = new ArrayList<>();
//        this.visitados = new HashMap<Celda, Boolean>();
//    }
//
//    public List<Integer> getCaminoDeLongitudMinima(Celda [][] lab, Celda origen, Celda destino){
//        List<Integer> caminoActual = new ArrayList<>();
//        caminoActual.add(origen.getValor());
//
//
//
//        recorrerLaberinto(origen, destino, caminoActual, 0,0);
//
//        return caminoActual;
//    }
//
//    public void recorrerLaberinto(Celda actual, Celda destino, List<Integer> caminoActual, int posX, int posY){
//        if (visitados.containsKey(actual)){
//            return;
//        }
//
//        if (actual == destino){
//            if (esMejor(caminoActual, solucion)){
//                solucion.clear();
//                solucion.addAll(caminoActual);
//            }
//        }
//
//        visitados.put(actual, true);
//
//        if (actual.haveLeft()){
//            recorrerLaberinto();
//
//        }
//
//    }
//}
