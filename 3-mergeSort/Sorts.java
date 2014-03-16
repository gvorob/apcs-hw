import java.util.*;

public class Sorts{

	public static void main(String[] args){
		int[] a, b, c;

		Random r = new Random();
		
		b = new int[]{1,1,3,5,8,9};
		a = new int[]{1,2,7,11};
		c = merge(a,b);
		print(a);print(b);print(c);

		int[] data = new int[1000 * 1000 * 10];//10 million
		for(int i = 0; i < data.length; i++){
			data[i] = r.nextInt(100000);
		}
		System.out.println("array created");//print(data);
		long time = System.currentTimeMillis();
		data = mergeSort(data);
		time = System.currentTimeMillis() - time;
		//print(data);
		System.out.println("Time: " + time);

	}

	public static int[] mergeSort(int[] a){
		if(a.length == 1) return a;

		int[] b = new int[a.length / 2];
		int[] c = new int[a.length - b.length];
		
		for(int i = 0; i < b.length; i++){
			b[i] = a[i];
		}
		for(int i = b.length; i < a.length; i++){
			c[i - b.length] = a[i];
		}

		return merge(mergeSort(b),mergeSort(c));
	}

	public static int[] merge(int[] a, int[] b){
		int[] result = new int[a.length + b.length];
		int ai = 0, bi = 0;//a index, b index
		for(int i = 0; i < result.length;i++){
			if(ai == a.length){
				result[i] = b[bi];
				bi++;
			}
			else if(bi == b.length){
				result[i] = a[ai];
				ai++;
			}
			else if(a[ai] > b[bi]){
				result[i] = b[bi];
				bi++;
			}
			else{
				result[i] = a[ai];
				ai++;
			}
		}
		return result;
	}

	public static void print(int[] n){
		String result = "{";
		for(int i : n){
			result += i + ",";
		}
		System.out.println(result + "}");
	}
}
