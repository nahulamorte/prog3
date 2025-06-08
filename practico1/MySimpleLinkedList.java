package practico1;

import java.util.Iterator;

//Iterable me va a permitir iterar
//Iterator

public class MySimpleLinkedList<T extends Comparable<T>> implements Iterable<T>{
	
	private Node<T> first;
	protected int size;
	
	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}
	
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null,null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size++;
	}

	//O(n)
	public T extractFront() {	//Eliminar un elemento en la 1ra posicion
		// si la lista esta vacia no hay nada que extrar devuelvo un null
		if (this.isEmpty())
			return null;

		T info = this.first.getInfo();

		this.first = this.first.getNext();

		this.size--;
		return info;
	}

	public boolean isEmpty() {//Fijarse si esta vacio
		return this.size == 0;
	}

	//O(n)
	public T get(int index) { //Devuelve un elemento.
		if (this.isEmpty() || index >= size || index < 0)
			return null;

		Node<T> actual = first;
		int i = 0;
		while (i < index) {
			actual = actual.getNext();
			i++;
		}
		return actual.getInfo();
	}

	//MAL IMPLEMENTADO
//	public int indexOf(T buscado){ //Devolver el indice dado un elemento
//		if (this.isEmpty())
//			return -1;
//
//		Node<T> actual = this.first;
//		int ind = 0;
//		while (actual != null && !actual.equals(buscado)){
//			actual = actual.getNext();
//			ind++;
//		}
//
//		if (ind == size){
//			return -1;
//		}
//
//		return ind;
//	}

//Se supone que esta bien implementado
	public int indexOf(T buscado) {
		if (this.isEmpty()) return -1;

		Node<T> actual = this.first;
		int ind = 0;

		while (actual != null) {
			if (actual.getInfo().equals(buscado)) {
				return ind; // Elemento encontrado
			}
			actual = actual.getNext();
			ind++;
		}

		return -1; // Elemento no encontrado
	}

	public int size() { //Devolver el tamaño de la lista
		return this.size;
	}

	public void insertSort(T elem){
		if (this.isEmpty() ||  elem.compareTo(first.getInfo()) < 0){
			this.insertFront(elem);
			return;
		}
		 //PROBLEMA CON REPETIDOS
		//Ordenamiento ascendente
		Node<T> actual = first; //C
		Node<T> prev = actual; //Va a ser el anterior

		while (actual != null &&  elem.compareTo(actual.getInfo()) > 0){
			prev = actual;
			actual = actual.getNext();
		}

		Node<T> tmp = new Node<>(elem, actual, null);
		prev.setNext(tmp);
		size++;
	}


	@Override
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
		return new MyIterator<T>(this.first);
	}


}
