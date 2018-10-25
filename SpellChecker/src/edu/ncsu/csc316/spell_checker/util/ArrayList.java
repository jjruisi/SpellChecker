package edu.ncsu.csc316.spell_checker.util;

/**
 * Array list
 * @author John Ruisi
 *
 * @param <E> generic element
 */
public class ArrayList<E> {

	/** Initial size of the array */
	private static final int RESIZE = 10;
	/** Array of generic objects*/
	private E[] list;
	/** size of the array */
	private int size;
	
	private int entries;
	
	/**
	 * Constructor initalizes the list and sets the size to zero
	 */
	@SuppressWarnings("unchecked")
	public ArrayList() {
		list = (E[]) (new Object[RESIZE]);
		size = 0;
	}
	
	/**
	 * Creates array list with a specific size
	 * @param size the size of the list
	 */
	@SuppressWarnings("unchecked")
	public ArrayList(int size) {
		list = (E[]) (new Object[size]);
		this.size = size;
	}
	
	/**
	 * Returns the size of the array
	 * @return size the size of the array
	 */
	public int size() {
		return size;
	}
	
	/**
	 * sets the given index to an object
	 * @param idx the index to set
	 * @param o the object to set to
	 */
	public void set(int idx, E o) {
		list[idx] = o;
	}
	
	/**
	 * Gets the entries of the list
	 * @return entries the number of entries
	 */
	public int entries() {
		return entries;
	}
	
	/**
	 * Adds a generic object to the end of the list
	 * @param o the object to be added
	 */
	public void add(E o) {
		if (size() == list.length) {
			growArray();
		}
		list[size()] = o;
		size++;
	}
	
	/**
	 * Adds to a specific index
	 * @param o the object to be added
	 * @param idx the index to add to
	 * @return true is it is added
	 */
	public boolean add(E o, int idx) {
		if (list[idx] != null) {
			return false;
		} else {
			list[idx] = o;
			entries++;
			return true;
		}
	}
	
	/**
	 * Gets the object at the specific index
	 * @param idx the specific index
	 * @return the object at that index
	 */
	public E get(int idx) {
		if (idx < 0 || idx >= size()) {
			throw new IndexOutOfBoundsException("Invalid Index");
		}
		
		if (list[idx] == null) {
			return null;
		}
		
		return list[idx];
	}
	
	/**
	 * Grows the array if it reaches max capacity
	 */
	@SuppressWarnings("unchecked")
	public void growArray() {
		E[] temp = (E[]) (new Object[list.length * 2]);
		for (int i = 0; i < list.length; i++) {
			temp[i] = list[i];
		}
		list = temp;
	}
}
