public class Stack{

	private String[] data;
	private int top;

	public static void main(String[] args){
		Stack asdf = new Stack();
		asdf.push("1");
		asdf.push("2");
		asdf.push("3");
		asdf.push("4");
		System.out.println(asdf);
		System.out.println(asdf.pop());
		asdf.push("5");
		System.out.println(asdf);
		System.out.println(asdf.pop());
		System.out.println(asdf.peek());
		System.out.println(asdf.pop());
		System.out.println(asdf.pop());
		System.out.println(asdf.pop());
		System.out.println(asdf.pop());
		
		
	}

	public Stack(){
		data = new String[10];
		top = -1;
	}

	public boolean isEmpty(){return top < 0;}

	public int size(){return top + 1;}
	
	public void push(String n){
		top++;
		if(top == data.length) grow();
		data[top] = n;
	}

	public String pop(){
		if(isEmpty()) return null;
		top--;
		return data[top + 1];
	}	

	public String peek(){
		if(isEmpty()) return null;
		return data[top];
	}

	private void grow(){
		String[] temp = new String[data.length * 2];
		for(int i = 0; i < data.length; i++){
			temp[i] = data[i];
		}
		data = temp;
	}

	public String toString(){
		String result = (top + 1) + ": ";
		for(int i = 0; i <= top; i++){
			result += data[i] + ", ";	
		}
		return result;
	}
}
		
