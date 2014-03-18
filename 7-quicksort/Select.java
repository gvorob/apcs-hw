import java.util.Random;
public class Select{

	
	public static void main(String[] args){
		int[] data = new int[200000];
		Random r = new Random();
		for(int i = 0; i < data.length; i++){
			data[i] = r.nextInt(1000);
		}
		quickselect(data,data.length/2);	
	}


	public static int quickselect(int[] data, int k){
		return quickselect(data,k,0,data.length);
	}
	
	public static int quickselect(int[] data, int k, int low, int high){
		while(true){
			//System.out.println("low: " + low + "; high: " + high + "; k: " + k);
			//print(data);
			int nfft = high - 1;
			int p = data[(high - low) / 2 + low];
			for(int i = low; i < high && i < nfft; i++){
				//System.out.println(i + "  " + nfft);
				//print(data);
				if(data[i] > p){
					while(true){
						if(nfft == i){
							i = high;
							break;
						}
						if(data[nfft] <= p){
							swap(data,i,nfft);
							break;
						}
						else{
							nfft--;
						}
					}
				}
			}
			//print(data);
			int numPivots = 0;
			int i;
			for(i = low; i < high && data[i] <= p; i++){
				//print(data);
				if(data[i] == p){
					numPivots++;
				}
				else if(numPivots > 0){
					data[i - numPivots] = data[i];
					data[i] = p;
				}
			}
			if(k < i - low && k >= i - numPivots - low)
				return data[i - 1];
			if(k < i - numPivots - low){
				high = i - numPivots;
			}
			else{
				k = k - i + low ;
				low = i;
			}
		}
	}

	public static void swap(int[] data,int a, int b){
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}

	public static void print(int[] asd){
		String result = "{";
		for(int i : asd){result += i + ",";}
		System.out.println(result + "}");
	}
}
	
