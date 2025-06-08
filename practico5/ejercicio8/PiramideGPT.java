package practico5.ejercicio8;


import java.util.ArrayList;

public class PiramideGPT{
    Integer[][] matSolucion;
    ArrayList<Integer> usados;
    boolean solucionEncontrada = false;

    public PiramideGPT() {
        this.usados = new ArrayList<>();
    }

    public void resolver(int k, int b) {
        matSolucion = new Integer[b][b];
        ArrayList<Integer> base = new ArrayList<>();
        backtracking(base, k, b);
    }

    private boolean esSolucion(ArrayList<Integer> base, int k, int b) {
        if (base.size() != b) return false;

        Integer[][] temp = new Integer[b][b];

        for (int j = 0; j < b; j++) {
            temp[b - 1][j] = base.get(j);
        }

        for (int fila = b - 2; fila >= 0; fila--) {
            for (int col = 0; col <= fila; col++) {
                temp[fila][col] = temp[fila + 1][col] + temp[fila + 1][col + 1];
                if (temp[fila][col] > k) return false;
            }
        }

        return true;
    }

    private void backtracking(ArrayList<Integer> baseActual, int k, int b) {
        if (solucionEncontrada) return;

        if (esSolucion(baseActual, k, b)) {
            matSolucion = completarMatriz(baseActual, b);  // ← ahora sí
            imprimirMatriz(matSolucion, b);
            solucionEncontrada = true;
            return;
        }

        for (int i = 1; i <= k; i++) {
            if (solucionEncontrada) return;

            baseActual.add(i);
            usados.add(i);
            backtracking(baseActual, k, b);
            baseActual.remove(baseActual.size() - 1);
            usados.remove(usados.size() - 1);
        }
    }


    private Integer[][] completarMatriz(ArrayList<Integer> base, int b) {
        for (int j = 0; j < b; j++) {
            matSolucion[b - 1][j] = base.get(j);
        }

        for (int fila = b - 2; fila >= 0; fila--) {
            for (int col = 0; col <= fila; col++) {
                matSolucion[fila][col] = matSolucion[fila + 1][col] + matSolucion[fila + 1][col + 1];
            }
        }

        return matSolucion;
    }

    private void imprimirMatriz(Integer[][] matriz, int b) {
        for (int i = 0; i < b; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    // main de prueba
    public static void main(String[] args) {
        Piramide p = new Piramide();
        p.resolver(9, 3); // ejemplo
    }
}