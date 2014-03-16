public class Stack{

	private byte[] data;
	private int top;

	public Stack(){
		data = new byte[10];
		top = -1;
	}

	public boolean isEmpty(){return top < 0;}

	public int size(){return top + 1;}
	
	public void push(byte n){
		top++;
		if(top == data.length) grow();
		data[top] = n;
	}

	public byte pop(){
		if(isEmpty()) return -1;
		top--;
		return data[top + 1];
	}	

	private void grow(){
		byte[] temp = new byte[data.length * 2];
		for(int i = 0; i < data.length; i++){
			temp[i] = data[i];
		}
		data = temp;
	}

	public String toString(){
		String result = (top + 1) + ": ";
		for(int i = 0; i <= top; i++){
			result += data[i] + ",";	
		}
		return result;
	}
}
		
