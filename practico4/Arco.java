package practico4;

/*
 * La clase arco representa un arco del grafo. Contiene un vertice origen, un vertice destino y una etiqueta.
 * Nota: Para poder exponer los arcos fuera del grafo y que nadie los modifique se hizo esta clase inmutable
 * (Inmutable: una vez creado el arco no es posible cambiarle los valores).
 */


import java.util.Objects;

public class Arco<T> {

    private int verticeOrigen;
    private int verticeDestino;
    private T etiqueta;

    public Arco(int verticeOrigen, int verticeDestino, T etiqueta) {
        this.verticeOrigen = verticeOrigen;
        this.verticeDestino = verticeDestino;
        this.etiqueta = etiqueta;
    }

    public int getVerticeOrigen() {
        return verticeOrigen;
    }

    public int getVerticeDestino() {
        return verticeDestino;
    }

    public T getEtiqueta() {
        return etiqueta;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return true;
        }

        Arco<T> otro = (Arco<T>) obj;
        if (verticeOrigen == otro.getVerticeOrigen() && verticeDestino == otro.verticeDestino)
            return true;
        else
            return false;
    }

    public int hashCode() {
       return Objects.hash(verticeOrigen, verticeDestino);
    }
}
