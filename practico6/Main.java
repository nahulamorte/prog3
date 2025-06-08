package practico6;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[] monedas = {50, 25, 10, 5, 1};  // Monedas disponibles, ordenadas de mayor a menor
            int monto = 95;  // Monto a cambiar

            List<Integer> resultado = new ArrayList<>();

            for (int moneda : monedas) {
                while (monto >= moneda) {
                    resultado.add(moneda);
                    monto -= moneda;
                }
            }

            System.out.println("Monedas usadas: " + resultado);
        }

}
