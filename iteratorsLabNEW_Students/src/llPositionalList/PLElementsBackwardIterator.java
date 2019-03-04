package llPositionalList;

import java.util.Iterator;
import java.util.NoSuchElementException;

import interfaces.Position;
import interfaces.PositionalList;

public class PLElementsBackwardIterator<E> implements Iterator<E> {
	
	PLIteratorL2F<E> iter;
	PositionalList<E> list; 
	

	public PLElementsBackwardIterator(PositionalList<E> list) {
		this.list = list; 
		iter= new PLIteratorL2F<E>(list);
		
	}
	public boolean hasNext() {
		return iter.current != null;
	}
	
	public E next() throws NoSuchElementException {
		return iter.next().getElement();

	}
	public void remove() throws IllegalStateException { 
		if (iter.recent == null)
			throw new IllegalStateException("Invalid state to apply remove."); 
		list.remove(iter.recent); 
		iter.recent = null; 
	}

}