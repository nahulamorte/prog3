package practico4.resoluciones;

import practico4.Grafo;
import practico4.algoritmos.DFS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Ejercicio 5

/*
      Escriba un algoritmo que dado un grafo G y un vértice v de dicho grafo, devuelva una lista
      con todos los vértices a partir de los cuales exista un camino en G que termine en v
*/

public class GrafosConCamino<T> extends DFS {
    private List<Integer> grafosConCamino;

    public GrafosConCamino() {
        this.grafosConCamino = new ArrayList<>();
    }

    public List<Integer> get_vertices_con_camino(Grafo<T> grafo, int v){
        Iterator<Integer> it = grafo.obtenerVertices();
        while (it.hasNext()){
            int origen = it.next();

            List<Integer>  visitados = new ArrayList<>(); //O(n), Me quedo con los vertices ya visitados.
            if (tieneCamino(grafo, origen, v, visitados) && origen != v){
                grafosConCamino.add(origen);
            }
        }
        return grafosConCamino;
    }
    //v (nunca cambia)
    private boolean tieneCamino(Grafo<T> grafo, int origen, int destino, List<Integer> visitados){
        if (origen == destino){ //CASO BASE
            return true;
        }

        visitados.add(origen);

        Iterator<Integer> it = grafo.obtenerAdyacentes(origen);
        while (it.hasNext()){
            int ady = it.next();
            if (!visitados.contains(ady)){
                if (tieneCamino(grafo, ady, destino, visitados)){
                    return true;
                }
            }
        }

        return false;
    }

}
