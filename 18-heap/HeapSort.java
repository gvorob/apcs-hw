import java.util.Random;
public class HeapSort{

	private int[] data;//array not zero-indexed, zero is number of items

	public static void main(String[] args){
		int[] a = new int[30];
		Random r = new Random();
		for(int i = 0; i < a.length;i++){
			a[i] = r.nextInt(100);
		}
		heapSort(a);
	}


	public static void heapSort(int[] a){
		print(a);
		int count = 1;//1-indexed
		while(count <= a.length){
			int curr = count;
			while(!isSmallerThanParent(curr, a)){
				
				siftUp(curr, a);
				curr/=2;
			}
			count++;
		}
		print(a);
		count--;
		while(count > 0){
			int curr = 1;
			int temp = a[0];
			a[0] = a[count - 1];
			a[count - 1] = temp;
			count--;
			while(!isBiggerThanChildren(curr,count,a)){
				curr = siftDown(curr,count, a);
			}
		}
		print(a);
	}
	

	public static boolean isSmallerThanParent(int n,int[] data){//adjusts for 1-indexing
		return n == 1 || (data[n / 2 - 1] > data[n - 1]);
	}

	public static boolean isBiggerThanChildren(int n, int count, int[] data){//adjusts for 1-indexing
		int a = n * 2;
		int b = n * 2 + 1;
		return (b > count || data[b - 1] <= data[n - 1]) && (a > count || data[a-1] <= data[n-1]);
	}

	public static void siftUp(int n,int[] data){
		int temp = data[n - 1];
		data[n - 1] = data[n / 2 - 1];
		data[n / 2 - 1] = temp;
	}

	public static int siftDown(int n, int count, int[] data){
		int a = n * 2;
		int b = n * 2 + 1;
		if(b <= count && data[b-1] > data[a-1]){
			int temp = data[n-1];
			data[n-1] = data[b-1];
			data[b-1] = temp;
			return b;
		}
		else{
			int temp = data[n-1];
			data[n-1] = data[a-1];
			data[a-1] = temp;
			return a;
		}
	}

	public static void print(int[] data){
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
