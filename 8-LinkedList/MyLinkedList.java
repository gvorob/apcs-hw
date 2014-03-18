public class MyLinkedList{
	private Node start;
	private int length;

	public static void main(String[] args){
		MyLinkedList m = new MyLinkedList();
		m.add("a");
		m.add("b");
		m.add("c");
		m.add("d");
		print(m.toString());
		print(m.get(0));	
		print(m.get(1));	
		print(m.get(2));	
		print(m.get(3));	
		print(m.get(4));	
	}
	
	public MyLinkedList(){
		length = 0;	
		start = null;
	}

	public void add(String s){
		if(length == 0){
			start = new Node(s);
			length++;
			return;
		}
		Node temp = start;
		for(int i = 1; i < length; i++)
		{
			temp = temp.next();
		}
		temp.setNext(new Node(s));
		length++;
	}

	public String get(int i){
		if(i >= length || i < 0) return null;
		Node temp = start;
		while(i != 0){
			temp = temp.next();
			i--;
		}
		return temp.get();
	}

	public static void print(String s){System.out.println(s);}

	public String toString(){
		String result = "";
		Node temp = start;
		while(temp!=null){
			result+= temp.get() + ";";
			temp = temp.next();
		}
		return result;
	}
}
