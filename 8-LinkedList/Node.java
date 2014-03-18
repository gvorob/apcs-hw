public class Node{

	private Node next;
	private String data;

	public Node(String s){
		next = null;
		data = s;
	}

	public Node(String s, Node n){
		next = n;
		data = s;
	}

	public String get(){return data;}
	public void set(String s){data = s;}
	public Node next(){return next;}
	public void setNext(Node n){next = n;}

}
