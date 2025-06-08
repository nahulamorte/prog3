package practico5;

public class Juego15Simple {
    static int[][] objetivo = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9,10,11,12},
            {13,14,15, 0}
    };

    static int[][] movimientos = {
            {-1, 0}, // arriba
            {1, 0},  // abajo
            {0, -1}, // izquierda
            {0, 1}   // derecha
    };

    public static void main(String[] args) {
        int[][] tablero = {
                {1, 2, 3, 4},
                {5, 6, 0, 8},
                {9,10, 7,12},
                {13,14,11,15}
        };

        resolver(tablero, 10); // Intentamos resolver en máximo 10 movimientos
    }

    static void resolver(int[][] tablero, int profundidadMaxima) {
        int[] pos = buscarVacio(tablero);
        backtrack(tablero, pos[0], pos[1], 0, profundidadMaxima);
    }

    static void backtrack(int[][] t, int vacioFila, int vacioCol, int profundidad, int max) {
        if (profundidad > max) return;

        if (esObjetivo(t)) {
            imprimir(t);
            System.out.println("Resuelto en " + profundidad + " pasos.");
            return;
        }

        for (int[] mov : movimientos) {
            int nuevaFila = vacioFila + mov[0];
            int nuevaCol = vacioCol + mov[1];

            if (enRango(nuevaFila, nuevaCol)) {
                intercambiar(t, vacioFila, vacioCol, nuevaFila, nuevaCol);
                backtrack(t, nuevaFila, nuevaCol, profundidad + 1, max);
                intercambiar(t, vacioFila, vacioCol, nuevaFila, nuevaCol); // deshacer
            }
        }
    }

    static boolean esObjetivo(int[][] t) {
        int valor = 1;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                if (i == 3 && j == 3) return t[i][j] == 0;
                if (t[i][j] != valor++) return false;
            }
        return true;
    }

    static int[] buscarVacio(int[][] t) {
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                if (t[i][j] == 0) return new int[]{i, j};
        return null;
    }

    static boolean enRango(int i, int j) {
        return i >= 0 && i < 4 && j >= 0 && j < 4;
    }

    static void intercambiar(int[][] t, int i1, int j1, int i2, int j2) {
        int temp = t[i1][j1];
        t[i1][j1] = t[i2][j2];
        t[i2][j2] = temp;
    }

    static void imprimir(int[][] t) {
        for (int[] fila : t) {
            for (int num : fila)
                System.out.print((num == 0 ? "_" : num) + "\t");
            System.out.println();
        }
        System.out.println();
    }
}