package practico4.resoluciones;

import practico4.Grafo;
import practico4.algoritmos.DFS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*EJERCICIO 4 --> TP 4
    Escribir un algoritmo que, dado un grafo dirigido y dos vértices i, j de este grafo, devuelva el
    amino simple (sin ciclos) de mayor longitud del vértice i al vértice j. Puede suponerse que el
    grafo de entrada es acíclico
*/


public class CaminoSimple<T> extends DFS {
    private List<Integer> caminoSimple;

    public CaminoSimple() {
        this.caminoSimple = new ArrayList<>();
    }


    public List<Integer> getCaminoMasSimple(Grafo<T> grafo, int origen, int destino){
        List<Integer> listaAux = new ArrayList<>();

        getCaminoMasSimple(grafo,origen,destino, 0, listaAux);
        return caminoSimple;
    }

    private void getCaminoMasSimple(Grafo<T> grafo, int origen, int destino,
                                    int size, List<Integer> listaAux){
        listaAux.add(origen);
        if (origen == destino){
            if (size < listaAux.size()){
                size = listaAux.size();
                caminoSimple.addAll(listaAux);
            }
        }

        Iterator<Integer> it = grafo.obtenerAdyacentes(origen);
        while (it.hasNext()){
            Integer verticeActual = it.next();
            getCaminoMasSimple(grafo, verticeActual, destino, caminoSimple.size(), listaAux);
            listaAux.remove(verticeActual);
        }
    }
}
