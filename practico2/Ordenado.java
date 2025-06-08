package practico2;

public class Ordenado {

    public Ordenado() {}

    public boolean isSorted(int [] arr){
        return isSortedHelper(arr, 0);
    }
    //Controlamos que esta ordenado de manera ascendente
    private boolean isSortedHelper(int [] array, int index){ //O(n)
        if (array.length <=1) {
            return true; //Si no tiene elementos o tiene un solo elemento, por definicion esta ordenado
        }

        if (index >= array.length - 1){
            return true;
        }

        if (array[index] > array[index+1]){
            return false;
        }

        return isSortedHelper(array, index+1);
    }

    //O(n) ya que recorre el arreglo N veces
    public int buscarOrdenado(int [] array, int index, int elem){ //En realidad el index va a ser siempre 0, pero necesito la variable
        if (!isSortedHelper(array, index)){
            return -1;
        }

        if (elem < array[index] && elem != array[index]){
            return buscarOrdenado(array, index+1, elem);
        }

        return buscarOrdenado(array, index, elem);

    }

    public int busquedaBinaria(int [] arr, int ini, int fin, int elem){
        if (!isSortedHelper(arr, ini) || elem < arr[ini] || elem > arr[fin]){ //Si el arreglo no esta ordenado, retorno -1. Directamente no lo recorro.
            return -1;
        }

        int m = (ini + fin) / 2; //Divide el arreglo a la mitad y obtiene la mitad.


        if (elem == arr[m]){
            return m; //Si el elemento en la posicion del medio es igual al elemento que estoy buscando, retorno la posicion donde esta.
        }

        if (ini > fin){
            System.out.println("El elemento: " + elem + "No fue encontrado");
            return -1;
        }

        if (elem > arr[m]){
            return busquedaBinaria(arr, m+1, fin, elem);
        } else {
            return busquedaBinaria(arr, ini, m-1, elem);
        }
    }

    public String calculadoraBinaria(int num){
        String resultado = "";
        if (num <= 0) { //CASO BASE
            return resultado;
        }

        int resto = num%2;

        resultado += calculadoraBinaria(num / 2);

        return resultado += resto;
    }

    public void fibonacci(int n) {
        int prev = 0;
        int act = 1;
        int termino = prev + act;

        System.out.println(0);

        for (int i = 0; i < n; i++) {
            System.out.println(termino);
            prev = act;
            act = termino;

            termino = prev + act;
        }
    }

    public int fibonacciRecursivo(int n){
//        int i = 0;
//        int fibonacci = prev + act;
//        if (i <= n){
//            System.out.println(fibonacci);
//            prev = act;
//            act = fibonacci;
//            return fibonacciRecursivo(i++, prev, act);
//        }
//        return fibonacci;
        if (n == 0) return 0; // Caso base 1
        if (n == 1) return 1; // Caso base 2
        return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2); // Llamadas recursivas
    }

    public void posicionConValor(int [] arr, int num, int pos) {
        if (pos > arr.length) {
            System.out.println("Indice no valido");
            return;
        }

        if (arr[num] == num) {//CASO BASE
            System.out.println("Sí, existe un índice donde A[i] = i");
            return;
        }

        posicionConValor(arr, num, pos+1);
    }


    //Metodo de Ordenamiento por Burbujeo
    public void ordenamientoPorBurbujeo(int[]arr){
        int tmp;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j+1]){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }



    //Metodo de Ordenamiento por selección
    public void ordenamientoPorSeleccion(int [] arr){
        int i, j, menor, pos, tmp;
        for (i = 0;i<arr.length;i++){ //0(n)
            menor = arr[i];
            pos = i;
            for (j = i + 1; j < arr.length; j++) { //O(n^2)
                if (arr[j] < menor){
                    menor = arr[j];
                    pos = j;
                }
            }
            if (pos!= i){
                tmp = arr[i];
                arr[i] = arr[pos];
                arr[pos] = tmp;
            }
        }
    }

    public void mostrarArreglo(int [] arr){
        for (int i = 0; i<arr.length;i++){
            System.out.print(arr[i] + ", ");
        }
    }



}

