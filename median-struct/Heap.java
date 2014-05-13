public class Heap{

	private int[] data;//array not zero-indexed, zero is number of items
	private boolean max;

	public static void main(String[] args){
		Heap h = new Heap(false);
		h.add(3);
		h.add(2);
		h.add(5);
		h.add(4);
		h.add(6);
		h.add(1);
		h.print();
		System.out.println(h.pop());
		System.out.println(h.pop());
		System.out.println(h.pop());
		System.out.println(h.pop());
		System.out.println(h.pop());
		System.out.println(h.pop());
	}

	public Heap(boolean isMax){
		max = isMax;
		data = new int[2];
		data[0] = 0;
	}

	
	public void add(int n){
		if(data[0] == data.length - 1){
			grow();
		}
		data[0]++;
		data[data[0]] = n;
		int curr = data[0];
		while(!isSmallerThanParent(curr)){
			System.out.println("+" + String.valueOf(curr));
			siftUp(curr);
			curr/=2;
		}
		print();
	}

	public int pop(){
		int temp = data[1];
		data[1] = data[data[0]];
		int curr = 1;
		data[0]--;
		while(!isBiggerThanChildren(curr,data[0])){
			curr = siftDown(curr,data[0]);
		}
		print();	
		return temp;
	}

	public boolean isSmallerThanParent(int n){//adjusts for 1-indexing
		if(max)
			return n == 1 || (data[n / 2] > data[n]);
		else
			return n == 1 || (data[n / 2] < data[n]);
	}

	public boolean isBiggerThanChildren(int n, int count){//adjusts for 1-indexing
		int a = n * 2;
		int b = n * 2 + 1;
		if(max)
			return (b > count || data[b] <= data[n]) && (a > count || data[a] <= data[n]);
		else
			return (b > count || data[b] >= data[n]) && (a > count || data[a] >= data[n]);
	}

	public void siftUp(int n){
		int temp = data[n];
		data[n] = data[n / 2];
		data[n / 2] = temp;
	}

	public int siftDown(int n, int count){
		int a = n * 2;
		int b = n * 2 + 1;
		if(!max != (b <= count && data[b] > data[a])){
			int temp = data[n];
			data[n] = data[b];
			data[b] = temp;
			return b;
		}
		else{
			int temp = data[n];
			data[n] = data[a];
			data[a] = temp;
			return a;
		}
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
