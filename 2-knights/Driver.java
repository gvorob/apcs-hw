public class Driver{

	public static void main(String[] args){
		Knights k = new Knights(8,0,0);
		Stack result = k.run();
		try{Thread.sleep(5000);}catch(Exception e){}
		System.out.println("\n\n\n\nplayback will begin in 3 seconds");
		try{Thread.sleep(3000);}catch(Exception e){}
		Knights.playStack(result,8,0,0);
	}

	static void testStack(){
		Stack s = new Stack();
		for(byte i = 0; i < 25; i++){
			System.out.println(s.size());
			s.push(i);
		}
		byte temp;
		while(true){
			temp = s.pop();
			System.out.println("- " + temp);
			if(temp == -1) break;
		}
	}

}
