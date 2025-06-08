package practico1;

import java.util.Iterator;

public class MyDoubleLinkedList<T extends Comparable<T>> implements Iterable<T>{


    //A la clase Node<T> se le agrega un before, con su respectivo Getter && Setter.
    Node<T> first;
    Node<T> last;
    int size;

    public MyDoubleLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info, null, null);
        first.setBefore(tmp);
        tmp.setNext(this.first);
        this.first = tmp;
        this.size++;
    }


    public void insertLast(T info) {
        Node<T> tmp = new Node<T>(info,null, null);
        tmp.setBefore(this.last);
        last.setNext(tmp);
        this.last = tmp;
        this.size++;
    }

    //Elimina el primer elemento de la lista
    public T extractFront() {
        if (this.isEmpty())
            return null;//No hay nada que devolver

        T info = first.getInfo();
        first = first.getNext();
        size--;



        return info;
    }

    //Elimina el último elemento de la lista
    public T extractLast() {
        if (this.isEmpty())
            return null;//No hay nada que devolver

        T info = last.getInfo();
        last = last.getBefore();
        size--;
        return info;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    //Devuelvo el elemento en la posicion requerida.
    public T get(int index) {
        if (this.isEmpty())
            return null;

        int i = 0;
        Node<T> current = first;
        while (i<index){
            current = current.getNext();
            i++;
        }

        return current.getInfo();

    }


    public int indexOf(T buscado) {
        if (this.isEmpty())
            return -1;

        int i = 0;
        Node<T> current = first;
        while (current != null){
            if (current.equals(buscado)){
                return i;
            }
            current = current.getNext();
            i++;
        }

        return -1;
    }


    public int size() {
        return this.size;
    }

    public void insertSort(T elem) {
        if (this.isEmpty() ||  elem.compareTo(first.getInfo()) < 0){
            this.insertFront(elem);
            return;
        }

        if (this.isEmpty() ||  elem.compareTo(last.getInfo()) < 0){
            this.insertLast(elem);
            return;
        }

        Node<T> current = first;//Servira como referencia, apuntara al primer elemento, como en la lista simple
        Node<T> prev = current;

        while (current != null && elem.compareTo(current.getInfo()) > 0){
            prev = current;
            current = current.getNext();
        }

        Node<T> tmp = new Node<>(elem, null, null);
        tmp.setNext(current);
        tmp.setBefore(prev);
        size++;
    }


    public String toString() {
        if (first == null) return "[]"; // Lista vacía

        String result = "[";
        Node<T> actual = first;

        while (actual.getNext() != null) { // Recorremos hasta el penúltimo nodo
            result += actual.getInfo() + ", ";
            actual = actual.getNext();
        }

        result += actual.getInfo() + "]"; // Último elemento sin coma
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(first);
    }
}
