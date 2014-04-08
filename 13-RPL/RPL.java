public class RPL{
	private boolean loud;
	Stack stack;

	public static void main(String[] args){
		if(args.length == 0)
			System.out.println("gimme a string");
		else if(args.length == 1){
			RPL r = new RPL(false);
			r.solve(args[0]);
			System.out.println(r.stack);
		}
		else if(args.length == 2){
			RPL r = new RPL(true);
			r.solve(args[0]);
		}
	}
	
	public RPL(boolean l){
		stack = new Stack();
		loud = l;
	}

	public void solve(String in){
		String[] ins = in.split(" ");
		for(String each : ins){
			operate(each);
		}
		if(loud)System.out.println(stack);
	}

	public void operate(String in){//returns an int if its finished
		if(loud)System.out.println(in);
		if(in.equals("+"))
			add();
		else if(in.equals("-"))
			subt();
		else if(in.equals("*"))
			mult();
		else if(in.equals("/"))
			div();
		else
			try{
				stack.push(Double.parseDouble(in));
			}
			catch(NumberFormatException e){
				System.out.println("invalid input \"" + in + "\"");
			}
		if(loud)System.out.println(stack);
		if(loud)System.out.println("-----");

	}

	public void add(){
		try{
			stack.push(stack.pop() + stack.pop());
		}catch (Exception e){
			System.out.println("not enough elements in stack");
		}
	}

	public void subt(){
		try{
			stack.push(stack.pop() - stack.pop());
		}catch (Exception e){
			System.out.println("not enough elements in stack");
		}
	}

	public void mult(){
		try{
			stack.push(stack.pop() * stack.pop());
		}catch (Exception e){
			System.out.println("not enough elements in stack");
		}
	}

	public void div(){
		try{
			stack.push(stack.pop() / stack.pop());
		}catch (Exception e){
			System.out.println("not enough elements in stack");
		}
	}


}
