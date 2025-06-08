package practico6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Moneda {

    private int [] billetes = {100, 50, 25, 10, 5, 1};
    private List<Integer> solucion;


    public Moneda() {
        this.solucion = new ArrayList<>();

    }

    public List<Integer> greedy(Integer M){
        int pos = 0;
        while (M != 0 && pos < billetes.length){
            if (billetes[pos] <= M){
                Integer billete = billetes[pos];
                solucion.add(billete);
                M = M - billete;
            }
            pos++;
        }
        return solucion;
    }
}
