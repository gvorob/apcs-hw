import java.util.Random;
public class Select{
	int swap;
	static Random r;
	
	public static void main(String[] args){
		int[] data = new int[] { 6,1,7,4,2,5,3,9 };
		System.out.println(sort(data,0,data.length));
		r = new Random();
	}

	
	public static int sort(int[] data, int low, int high){//high exclusive
		print(data);
		int p = data[low + r.nextInt(high - low)];
		int nfft = high;//Next free from top
		for(int i = low; i < high; i++){
			if(data[i] > p){
				while(true){
					if(nfft == i){
						i = high;
						break;
					}
					if(data[nfft] <= p){
						swap(data,i,nfft);
					}
					else{
						nfft--;
					}
				}
			}
			//print(newData);
		}
		int numPivots = 0;
		int i;
		for(i = low; data[i] <= p && i < high; i++){
			if(data[i] == p){
				numPivots++;
			}
			else{
				data[i - numPivots] = data[i]
				data[i] = p;
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

	public static void swap(int[] data, int a, int b){
		swap = data[a];
		data[a] = data[b];
		data[b] = swap;
	}


	public static void print(int[] asd){
		String result = "{";
		for(int i : asd){result += i + ",";}
		System.out.println(result + "}");
	}
}
	
