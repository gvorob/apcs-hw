import java.util.*;

public class LLIterator<E> implements Iterator<E>
{
	Node curr;//curr is before the last returned node
	boolean removed;//if an item has been removed, the list shifts back one

	public LLIterator(Node start){
		removed = true;
		curr = start;
	}

	public boolean hasNext(){
		return curr.next().next() != null;
	}

	public E next(){
		if(!hasNext())
			throw new NoSuchElementException();			
		if(removed){
			removed = false;
			return (E)curr.next().get();
		}
		else{
			curr = curr.next();
			return (E)curr.next().get();
		}
	}

	public void remove() {
		if(removed)
			throw new IllegalStateException();
		removed = true;
		if(curr.next().next() == null)
			curr.setNext(null);
		else
			curr.setNext(curr.next().next());
	}
}
