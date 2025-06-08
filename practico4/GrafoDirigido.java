package practico4;

import java.util.*;
import java.util.function.Consumer;

/*
  El metodo keySet()
  permite recuperar todas las claves de un mapa hash.
  Este método devuelve una vista del conjunto de claves del mapa, que puede iterarse,
  buscar un elemento específico o extraer valores a partir de estas claves.*/

public class GrafoDirigido<T> implements Grafo<T>{

    protected HashMap<Integer, List<Arco<T>>> vertices;

    // Podria hacer un hashSet con los arcos, pero eso equvilale otras cosas.

    public GrafoDirigido() {
        this.vertices = new HashMap<>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        if (!vertices.containsKey(verticeId))
            vertices.put(verticeId, new ArrayList<>());
    }

    @Override
    public void borrarVertice(int verticeId) {
        if (!vertices.containsKey(verticeId))
            return;

        for (Integer i : vertices.keySet()){
            List<Arco<T>> lista = vertices.get(i); //Me traigo todos los arcos de mi vertice
            Iterator<Arco<T>> it = lista.iterator();
            while (it.hasNext()){
                Arco<T> aux = it.next();
                if (aux.getVerticeDestino() == verticeId){
                    it.remove();
                }
            }
        }

        vertices.remove(verticeId); //Elimina el vertice


    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        if (!verificarVertices(verticeId1, verticeId2)) return;

        List<Arco<T>> lista = vertices.get(verticeId1); //Me traigo la lista de arcos del vertice de origen.

        Arco<T> nuevoArco = new Arco<>(verticeId1, verticeId2, etiqueta);
        if (!lista.contains(nuevoArco)) {
            lista.add(nuevoArco);
        }
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        if (!verificarVertices(verticeId1, verticeId2)){
            return;
        }
        //Esto podria ser un OR
        if (!existeArco(verticeId1, verticeId2)){
            return;
        }

        Arco<T> borrar = obtenerArco(verticeId1,verticeId2);

        List<Arco<T>> lista = vertices.get(verticeId1);
        lista.remove(borrar);
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return vertices.containsKey(verticeId);
    }

    //Metodo propio
    private boolean verificarVertices(int verticeId1, int verticeId2){
        return vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        List<Arco<T>> lista = vertices.get(verticeId1); //Me traigo todos los arcos del vertice de origen
        return lista.contains(new Arco<T>(verticeId1,verticeId2, null));
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        if (!verificarVertices(verticeId1, verticeId2)){
            return null;
        }

        List<Arco<T>> arcosId1 = vertices.get(verticeId1);
        for (Arco<T> arcoAux : arcosId1){
            if (arcoAux.getVerticeDestino() == verticeId2){
                return arcoAux;
            }
        }

        return null;
    }

    @Override
    public int cantidadVertices() {
        return vertices.size();
    }

    @Override
    public int cantidadArcos() {
        int cont = 0;
        for (Integer i : vertices.keySet()){
            cont += vertices.get(i).size();
        }
        return cont;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        return vertices.keySet().iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        List<Arco<T>> lista = vertices.get(verticeId);
        List<Integer> adyacentes = new ArrayList<>();
        for (Arco<T> arco : lista){
            adyacentes.add(arco.getVerticeDestino());
        }
        return adyacentes.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        List<Arco<T>> lista = new ArrayList<>();
        for (Integer i : vertices.keySet()){
            lista.addAll(vertices.get(i));
        }
        return lista.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        List<Arco<T>> lista = new ArrayList<>();

        if (!contieneVertice(verticeId)){
            return lista.iterator();
        }

        lista.addAll(vertices.get(verticeId));
        return lista.iterator();
    }



}
