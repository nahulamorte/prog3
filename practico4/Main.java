package practico4;

import practico4.algoritmos.BFS;
import practico4.algoritmos.DFS;
import practico4.resoluciones.CaminoSimple;

public class Main {

    public static void main(String[] args) {
        //Main para ejercicio 4
        GrafoDirigido<Float> grafito = new GrafoDirigido<>();

        //Agregar vertices
        grafito.agregarVertice(1);
        grafito.agregarVertice(2);
        grafito.agregarVertice(3);
        grafito.agregarVertice(4);
        grafito.agregarVertice(5);
        grafito.agregarVertice(6);
        grafito.agregarVertice(7);
        grafito.agregarVertice(8);

        //Agrego arcos
        grafito.agregarArco(1,2, null);
        grafito.agregarArco(2,3,null);
        grafito.agregarArco(3,4,null);
        grafito.agregarArco(4,5,null);
        grafito.agregarArco(5,6,null);
        grafito.agregarArco(6,7,null);
        grafito.agregarArco(7,8,null);
        grafito.agregarArco(1,3,null);
        grafito.agregarArco(4,6,null);

        DFS dfs = new CaminoSimple();
        CaminoSimple ej4 = new CaminoSimple();



        System.out.println("El camino mas largo es: " + ej4.getCaminoMasSimple(grafito, 1,6));

        int v = 5;
        //System.out.println("Los vertices con camino hacia " + v + " son: " + dfs.get_vertices_con_camino(grafito,v));
    }
}


/*
      // Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
        GrafoDirigido<Float> grafito = new GrafoDirigido<>();

        // Agrego los vertices 1 y 2
        grafito.agregarVertice(1);
        grafito.agregarVertice(2);

        // Genero un arco desde 1 hasta 2 con el valor de etiqueta 3
        grafito.agregarArco(1, 2, 3F);

        GrafoDirigido<Character> grafitoCiclico = new GrafoDirigido<>();

        grafitoCiclico.agregarVertice('A');
        grafitoCiclico.agregarVertice('B');
        grafitoCiclico.agregarVertice('c');
        grafitoCiclico.agregarVertice('D');


        grafitoCiclico.agregarArco('A', 'B', null);
        grafitoCiclico.agregarArco('B', 'A', null);
        grafitoCiclico.agregarArco('A', 'C', null);
        grafitoCiclico.agregarArco('C', 'B', null);
        grafitoCiclico.agregarArco('D', 'C', null);
        grafitoCiclico.agregarArco('B', 'D', null);

        //System.out.println("\nEl grafo tiene un ciclo: " + new TestDeAciclidad<Character>().tieneCiclo(grafitoCiclico)+"\n");

        // Obtengo el arco entre 1 y 2, y le pido la etiqueta
        Float etiqueta = grafito.obtenerArco(1, 2).getEtiqueta();

        System.out.println(etiqueta); // Deberia imprimir 3

        System.out.println("\nDbs:");
        DFS dfs = new DFS();
        dfs.recorrido(grafito);

        System.out.println("\nBfs:");

        BFS bfs = new BFS();
        bfs.recorrido(grafito);

*/