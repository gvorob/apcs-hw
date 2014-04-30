public class Tree{

	private Node root;

	private class Node{
		public int data;
		public Node left, right;


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

		public String toString(){
			String l = "";
			String r = "";
			if(left != null) l = left.toString();
			if(right != null) r = right.toString();
			return "(" + l + " " + data + " " + r + ")";
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

	public static void main(String[] args){
		Tree t = new Tree();
		t.insert(3);
		t.insert(2);
		t.insert(5);
		t.insert(4);
		t.insert(6);
		t.insert(1);
		System.out.println(t.height());
		System.out.println(t.find(1) == null);
		System.out.println(t.search(2) == null);
		System.out.println(t.root);


	}

	public Tree(){
	}

	public int height(){if(root == null) return 0; return root.height();}
	public Node find(int n){if(root == null) return null; return root.find(n);}
	public void insert(int n){if(root == null) root = new Node(n); else root.binInsert(n);}
	public Node search(int n){if(root == null) return null; return root.binSearch(n);}
	
	public void delete(Node n){//still doesnt work

		Node temp = n;
		if(temp.left != null){
			temp = temp.left;
			while(temp.right != null)
				temp = temp.right;
			n.data = temp.data;
			delete(temp);
			return;
		}
		if(temp.right != null){
			temp = temp.right;
			while(temp.left != null)
				temp = temp.left;
			n.data = temp.data;
			delete(temp);
			return;
		}
		
	}
}
