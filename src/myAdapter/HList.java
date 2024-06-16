
// http://geas.dei.unipd.it/jdk1.4.2/docs/api/java/util/List.html

package myAdapter;
/**
 * An ordered collection (also known as a sequence). 
 * The user of this interface has precise control over where in the list each element is inserted. 
 * The user can access elements by their integer index (position in the list), and search for elements in the list.
 * <p>
 *
 * Unlike sets, lists typically allow duplicate elements. 
 * More formally, lists typically allow pairs of elements e1 and e2 such that e1.equals(e2), and they typically allow multiple null elements if they allow null elements at all. 
 * It is not inconceivable that someone might wish to implement a list that prohibits duplicates, by throwing runtime exceptions when the user attempts to insert them, but we expect this usage to be rare.
 * <p>
 *
 * The HList interface places additional stipulations, beyond those specified in the Collection interface, on the contracts of the iterator, add, remove, equals, and hashCode methods. 
 * Declarations for other inherited methods are also included here for convenience.
 * <p>
 *
 * The HList interface provides four methods for positional (indexed) access to list elements. 
 * Lists (like Java arrays) are zero based. Note that these operations may execute in time proportional to the index value for some implementations (the LinkedList class, for example). 
 * Thus, iterating over the elements in a list is typically preferable to indexing through it if the caller does not know the implementation.
 * <p>
 *
 * The HList interface provides a special iterator, called a HListIterator, that allows element insertion and replacement, and bidirectional access in addition to the normal operations that the HIterator interface provides. 
 * A method is provided to obtain a list iterator that starts at a specified position in the list.
 * <p>
 *
 * The HList interface provides two methods to search for a specified object. 
 * From a performance standpoint, these methods should be used with caution. 
 * In many implementations they will perform costly linear searches.
 * <p>
 *
 * The HList interface provides two methods to efficiently insert and remove multiple elements at an arbitrary point in the list.
 * <p>
 *
 * Note:
 * While it is permissible for lists to contain themselves as elements, extreme caution is advised: the equals and hashCode methods are no longer well defined on a such a list.
 *
 */
public interface HList extends HCollection{
	
	/**
	 * Returns the number of elements in this list. 
	 * If this list contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
	 * @return the number of elements in this list.
	 */
	public int size();
	
	/**
	 * Returns true if this list contains no elements.
	 * @return true if this list contains no elements.
	 */
	public boolean isEmpty();
	
	/**
	 * Returns true if this list contains the specified element. 
	 * More formally, returns true if and only if this list contains at least one element e such that {@code(o==null ? e==null : o.equals(e))}.
	 * @param o element whose presence in this list is to be tested.
     * @return true if this list contains the specified element.
	 */
	public boolean contains(Object o);
	
	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 * @return an iterator over the elements in this list in proper sequence.
	 */
	public HIterator iterator();
	
	/**
	 * Returns an array containing all of the elements in this list in proper sequence. 
	 * Obeys the general contract of the HCollection.toArray method.
	 * @return an array containing all of the elements in this list in proper sequence.
	 */
	public Object[] toArray();
	
	/**
	 * Returns an array containing all of the elements in this list in proper sequence; the runtime type of the returned array is that of the specified array. 
	 * Obeys the general contract of the HCollection.toArray(Object[]) method.
	 * @param a the array into which the elements of this list are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose.
	 * @return an array containing the elements of this list.
	 * @throws NullPointerException if the specified array is null.
	 */
	public Object[] toArray(Object[] a);
	
	/**
	 * Appends the specified element to the end of this list (optional operation).
	 * @param o element to be appended to this list.
	 * @return true (as per the general contract of the HCollection.add method).
	 */
	public boolean add(Object o);
	
	/**
	 * Removes the first occurrence in this list of the specified element (optional operation). 
	 * If this list does not contain the element, it is unchanged. More formally, removes the element with the lowest index i such that {@code(o==null ? get(i)==null : o.equals(get(i)))} (if such an element exists).
	 * @param o element to be removed from this list, if present.
	 * @return true if this list contained the specified element.
	 */
	public boolean remove(Object o);
	
	/**
	 * Returns true if this list contains all of the elements of the specified collection.
	 * @param c collection to be checked for containment in this list.
     * @return true if this list contains all of the elements of the specified collection.
     * @throws NullPointerException if the specified collection is null.
	 */
	public boolean containsAll(HCollection c);
	
	/**
	 * Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's iterator (optional operation). 
	 * The behavior of this operation is unspecified if the specified collection is modified while the operation is in progress. 
	 * (Note that this will occur if the specified collection is this list, and it's nonempty.)
	 * @param c collection whose elements are to be added to this list.
	 * @return true if this list changed as a result of the call.
	 * @throws NullPointerException if the specified collection is null.
	 */
	public boolean addAll(HCollection c);
	
	/**
	 * Inserts all of the elements in the specified collection into this list at the specified position (optional operation). 
	 * Shifts the element currently at that position (if any) and any subsequent elements to the right (increases their indices). 
	 * The new elements will appear in this list in the order that they are returned by the specified collection's iterator. 
	 * The behavior of this operation is unspecified if the specified collection is modified while the operation is in progress. 
	 * (Note that this will occur if the specified collection is this list, and it's nonempty.)
	 * @param index index at which to insert first element from the specified collection.
	 * @param c elements to be inserted into this list.
	 * @return true if this list changed as a result of the call.
	 * @throws IndexOutOfBoundsException if the index is out of range {@code(index < 0 || index > size())}.
	 */
	public boolean addAll(int index, HCollection c);
	
	/**
	 * Removes from this list all the elements that are contained in the specified collection (optional operation).
	 * @param c collection that defines which elements will be removed from this list.
	 * @return true if this list changed as a result of the call.
	 * @throws NullPointerException if the specified collection is null.
	 */
	public boolean removeAll(HCollection c);
	
	/**
	 * Retains only the elements in this list that are contained in the specified collection (optional operation). 
	 * In other words, removes from this list all the elements that are not contained in the specified collection.
	 * @param c collection that defines which elements this set will retain.
	 * @return true if this list changed as a result of the call.
	 * @throws NullPointerException if the specified collection is null.
	 */
	public boolean retainAll(HCollection c);
	
	/**
	 * Removes all of the elements from this list (optional operation). 
	 * This list will be empty after this call returns (unless it throws an exception).
	 */
	public void clear();
	
	/**
	 * Compares the specified object with this list for equality. 
	 * Returns true if and only if the specified object is also a list, both lists have the same size, and all corresponding pairs of elements in the two lists are equal. 
	 * (Two elements e1 and e2 are equal {@code if(e1==null ? e2==null : e1.equals(e2)).})
	 * In other words, two lists are defined to be equal if they contain the same elements in the same order. 
	 * This definition ensures that the equals method works properly across different implementations of the List interface.
	 * @param o the object to be compared for equality with this list.
     * @return true if the specified object is equal to this list.
	 */
	public boolean equals(Object o);
	
	/**
	 * Returns the hash code value for this list. 
	 * The hash code of a list is defined to be the result of the following calculation:
	 * 
	 * <pre>
	 * hashCode = 1;
	 * HIterator i = list.iterator();
	 * while (i.hasNext()) {
	 * 	Object o = i.next();
	 * 	hashCode = 31*hashCode + (o==null ? 0 : o.hashCode());
	 * }
	 * </pre>
	 * This ensures that list1.equals(list2) implies that list1.hashCode()==list2.hashCode() for any two lists, list1 and list2, as required by the general contract of Object.hashCode.
	 * @return the hash code value for this list.
	 */
	public int hashCode();
	
	/**
	 * Returns the element at the specified position in this list.
	 * @param index index of element to return.
	 * @return the element at the specified position in this list.
	 * @throws IndexOutOfBoundsException if the index is out of range {@code(index < 0 || index >= size())}.
	 */
	public Object get(int index);
	
	/**
	 * Replaces the element at the specified position in this list with the specified element (optional operation).
	 * @param index index of element to replace.
	 * @param element element to be stored at the specified position.
	 * @return the element previously at the specified position.
	 * @throws IndexOutOfBoundsException if the index is out of range {@code(index < 0 || index >= size())}.
	 */
	public Object set(int index, Object element);
	
	/**
	 * Inserts the specified element at the specified position in this list (optional operation). 
	 * Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
	 * @param index index at which the specified element is to be inserted.
	 * @param element element to be inserted.
	 * @throws IndexOutOfBoundsException if the index is out of range {@code(index < 0 || index > size())}.
	 */
	public void add(int index, Object element);
	
	/**
	 * Removes the element at the specified position in this list (optional operation). 
	 * Shifts any subsequent elements to the left (subtracts one from their indices). 
	 * Returns the element that was removed from the list.
	 * @param index the index of the element to removed.
	 * @return the element previously at the specified position.
	 * @throws IndexOutOfBoundsException if the index is out of range {@code(index < 0 || index >= size())}.
	 */
	public Object remove(int index);
	
	/**
	 * Returns the index in this list of the first occurrence of the specified element, or -1 if this list does not contain this element. 
	 * More formally, returns the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
	 * @param o element to search for.
	 * @return the index in this list of the first occurrence of the specified element, or -1 if this list does not contain this element.
	 */
	public int indexOf(Object o);
	
	/**
	 * Returns the index in this list of the last occurrence of the specified element, or -1 if this list does not contain this element. 
	 * More formally, returns the highest index i such that {@code(o==null ? get(i)==null : o.equals(get(i)))}, or -1 if there is no such index.
	 * @param o element to search for.
	 * @return the index in this list of the last occurrence of the specified element, or -1 if this list does not contain this element.
	 */
	public int lastIndexOf(Object o);
	
	/**
	 * Returns a list iterator of the elements in this list (in proper sequence).
	 * @return a list iterator of the elements in this list (in proper sequence).
	 */
	public HListIterator listIterator();
	
	/**
	 * Returns a list iterator of the elements in this list (in proper sequence), starting at the specified position in this list. 
	 * The specified index indicates the first element that would be returned by an initial call to the next method. 
	 * An initial call to the previous method would return the element with the specified index minus one.
	 * @param index index of first element to be returned from the list iterator (by a call to the next method).
	 * @return a list iterator of the elements in this list (in proper sequence), starting at the specified position in this list.
	 * @throws IndexOutOfBoundsException if the index is out of range {@code(index < 0 || index > size())}.
	 */
	public HListIterator listIterator(int index);
	
	/**
	 * Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive. 
	 * (If fromIndex and toIndex are equal, the returned list is empty.) 
	 * The returned list is backed by this list, so non-structural changes in the returned list are reflected in this list, and vice-versa. 
	 * The returned list supports all of the optional list operations supported by this list.
	 * <p>
	 * 
	 * This method eliminates the need for explicit range operations (of the sort that commonly exist for arrays). 
	 * Any operation that expects a list can be used as a range operation by passing a subList view instead of a whole list. 
	 * For example, the following idiom removes a range of elements from a list:
	 * <pre>
	 * list.subList(from, to).clear();
	 * </pre>
	 * <p>
	 * Similar idioms may be constructed for indexOf and lastIndexOf, and all of the algorithms in the Collections class can be applied to a subList.
	 * <p>
	 * 
	 * The semantics of the list returned by this method become undefined if the backing list (i.e., this list) is structurally modified in any way other than via the returned list. 
	 * (Structural modifications are those that change the size of this list, or otherwise perturb it in such a fashion that iterations in progress may yield incorrect results.)
	 * @param fromIndex low endpoint (inclusive) of the subList.
	 * @param toIndex high endpoint (exclusive) of the subList.
	 * @return a view of the specified range within this list.
	 * @throws IndexOutOfBoundsException for an illegal endpoint index value {@code(fromIndex < 0 || toIndex > size || fromIndex > toIndex)}.
	 */
	public HList subList(int fromIndex, int toIndex);
	
}
