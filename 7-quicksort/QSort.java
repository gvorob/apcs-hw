import java.util.Random;
public class QSort{
	static int swap;
	static Random r;
	
	public static void main(String[] args){
		r = new Random();
		int[] data = new int[Integer.parseInt(args[0])];
		for(int i = 0; i < data.length; i++){
			data[i] = r.nextInt(10000);
		}
		//print(data);
		long time = System.currentTimeMillis();
		sort(data,0,data.length);
		System.out.println(System.currentTimeMillis() - time);
		//print(data);
	}

	
	public static void sort(int[] data, int low, int high){//high exclusive
		if(high - low <= 1) return;

		int p = data[low + r.nextInt(high - low)];

		//print(data);
		//System.out.println(low + " " + high + " p:" + p + "\n");
		int nfft = high - 1;//Next free from top
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
			//print(newData);
		}

		//System.out.println("finished swapping");

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
		
		sort(data,low, i - numPivots);
		sort(data,i,high);
	
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
	
