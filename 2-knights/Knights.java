public class Knights{

	boolean[][] grid;
	Stack moves;
	int kx,ky;
	byte lastMove = -1;
	boolean wasValid = true;

	int printCounter;
	long cycles;
	
	public Knights(int size,int startX,int startY){
		grid = new boolean[size][size];	
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				grid[i][j] = false;
			}
		}
		moves = new Stack();
		kx = startX; ky = startY;
		grid[kx][ky] = true;
	}

	public Stack run(){

		while(true){
			cycles++;
			//print(1,0);
			if(wasValid){
				print(0,10000000);
				lastMove = -1;
			}
			
			lastMove++;
			if(lastMove == 8){
				if(moves.size() == 0) return null;
				if(isDone()) break;
				wasValid = false;
				lastMove = undoMove();
			} else {
				wasValid = move(lastMove);	
			}
		
		}
		print(0,0);
		return moves;
	}

	
		
	void print(int n, int modulo){
		printCounter++;
		if(printCounter < modulo) return;
		printCounter = 0;
		String result = "";
		for(int i = 0; i < grid.length;i++){
			for(int j = 0; j < grid[0].length;j++){
				result+= grid[j][i]?"0":":";
			}
			result += "\n";
		}
		result += "\n" + moves + "\nLastMove: " + lastMove + "\nWasValid: " + wasValid + "\nCycles: " + cycles ;
		char esc = 0x1b;
		System.out.println(esc + "[2J"  + esc + "[0;0f" + result );
		System.out.println(kx + " " + ky + esc + "[" + (ky + 1) + ";" + (kx + 1) + "fK\n");

		if(n!= 0)try{Thread.sleep(n);}catch(Exception e){}
	}

	boolean isValid(int x,int y){
		if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return false;
		return !grid[x][y];
	}

	boolean move(byte n){//moves, returns true if succesful
		int dx = 0,dy = 0;
		switch(n){
			case 0:
				dx = 2; dy = 1;
				break;
			case 4:
				dx = -2; dy = -1;
				break;
			case 1:
				dx = 1; dy = 2;
				break;
			case 5:
				dx = -1; dy = -2;
				break;
			case 2:
				dx = -1; dy = 2;
				break;
			case 6:
				dx = 1; dy = -2;
				break;
			case 3:
				dx = -2; dy = 1;
				break;
			case 7:
				dx = 2; dy = -1;
				break;
			
		}
		if(isValid(kx + dx, ky + dy)){
			kx += dx; ky += dy;
			grid[kx][ky] = true;
			moves.push(n);
			return true;
		}
		return false;
	}

	byte undoMove(){//doesnt check for validity, use at own risk
		int dx = 0,dy = 0;
		byte n = moves.pop();
		switch(n){
			case 0:
				dx = 2; dy = 1;
				break;
			case 4:
				dx = -2; dy = -1;
				break;
			case 1:
				dx = 1; dy = 2;
				break;
			case 5:
				dx = -1; dy = -2;
				break;
			case 2:
				dx = -1; dy = 2;
				break;
			case 6:
				dx = 1; dy = -2;
				break;
			case 3:
				dx = -2; dy = 1;
				break;
			case 7:
				dx = 2; dy = -1;
				break;
		}
		grid[kx][ky] = false;
		kx -= dx; ky -= dy;
		return n;
	}

	boolean isDone(){
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				if(grid[i][j] == false) return false;
			}
		}
		return true;
	}


	static void playStack(Stack s, int size, int x, int y){

		boolean grid[][] = new boolean[size][size];	
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				grid[i][j] = false;
			}
		}

		Stack s2 = new Stack();
		while(!s.isEmpty()){s2.push(s.pop());}

		int step = 0;
			
		while(!s2.isEmpty()){
			step++;
			
			int dx = 0,dy = 0;
			switch(s2.pop()){
				case 0:
					dx = 2; dy = 1;
					break;
				case 4:
					dx = -2; dy = -1;
					break;
				case 1:
					dx = 1; dy = 2;
					break;
				case 5:
					dx = -1; dy = -2;
					break;
				case 2:
					dx = -1; dy = 2;
					break;
				case 6:
					dx = 1; dy = -2;
					break;
				case 3:
					dx = -2; dy = 1;
					break;
				case 7:
					dx = 2; dy = -1;
					break;
				
			}
			grid[x][y] = true;
			x += dx; y += dy;

			String result = "";
			for(int i = 0; i < grid.length;i++){
				for(int j = 0; j < grid[0].length;j++){
					result+= grid[j][i]?"0":":";
				}
				result += "\n";
			}
			result += "\n" + s2 + "\nStep: " + step;
			char esc = 0x1b;
			System.out.println(esc + "[2J"  + esc + "[0;0f" + result );
			System.out.println(x + " " + y + esc + "[" + (y + 1) + ";" + (x + 1) + "fK\n");

			try{Thread.sleep(250);}catch(Exception e){}
		}
	}
}
