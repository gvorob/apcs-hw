public class RPL{
	private boolean loud;
	Stack stack;

	public static void main(String[] args){
		if(args.length == 0)
			System.out.println("gimme a string");
		else if(args.length == 1){
			RPL r = new RPL(false);
			r.load(args[0]);
			System.out.println(r.solve());
		}
		else if(args.length == 2){
			RPL r = new RPL(true);
			r.load(args[0]);
			System.out.println(r.solve());
		}
	}
	
	public RPL(boolean l){
		stack = new Stack();
		loud = l;
	}

	public void load(String in){
		String[] ins = in.split(" ");
		for(String each : ins){
			stack.push(each);
		}
		if(loud)System.out.println(stack);
	}

	public int doOne(){//returns an int if its finished
		String temp = stack.pop();
		if(loud)System.out.println(temp);
	}

	public void solve(){
		

}
