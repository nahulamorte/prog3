package practico4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ej3<T> {
        private Map<Integer, String> estadoVertice;

        public ej3() {
            this.estadoVertice = new HashMap<>();
        }

        public void recorrido(Grafo<T> grafo) {
            this.copiarVertices(grafo);

            // inicializo el recorrido de mis vertices
            for (Integer vertice : this.estadoVertice.keySet()) {
                if (estadoVertice.get(vertice).equals("BLANCO")) {
                    visit(grafo, vertice);
                } else if (estadoVertice.get(vertice).equals("AMARILLO")){
                    System.out.println("Hay ciclooooo!!!!, mateo es gay.");
                }
            }
        }

        private void visit(Grafo<T> grafo, Integer vertice) {
            estadoVertice.put(vertice, "AMARILLO");

            System.out.print(vertice + " | ");

            Iterator<Integer> it = grafo.obtenerAdyacentes(vertice);
            while (it.hasNext()){
                Integer verticeActual = it.next();

                // hago un llamado recursivo para ir "bajando" entro mis vertices
                if (this.estadoVertice.get(verticeActual).equals("BLANCO"))
                    visit(grafo, verticeActual);
            }

            estadoVertice.put(vertice, "NEGRO");
        }

        private void copiarVertices(Grafo<T> grafo) {
            Iterator<Integer> it = grafo.obtenerVertices();

            while (it.hasNext()) {
                this.estadoVertice.put(it.next(), "BLANCO");
            }
        }
    }

