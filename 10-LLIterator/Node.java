public class Node<E>{

	private Node<E> next;
	private E data;

	public Node(E s){
		next = null;
		data = s;
	}

	public Node(E s, Node<E> n){
		next = n;
		data = s;
	}

	public E get(){return data;}
	public void set(E s){data = s;}
	public Node<E> next(){return next;}
	public void setNext(Node<E> n){next = n;}

}
