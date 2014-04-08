public class Stack{

	private double[] data;
	private int top;


	public Stack(){
		data = new double[10];
		top = -1;
	}

	public boolean isEmpty(){return top < 0;}

	public int size(){return top + 1;}
	
	public void push(double n){
		top++;
		if(top == data.length) grow();
		data[top] = n;
	}

	public double pop() throws Exception{
		if(isEmpty()) throw new Exception();
		top--;
		return data[top + 1];
	}	

	public double peek() throws Exception{
		if(isEmpty()) throw new Exception();
		return data[top];
	}

	private void grow(){
		double[] temp = new double[data.length * 2];
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
		
