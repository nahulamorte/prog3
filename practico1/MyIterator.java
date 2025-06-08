package practico1;

import java.util.Iterator;

public class MyIterator<T> implements Iterator<T> {

    private Node<T> current;

    public MyIterator(Node<T> current) {
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        return this.current != null; //Verifico si hay un proximo elemento.
    }

    @Override
    public T next() {
        T info = current.getInfo(); //Obtengo la información del nodo
        current = current.getNext(); //Actualizo el nodo al siguiente
        return info; //Devuelvo la info que guarde.
    }
}
