package practico4.algoritmos;

import practico4.Grafo;

import java.util.*;

public class BFS<T> {
    protected Map<Integer, Boolean> vertices;
    protected Queue<Integer> cola;

    public BFS() {
        this.vertices = new HashMap<>();
        this.cola = new LinkedList<>();
    }

    public void recorrido(Grafo<T> grafo) {
        this.copiarValores(grafo);
        cola = new LinkedList<>();

        for (Integer vertice : vertices.keySet()) {
            if (!this.vertices.get(vertice)) {
                this.bfsQQ(grafo, vertice);
            }
        }
    }

    public void bfsQQ(Grafo<T> grafo, Integer vertice) {
        this.vertices.put(vertice, true); // le digo al vertice que ahora fue visitado
        cola.add(vertice);

        while (!cola.isEmpty()) {
            Integer x = cola.poll();

            System.out.print(x + " | ");

            Iterator<Integer> it = grafo.obtenerAdyacentes(x);
            while (it.hasNext()) {
                Integer verticeActual = it.next();
                if (!this.vertices.get(verticeActual)) {
                    this.vertices.put(verticeActual, true);
                    cola.add(verticeActual);
                }
            }
        }
    }

    private void copiarValores(Grafo<T> grafo) {
        Iterator<Integer> it = grafo.obtenerVertices();

        while (it.hasNext()) {
            vertices.put(it.next(), false);
        }
    }

}
