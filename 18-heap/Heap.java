public class Heap{

	private int[] data;//array not zero-indexed, zero is number of items

	public static void main(String[] args){
		Heap h = new Heap();
		h.add(3);
		h.add(2);
		h.add(5);
		h.add(4);
		h.add(6);
		h.add(1);
		h.print();
	}

	public Heap(){
		data = new int[2];
		data[0] = 0;
	}

	
	public void add(int n){
		if(data[0] == data.length - 1){
			grow();
		}
		System.out.println(data.length);
		data[0]++;
		data[data[0]] = n;
		int curr = data[0];
		while(!isSmallerThanParent(curr)){
			System.out.println("+" + String.valueOf(curr));
			siftUp(curr);
			curr/=2;
		}
	}

	public boolean isSmallerThanParent(int n){
		return n == 1 || (data[n / 2] > data[n]);
	}

	public void siftUp(int n){
		int temp = data[n];
		data[n] = data[n / 2];
		data[n / 2] = temp;
	}

	public void print(){
		String result = "";
		for(int n : data){
			result += String.valueOf(n) + ",";
		}
		System.out.println(result);
	}

	private void grow(){
		int[] temp = new int[data.length * 2];
		for(int i = 0; i < data.length; i++){
			temp[i] = data[i];
		}
		data = temp;
	}
}
