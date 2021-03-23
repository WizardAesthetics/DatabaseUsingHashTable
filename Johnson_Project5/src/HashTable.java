/* 
* Author: Blake Johnson
* Creaded: 12/4/2020
* 
*/

public class HashTable<E extends Comparable<E>> {

	private static final int TABLE_SIZE = 37;
	private AVLTree3<Pair<E>>[] table;

	public HashTable() {
		table = new AVLTree3[TABLE_SIZE]; //Array of AVLTrees
	}

	/*************************************************************/
	// Get Hash table index
	
	public int getHash(int key) {
		return ((key * key) >> 10) % 37;
	}

	/*************************************************************/
	//Get a Pair from hash table
	
	public Pair<E> get(Pair<E> data) {
		E key = data.getFirst();
		int hashIndex = getHash((Integer) key);
		if (table[hashIndex] != null) {//checking to make sure the index is not null
			return table[hashIndex].find(data); //returning the pair
		}
		return null;
	}
	
	

	/*************************************************************/
	//Add a Pair from hash table
	public void put(Pair<E> item) {
		int key = (Integer) item.getFirst();
		key = getHash(key);
		if (table[key] == null) //checking to see if the index is null
			table[key] = new AVLTree3<Pair<E>>(); //making AVLTree
		table[key].add(item); //Adding item
	}

	/*************************************************************/
	// print the hash table using Levelorder traversal of BSTs
	public void print(int start, int end) {
		for (int i = start; i < end; i++)
			if (table[i] != null) {//checking to make sure the index is not null
				System.out.print(i + ": ");
				table[i].levelorder();
			}
	}
	
	/*************************************************************/
	//Remove from hash table
	public void remove(Pair<E> item) {
		E key = item.getFirst();
		int hashIndex = getHash((Integer) key);
		if (table[hashIndex] != null){ //checking to make sure the index is not null
			table[hashIndex].delete(item); //delete 
		}
		if (table[hashIndex].isEmpty()) {
			table[hashIndex] = null; //deleting tree if nothing is in it
		}
	}
}
