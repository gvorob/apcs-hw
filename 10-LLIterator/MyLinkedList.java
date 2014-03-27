public class MyLinkedList implements Iterable{
	private Node<String> start;
	private Node<String> end;
	private int length;

	public static void main(String[] args){
		MyLinkedList m = new MyLinkedList();
		m.add("a");
		m.add("b");
		m.add("c");
		m.add("d");
		print(String.valueOf(m.find("a")));
		print(String.valueOf(m.find("c")));
		print(String.valueOf(m.find("d")));
		print(String.valueOf(m.find("e")));
		print(m.toString());
		m.insert(3,"b-c");
		print(m.toString());
		m.remove(3);
		print(m.toString());
		print(String.valueOf(m.length()));
		m.remove(3);
		print(m.toString());
		print(String.valueOf(m.length()));
		m.remove(0);
		m.add("e");
		print(m.toString());
		print(String.valueOf(m.length()));
	}
	
	public MyLinkedList(){
		length = 0;	
		start = new Node(null);
		end = start;
	}

	public void add(String s){
		Node temp = end;
		temp.setNext(new Node(s));
		end = temp.next();	
		length++;
	}

	public void insert(int i, String s){
		if(i >= length || i < 0) return;
		Node insert = new Node(s);
		Node temp = start;//temp is before the one to be replaced
		while(i != 0){
			temp = temp.next();
			i--;
		}
		insert.setNext(temp.next());
		temp.setNext(insert);
		length++;
	}

	public void remove(int i){
		if(i >= length || i < 0) return;
		Node temp = start;//predecessor of list(i)
		while(i!=0){
			temp = temp.next();
			i--;
		}
		if(temp.next().next() == null){
			temp.setNext(null);
			end = temp;
		}
		else
			temp.setNext(temp.next().next());
		length--;
	}
		

	public String get(int i){
		if(i >= length || i < 0) return null;
		Node temp = start;
		while(i != 0){
			temp = temp.next();
			i--;
		}
		return temp.next().get();
	}

	public void set(int i, String s){
		if(i >= length || i < 0) return;
		Node temp = start;
		while(i != 0){
			temp = temp.next();
			i--;
		}
		temp.next().set(s);
	}

	public int find(String s){
		int i = 0;
		Node temp = start.next();
		while(temp!=null){
			if(temp.get().equals(s))
				return i;
			temp = temp.next();
			i++;
		}
		return -1;
	}

	public int length(){return length;}

	public Iterator<String> iterator(){
		return new LLIterator<String>(start);
	}

	public static void print(String s){System.out.println(s);}

	public String toString(){
		String result = "";
		Node temp = start.next();
		while(temp!=null){
			result+= temp.get() + ";";
			temp = temp.next();
		}
		return result;
	}
}
