package practico4.resoluciones;

public interface Grafo<T> {


    // Agrega un vertice
    public void agregarVertice(int verticeId);

    // Borra un vertice
    public void borrarVertice(int verticeId);

    // Agrega un arco con una etiqueta, que conecta el verticeId1 con el verticeId2
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta);
}
