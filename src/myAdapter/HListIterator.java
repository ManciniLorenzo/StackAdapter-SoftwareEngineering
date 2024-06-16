
// http://geas.dei.unipd.it/jdk1.4.2/docs/api/java/util/ListIterator.html

package myAdapter;
/**
 * An iterator for lists that allows the programmer to traverse the list in either direction, modify the list during iteration, and obtain the iterator's current position in the list. 
 * A HListIterator has no current element; its cursor position always lies between the element that would be returned by a call to previous() and the element that would be returned by a call to next(). 
 * In a list of length n, there are n+1 valid index values, from 0 to n, inclusive.
 * <pre>
 * 		 Element(0)   Element(1)   Element(2)   ... Element(n)   
 *      ^            ^            ^            ^               ^
 *      Index: 0            1            2            3               n+1
 * </pre>
 * <p>
 * Note that the remove() and set(Object) methods are not defined in terms of the cursor position; they are defined to operate on the last element returned by a call to next() or previous().
 */
public interface HListIterator extends HIterator{
	
	/**
	 * Returns true if this list iterator has more elements when traversing the list in the forward direction. 
	 * (In other words, returns true if next would return an element rather than throwing an exception.)
	 * @return true if the list iterator has more elements when traversing the list in the forward direction.
	 */
	public boolean hasNext();
	
	/**
	 * Returns the next element in the list. 
	 * This method may be called repeatedly to iterate through the list, or intermixed with calls to previous to go back and forth. 
	 * (Note that alternating calls to next and previous will return the same element repeatedly.)
	 * @return the next element in the list.
	 * @exception java.util.NoSuchElementException if the iteration has no next element.
	 */
	public Object next();
	
	/**
	 * Returns true if this list iterator has more elements when traversing the list in the reverse direction. 
	 * (In other words, returns true if previous would return an element rather than throwing an exception.)
	 * @return true if the list iterator has more elements when traversing the list in the reverse direction.
	 */
	public boolean hasPrevious();
	
	/**
	 * Returns the previous element in the list. 
	 * This method may be called repeatedly to iterate through the list backwards, or intermixed with calls to next to go back and forth. 
	 * (Note that alternating calls to next and previous will return the same element repeatedly.)
	 * @return the previous element in the list.
	 * @exception java.util.NoSuchElementException if the iteration has no previous element.
	 */
	public Object previous();
	
	/**
	 * Returns the index of the element that would be returned by a subsequent call to next. 
	 * (Returns list size if the list iterator is at the end of the list.)
	 * @return the index of the element that would be returned by a subsequent call to next, or list size if list iterator is at end of list.
	 */
	public int nextIndex();
	
	/**
	 * Returns the index of the element that would be returned by a subsequent call to previous. 
	 * (Returns -1 if the list iterator is at the beginning of the list.)
	 * @return the index of the element that would be returned by a subsequent call to previous, or -1 if list iterator is at beginning of list.
	 */
	public int previousIndex();
	
	/**
	 * Removes from the list the last element that was returned by next or previous (optional operation). 
	 * This call can only be made once per call to next or previous. 
	 * It can be made only if HListIterator.add has not been called after the last call to next or previous.
	 * @throws IllegalStateException neither next nor previous have been called, or remove or add have been called after the last call to * next or previous.
	 */
	public void remove();
	
	/**
	 * Replaces the last element returned by next or previous with the specified element (optional operation). 
	 * This call can be made only if neither HListIterator.remove nor HListIterator.add have been called after the last call to next or previous.
	 * @param o the element with which to replace the last element returned by next or previous.
	 * @throws IllegalStateException if neither next nor previous have been called, or remove or add have been called after the last call to next or previous.
	 */
	public void set(Object o);
	
	/**
	 * Inserts the specified element into the list (optional operation). 
	 * The element is inserted immediately before the next element that would be returned by next, if any, and after the next element that would be returned by previous, if any. 
	 * (If the list contains no elements, the new element becomes the sole element on the list.) 
	 * The new element is inserted before the implicit cursor: a subsequent call to next would be unaffected, and a subsequent call to previous would return the new element. 
	 * (This call increases by one the value that would be returned by a call to nextIndex or previousIndex.)
	 * @param o the element to insert.
	 */
	public void add(Object o);
	
}
