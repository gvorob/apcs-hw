public class Select{

	
	public static void main(String[] args){
		int[] data = new int[] { 6,1,7,4,2,5,3,9 };
		System.out.println(quickselect(data,1));
		System.out.println(quickselect(data,3));
		System.out.println(quickselect(data,5));
		System.out.println(quickselect(data,7));
	}

	
	public static int quickselect(int[] data, int k){
		System.out.println("\n" + k);
		print(data);
		int p = (data.length - 1) / 2;
		int[] newData = new int[data.length];	
		int plow = 0,phigh = data.length - 1;
		int numEqual = 0;
		for(int n : data){
			if(n < data[p]){
				newData[plow] = n;
				plow++;
			}
			else if(n > data[p]){
				newData[phigh] = n;
				phigh--;
			}
			else numEqual++;
			print(newData);
		}
		for(int i  = 0; i < numEqual;i++){
			newData[plow] = data[p];
			plow++;
		}
		if(plow == k) return data[p];
	
		if(plow > k){
			int[] temp = new int[plow - 1];
			for(int i = 0; i < temp.length;i++){
				temp[i] = newData[i];
			}
			return quickselect(temp,k); 
		}
		else{
			int[] temp = new int[data.length - phigh - 1];
			for(int i = 0; i < temp.length;i++){
				temp[i] = newData[plow + i];
			}
			return quickselect(temp,k - plow); 
		}
	}


	public static void print(int[] asd){
		String result = "{";
		for(int i : asd){result += i + ",";}
		System.out.println(result + "}");
	}
}
	
