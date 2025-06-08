package practico5.ejercicio8;

import java.util.ArrayList;

public class Piramide {

    Integer [][] matSolucion;
    ArrayList<Integer> usados;

    public Piramide() {
        matSolucion = new Integer[3][3];
        this.usados = new ArrayList<>();
    }

    public void resolver(int k, int b){
        ArrayList<Integer> base = new ArrayList<>();
        backtracking(base, k, b);
    }

    private void backtracking(ArrayList<Integer> baseActual, int k, int b){

        if (esSolucion(baseActual, k, b)){
            matSolucion = completarMatriz(baseActual, b);
            return;
        }

        for (int i = 1; i < k; i++) {
            baseActual.add(i);
            this.usados.add(i);
            backtracking(baseActual, k,b);
            baseActual.removeLast();
            this.usados.removeLast();
        }
    }



    private boolean esSolucion(ArrayList<Integer> base, int k, int b){
        if (base.size()<b){
            return false;
        }

        for (int i = 0; i < b; i++) {
            if (base.get(i) > k){
                return false;
            }
        }

        matSolucion = completarMatriz(base, b);
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < b; j++) {
                if (matSolucion[i][j] > k){
                    return false;
                }
            }
        }

        return true;
    }

    private Integer [][] completarMatriz(ArrayList<Integer> base, int b){
        // Colocar la base en la última fila
        for (int j = 0; j < b; j++) {
            matSolucion[b - 1][j] = base.get(j);
        }

        // Construir pirámide de abajo hacia arriba
        for (int fila = b - 2; fila >= 0; fila--) {
            for (int col = 0; col <= fila; col++) {
                matSolucion[fila][col] = matSolucion[fila + 1][col] + matSolucion[fila + 1][col + 1];
            }
        }
        return matSolucion;
    }
}
