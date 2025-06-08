package practico5.ejercicio1;

import practico4.Grafo;

import java.util.*;

public class Sala<T> {
    private Grafo<T> grafo;
    private HashMap<Integer, String> colores;
    private List<Integer> solucion;

    public Sala(Grafo<T> grafo) {
        this.grafo = grafo;
        this.colores = new HashMap<>();
        this.solucion = new ArrayList<>();
    }

    /*Enunciado
        Se tiene un conjunto de salas comunicadas entre sí a través de puertas que se abren solamente en
    un sentido. Una de las salas se denomina entrada y la otra salida. Construir un algoritmo que
    permita ir desde la entrada a la salida atravesando la máxima cantidad de salas. Idea: podría
    representar el problema mediante un grafo dirigido, donde cada nodo es una habitación, y cada
    puerta es un arco dirigido hacia otra habitación.
    */

    public List<Integer> getCamino(Integer origen, Integer destino){
        //Pongo todos los vertices en blanco
        Iterator<Integer> itVert = grafo.obtenerVertices();
        while (itVert.hasNext()) {
            Integer vertice = itVert.next();
            colores.put(vertice, "blanco");
        }

        List<Integer> caminoActual = new ArrayList<>();
        caminoActual.add(origen);
        this.colores.put(origen, "amarillo");

        getCaminoRec(caminoActual, origen, destino);
        return this.solucion;
    }

    private void getCaminoRec(List<Integer> caminoAct, Integer actual, Integer destino){

        //Condicion de corte
        if (actual == destino) {
            if (esMejor(caminoAct, solucion)) {
                solucion.clear();
                this.solucion.addAll(caminoAct);
            }
        } else {
            Iterator<Integer> itAdy = grafo.obtenerAdyacentes(actual);
            while (itAdy.hasNext()){
                Integer ady = itAdy.next();
                if (colores.get(ady).equals("blanco")){
                    colores.put(ady, "amarillo");
                    caminoAct.add(ady);

                    getCaminoRec(caminoAct, ady, destino);

                    colores.put(ady, "blanco");
                    caminoAct.removeLast();
                }
            }

        }
    }

    private boolean esMejor(List<Integer> caminoAct, List<Integer> mejorCamino){
        return caminoAct.size() > mejorCamino.size();
    }

}
