public class Node{
	public int data;
	public Node left, right;

	public static void main(String[] args){
		Node root = new Node(1);
		root.binInsert(5);
		root.binInsert(4);
		root.binInsert(2);
		root.binInsert(3);
		root.binInsert(6);
		System.out.println(root.height());
		System.out.println(root.find(1) == null);
		System.out.println(root.binSearch(2) == null);
		System.out.println(root);


	}

	public Node(int d){
		data = d;
	}

	public boolean hasChildren(){
		return left != null || right != null;
	}

	public int height(){
		int l = 0, r = 0;
		if(left != null)
			l = left.height();
		if(right != null)
			r = right.height();
		return Math.max(l,r) + 1;
	}

	public Node find(int n){
		if(data == n)
			return this;
		Node temp = null;
		if(left != null)
			temp = left.find(n);
		if(temp == null && right != null)
			temp = right.find(n);
		return temp;
	}

	public String toString(){
		String l = "";
		String r = "";
		if(left != null) l = left.toString();
		if(right != null) r = right.toString();
		return "(" + data + " " + left + " " + right + ")";
	}	


	public void binInsert(int n){
		if(data == n)
			return;//ERROR
		if(n < data){
			if(left == null){
				left = new Node(n);
			}
			else{
				left.binInsert(n);
			}
		}
		else{
			if(right == null){
				right = new Node(n);
			}
			else{
				right.binInsert(n);
			}
		}
				
	}
	
	public Node binSearch(int n){
		if(data == n)
			return this;
		if(n > data){
			if(right != null){
				return right.binSearch(n);}
		}
		else{
			if(left != null){
				return left.binSearch(n);}
		}
		return null;
	}
		
}
