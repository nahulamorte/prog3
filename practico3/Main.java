package practico3;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();

        // Insertando valores en el árbol
        //int[] values = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45, 55, 65, 75, 85,98};
        int[] values = {6,2,10,1,4,8,11,7,9};
        for (int value : values) {
            tree.add(value);
        }

        // Probando si el árbol está vacío
        System.out.println("¿El árbol está vacío? " + tree.isEmpty());

        // Obteniendo la raíz del árbol
        System.out.println("Raíz del árbol: " + tree.getRoot());

        // Obteniendo la altura del árbol
        System.out.println("Altura del árbol: " + tree.getHeight());

        //Obteniendo el elemento mas grande del arbol
        System.out.println("El elemento más grande del árbol es: " + tree.getMaxElem());

        //Obteniendo el elemento mas pequeño del arbol
        System.out.println("El elemento más pequeño del árbol es: " + tree.getMinElem());

        //Verificando si un elemento esta dentro del arbol
        int elem = 25 - 5;
        System.out.println("El elemento: " + elem + " esta dentro del arbol: " + tree.hasElem(elem));

        // Obtener la rama más larga del árbol
        List<Integer> longestBranch = tree.getLongestBranch();
        System.out.println("Rama más larga: " + longestBranch);

        //Obtener el nivel entero
        int level = 2;
        System.out.println("En el nivel 2 se encuentran los siguientes elementos: " + tree.getElemAtLevel(level));

        //Obtener la frontera:
        System.out.println("La frontera de este arbol es: " + tree.getFrontera());

//        //Recorrer el arbol:
//        for (int i = 0; i < values.length; i++) {
//            System.out.print(values[i] + ", ");
//        }

        //La suma de los nodos internos del arbol es:
        System.out.println("La suma de los nodos internos es: " + tree.getSum());

        //Obtenemos las hojas con valores mayores a K
        int k=8;
        System.out.println("Las hojas cuyo valor es mayor a K son: " + tree.getHigherValues(k));

        System.out.println(" " );
        //Borrar el elemento sin hijos:
//        int elem_a_borrar = 98;
//        System.out.println("Se borro el elemento " + tree.delete(elem_a_borrar));

        //Recorrer el arbol
//        for (int j = 0; j < values.length; j++) {
//            System.out.print(values[j] + ", ");
//        }


        // Recorriendo el árbol en diferentes órdenes
//        System.out.print("Recorrido en Pre-Orden: ");
//        tree.recorrerArbol();
//        System.out.println();
    }
}
