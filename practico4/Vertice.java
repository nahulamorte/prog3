package practico4;

import java.util.LinkedList;
import java.util.List;

public class Vertice<T> {
    private int id;
    private List<Arco<T>> arcos;
    private T info;
    private String color;

    public Vertice(int id,T info, String color) {
        this.id = id;
        this.arcos = new LinkedList<>();
        this.info = info;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    private void addArco(Arco<T> arco){
        if (arcos.contains(arco))
            arcos.add(arco);
    }

    private void deleteArco(Arco<T> arco){
        this.arcos.remove(arco);
    }


}
