public class AQueue{
	int length;
	

	private String[] data;
	private int head;
	private int tail;

	public static void main(String[] args){
		AQueue asdf = new AQueue();
		asdf.enqueue("1");
		asdf.enqueue("2");
		asdf.enqueue("3");
		asdf.enqueue("4");
		asdf.enqueue("5");
		asdf.enqueue("6");
		System.out.println(asdf);
		asdf.dequeue();
		asdf.dequeue();
		asdf.dequeue();
		asdf.dequeue();
		System.out.println(asdf);
		asdf.enqueue("7");
		asdf.enqueue("8");
		asdf.enqueue("9");
		asdf.enqueue("10");
		System.out.println(asdf);
		asdf.dequeue();
		asdf.dequeue();
		asdf.dequeue();
		asdf.dequeue();
		asdf.dequeue();
		asdf.dequeue();
		System.out.println(asdf);
		asdf.enqueue("1");
		asdf.enqueue("2");
		asdf.enqueue("3");
		System.out.println(asdf);
		
		
	}

	public AQueue(){
		data = new String[8];
		head = 0;
		tail = 0;
	}

	public boolean isEmpty(){return head == tail;}

	public int size(){return head + 1;}
	
	public void enqueue(String n){
		data[tail] = n;
		tail++;
		if(tail == data.length) tail = 0;
		if(tail == head) grow();
	}

	public String dequeue(){
		if(isEmpty()) return null;
		String temp = data[head];
		head++;
		if(head == data.length) head = 0;
		return temp;
	}	

	public String peek(){
		if(isEmpty()) return null;
		return data[head];
	}

	private void grow(){
		String[] temp = new String[data.length * 2];
		for(int i = head i != tail; i++){
			temp[i] = data[i];
		}
		data = temp;
	}

	public String toString(){
		//	System.out.println(head);
		//	System.out.println(tail);
		String result = (size()) + ": ";
		for(int i = head; i% data.length != (tail) % data.length; i++){
			if(i == data.length) i = 0;
		//	System.out.println(i);
			result += data[i] + ", ";	
		}
		return result;
	}
}
