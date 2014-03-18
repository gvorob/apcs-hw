import java.util.Random;
public class QSort{
	static int swap;
	static Random r;
	
	public static void main(String[] args){
		r = new Random();
		int length = Integer.parseInt(args[0]);
		int range = Integer.parseInt(args[1]);
		int[] data = new int[length];
		System.out.println("length: " + length + "; range: " + range + ";\n");
		int sum = 0;
		for(int j = 0; j < 20;j++){
			for(int i = 0; i < data.length; i++){
				data[i] = r.nextInt(range);
			}
			//print(data);
			long time = System.currentTimeMillis();
			sort(data,0,data.length);
			time = System.currentTimeMillis() - time;
			System.out.println(time);
			sum += time;
			//print(data);
		}
		System.out.println("\navg: " + (sum / 20));
	}

	
	public static void sort(int[] data, int low, int high){//high exclusive
		if(high - low <= 1) return;

		int p = choosePivot(data,low,high);
		
		//print2(data,low,high);
		//System.out.println(low + " " + high + " p:" + p + "");
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

	public static int worsePivot(int[] data, int low, int high){
		int[] medians = new int[(high - low + 4) / 5];
		for(int i = 0; i < high - low; i += 5){
			medians[i / 5] = data[i + low];
		}
		return Select.quickselect(medians, medians.length / 2);
	}

	public static int choosePivot(int[] data, int low, int high){
		return data[low + r.nextInt(high - low)];
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

	public static void print2(int[] asd, int low, int high){
		String result = "{";
		for(int i = low; i < high; i++){result += asd[i] + ",";}
		System.out.println(result + "}");
	}
}
	
