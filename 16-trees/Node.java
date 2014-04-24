public class Node{
	public int data;
	public Node left, right;

	public static void main(String[] args){
		Node root = new Node(3);
		root.left = new Node(1);
		root.left.right = new Node(2);
		root.right = new Node(4);
		System.out.println(root.height());
		System.out.println(root.find(1) == null);
		System.out.println(root.binSearch(2) == null);


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
		return null;	
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
