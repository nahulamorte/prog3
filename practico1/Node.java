package practico1;

public class Node<T> {

	private T info;
	private Node<T> next;
	private Node<T> before;

	public Node() {
		this.info = null;
		this.next = null;
		this.before = null;
	}
	
	public Node(T info, Node<T> next,Node<T> before) {
		this.setInfo(info);
		this.setNext(next);
		this.setBefore(before);
	}
	
	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public boolean equals(Object obj) {
		Node<T> otro = (Node<T>) obj;
		return otro.getInfo().equals(this.getInfo()) && otro.getNext().equals(this.getNext());
	}

	public Node<T> getBefore() {
		return before;
	}

	public void setBefore(Node<T> before) {
		this.before = before;
	}
}
