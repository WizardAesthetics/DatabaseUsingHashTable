/*
 *  Topics covered: A generic class with bounded type parameter
 *  Author:         COSC 311, Fall '20
 *  Date:           9-24-20
*/

public class Pair <E extends Comparable<E>> implements Comparable<Pair<E>> {
	private E key;
	private E id;
	
	// constructors
	public Pair() {
		key = id = null;
	}
	
	public Pair (E one , E two) {
		key = one;
		id = two;
	}
	
	// getters and setters
	public void setFirst (E other) {
		key = other;
	}
	
	public void setSecond (E other) {
		id = other;
	}
	
	public E getFirst () {
		return key;
	}
	
	public E getSecond () {
		return id;
	}
	
	// return a string representing a pair
	public String toString() {
		return "(" +key.toString() + "," + id.toString() + ")";
		
	}
	
	// equals method
	public boolean equals (Object other) {
		if (other == null) return false;
		else if (getClass() != other.getClass()) return false;
		else {
			Pair <E> otherPair = (Pair<E>) other;
			return key.equals(otherPair.key) && id.equals(otherPair.id);
		}
		
	}
	
	// compares to pair objects based on the value of their first element
	public int compareTo(Pair<E> other) {
		if (key.compareTo(other.key) < 0)
			return -1;
		else if (key.compareTo(other.key) >0)
			return 1;
		else
			return 0;
	}
	
	// return the largest of the two elements
	public E max() {
		if (key.compareTo(id)>=0)
			return key;
		else 
			return id;
			
	}
}
