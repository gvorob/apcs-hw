public class BSearch{

	public static void main(String[] args){

		int[] data = {1,1,2,3,5,8,13,21};

		print(data);
		System.out.println(ibSearch(data,21));
	}

	public static int rbSearch(int[] data, int target, int top, int bot){
		if(data.length == 0) return -1;
		if(top == bot)
			if(data[top] == target) return top;
			else return -1;

		int pivot = bot + (top - bot) / 2;

		if(data[pivot] == target)
			return pivot;
		if(data[pivot] > target)
			return rbSearch(data,target, pivot, bot);
		return rbSearch(data,target,top,pivot+1);
	}

	public static void print(int[] n){
		String result = "{";
		for(int i : n){
			result += i + ",";
		}
		System.out.println(result + "}");
	}

	public static int ibSearch(int[] data, int target){
		
		int bot = 0; int top = data.length - 1;

		while(top!=bot){
			int pivot = bot + (top - bot)/2;
			if(data[pivot] == target)return pivot;
			if(data[pivot] > target)
				top = pivot;
			else
				bot = pivot + 1;
		}
		if(data[top] == target) return top;
		return -1;
	}
}
