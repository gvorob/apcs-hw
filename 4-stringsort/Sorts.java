import java.util.*;

public class Sorts{

	public static void main(String[] args){
		ArrayList<String> a, b, c;

		Random r = new Random();
		
		//b = new int[]{1,1,3,5,8,9};
		//a = new int[]{1,2,7,11};
		//c = merge(a,b);
		//print(a);print(b);print(c);

		ArrayList<String> data = new ArrayList<String>();//10 million
		for(int i = 0; i < 1000; i++){
			data.add("" + ((char)('a' + r.nextInt(26))));
		}
		print(data);
		System.out.println("array created");//print(data);
		long time = System.currentTimeMillis();
		data = mergeSort(data);
		time = System.currentTimeMillis() - time;
		print(data);
		System.out.println("Time: " + time);

	}

	public static ArrayList<String> mergeSort(ArrayList<String> a){
		if(a.size() == 1) return a;

		ArrayList<String> b = new ArrayList<String>();
		ArrayList<String> c = new ArrayList<String>();
		int i;	
		for(i = 0; i < a.size() / 2; i++){
			b.add(a.get(i));
		}
		for(; i < a.size(); i++){
			c.add(a.get(i));
		}

		return merge(mergeSort(b),mergeSort(c));
	}

	public static ArrayList<String> merge(ArrayList<String> a, ArrayList<String> b){
		ArrayList<String> result = new ArrayList<String>();
		int ai = 0, bi = 0;//a index, b index
		for(int i = 0; i < a.size() + b.size();i++){
			if(ai == a.size()){
				result.add(b.get(bi));
				bi++;
			}
			else if(bi == b.size()){
				result.add(a.get(ai));
				ai++;
			}
			else if(a.get(ai).compareTo(b.get(bi)) > 0){
				result.add(b.get(bi));
				bi++;
			}
			else{
				result.add(a.get(ai));
				ai++;
			}
		}
		return result;
	}

	public static void print(ArrayList<String> n){
		String result = "{";
		for(String i : n){
			result += i + ",";
		}
		System.out.println(result + "}");
	}
}
