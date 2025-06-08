package practico5;

import practico4.GrafoDirigido;
import practico5.ejercicio1.Sala;
import practico5.ejercicio8.Piramide;
import practico5.ejercicio8.PiramideGPT;


public class Main {
    public static void main(String[] args) {
//        GrafoDirigido<Integer> grafo = new GrafoDirigido<>();
//
//        grafo.agregarVertice(1);
//        grafo.agregarVertice(2);
//        grafo.agregarVertice(3);
//        grafo.agregarVertice(4);
//        grafo.agregarVertice(5);
//
//
//        grafo.agregarArco(1,2, null);
//        grafo.agregarArco(1,3, null);
//        grafo.agregarArco(2,3, null);
//        grafo.agregarArco(3,4, null);
//        grafo.agregarArco(3,5, null);
//        grafo.agregarArco(4,5, null);
//        grafo.agregarArco(1,5, null);
//
//        Sala<Integer> sala = new Sala(grafo);
//
//        System.out.println("El camino mas largo a la hora de llegar desde la entrada: " + 1 + " hasta la salida: " + 5 + " es: " + sala.getCamino(1, 5));

        PiramideGPT p = new PiramideGPT();
        //System.out.println("La piramide es: " p.resolver(9,3));
        p.resolver(9,3);
    }
}
