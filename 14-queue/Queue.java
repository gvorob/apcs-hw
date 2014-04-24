public class Queue{
	private Node<String> head;
	private Node<String> tail;
	int length;
	

	public Queue(){
		head = null;
		tail = null;
		length = 0;
	}

	public void enqueue(String s){
		Node<String> temp = new Node<String>(s);
		if(head == null){
			head = temp;
			tail = temp;
		}
		else{
			tail.setNext(temp);
			tail = tail.next();
		}
		length++;
	}

	public String dequeue(){
		Node temp;
		temp = head;
		if(head == tail){
			head == null;
			tail == null;
		}
		else{
			
