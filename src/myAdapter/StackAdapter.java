package myAdapter;

import java.util.*;

/**
 * Adapter for the HList interface 
 * <p>
 * The adaptee for this class is the myAdapter.Vector class that follows CLDC 1.1 framework
 * <p>
 * To avoid collisions with the Collection, List, Iterator, and ListIterator interfaces of the current version of Java 
 * interfaces HList, HCollection, HIterator, and HListIterator were defined locally to the myAdapter package
 * with all the methods of the List, Collection, Iterator and ListIterator interfaces from Java version 1.4.2. 
 * <p>
 * The StackAdapter class implements the interfaces HList, HCollection. 
 */
public class StackAdapter implements HList, HCollection {

	/*
	 * Vector that contains the StackAdapter elements
	 * <p>
	 * The java.util.Vector class version used in this project it's described by the CLDC 1.1 framework.
	 * <p>
	 * To apply this framework the java.util.Vector class is redefined by the myAdapter.Vector class.
	 */
	private Vector v;
	
	/*
	 * The first index of the vector v accessible by the StackAdapter
	 */
	private int startIndex;
	
	/*
	 * The last index of the vector v accessible by the StackAdapter
	 */
	private int endIndex;
	
	/**
	 * Constructs an empty StackAdapter
	 */
	public StackAdapter() {
		v = new Vector();
		startIndex = 0;
		endIndex = Integer.MAX_VALUE;
	}
	
	/**
	 * Constructs a StackAdapter where the elements are those contained in the vector parameter.
	 * @param v vector that contains the element of the StackAdapter
	 * @param startIndex position of the first element accessible
	 * @param endIndex position of the first element not accessible
	 */
	public StackAdapter(Vector v, int startIndex, int endIndex) {
		this.v = v;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}
	
	/**
	 * Constructs a StackAdapter containing the elements of the specified collection.
	 * @param c elements to be inserted into this StackAdapter
	 * @throws NullPointerException if the specified collection is null.
	 */
	public StackAdapter(HCollection c) {
		this();
		if(c==null) throw new NullPointerException();
		HIterator it = c.iterator();
		while(it.hasNext()) add(it.next());
	}
	
	/**
	 * Pushes an item onto the top of this stack. This has exactly the same effect as: addElement(item)
	 * @param item the item to be pushed onto this stack.
	 * @return the item argument.
	 */
	public Object push(Object item) {
		v.addElement(item);
		return item;
	}
	
	/**
	 * Removes the object at the top of this stack and returns that object as the value of this function.
	 * @return the object at the top of this stack (the last item of the Vector object).
	 * @throws EmptyStackException if this stack is empty.
	 */
	public Object pop() {
		if(v.isEmpty()) throw new EmptyStackException();
		return remove(startIndex + size() -1);
	}
	
	/**
	 * Looks at the object at the top of this stack without removing it from the stack.
	 * @return the object at the top of this stack (the last item of the Vector object).
	 * @throws IndexOutOfBoundsException if this stack is empty.
	 */
	public Object peek() {
		return get(startIndex + size() - 1);
	}
	
	/**
	 * Tests if this stack is empty.
	 * @return true if and only if this stack contains no items; false otherwise.
	 */
	public boolean empty() {
		return isEmpty();
	}
	
	/**
	 * Returns the 1-based position where an object is on this stack. 
	 * If the object o occurs as an item in this stack, this method returns the distance from the top of the stack of the occurrence nearest the top of the stack; 
	 * the topmost item on the stack is considered to be at distance 1. 
	 * The equals method is used to compare o to the items in this stack.
	 * @param o the desired object.
	 * @return the 1-based position from the top of the stack where the object is located; the return value -1 indicates that the object is not on the stack.
	 */
	public int search(Object o) {
		if(!contains(o)) return -1;
		int i = size() - 1;
		while(!o.equals(get(i))) {
			i--;
		}
		return size() - i;
	}
	
	/**
	 * Returns the number of elements in this list. If this list contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
	 * @return the number of elements contained in this StackAdapter.
	 */
	public int size() {
		if (endIndex == Integer.MAX_VALUE) {
			return v.size() - startIndex;
		}
		return endIndex - startIndex;
	}
	
	/**
	 * Tests if this StackAdapter has no components.
	 * @return true if this StackAdapter contains no elements; false otherwise.
	 */
	public boolean isEmpty() {
		return size() == 0;
	}
	
	/**
	 * Returns true if this list contains the specified element. More formally, returns true if and only if this list contains at least one element e such that (o==null ? e==null : o.equals(e)).
	 * @param o an object
	 * @return true if the specified object is a component in this StackAdapter; false otherwise.
	 */
	public boolean contains(Object o) {
		return indexOf(o)>=0;
	}
	
	/**
	 * Return an HIterator object as iterator of StackAdapter.
	 * @return an HIterator object as iterator of StackAdapter.
	 */
	public HIterator iterator() {
		return new StackIterator();
	}
	
	/**
	 * Returns an array containing all of the elements in this list in proper sequence. Obeys the general contract of the HCollection.toArray method.
	 * @return an array containing all of the elements in this list in proper sequence.
	 */
	public Object[] toArray() {
		return toArray(new Object[size()]);
	}
	
	/**
	 * Returns an array containing all of the elements in this list in proper sequence; the runtime type of the returned array is that of the specified array. Obeys the general contract of the Collection.toArray(Object[]) method.
	 * @param a the array into which the elements of this list are to be stored, if it is big enough;
	 * @return an array containing the elements of this list.
	 * @throws NullPointerException if the specified array is {@code null}
	 * @throws IllegalArgumentException if the length of the specified array is not enough to contain all the elements
	 * @throws ArrayStoreException if the runtime type of the specified array is not a supertype of all the elements
	 */
	public Object[] toArray(Object[] a) {
		if(a == null) throw new NullPointerException();
		if(a.length < size()) throw new IllegalArgumentException();
		HIterator iter = iterator();
		for(int i = 0; i < size(); i++) {
			a[i] = iter.next();
		}
		if(a.length > size()) {
			a[size()] = null;
		}
		return a;
	}
	
	/**
	 * Appends the specified element to the end of this list (optional operation).
	 * <p>
	 * Lists that support this operation may place limitations on what elements may be added to this list. 
	 * In particular, some lists will refuse to add null elements, and others will impose restrictions on the type of elements that may be added. 
	 * List classes should clearly specify in their documentation any restrictions on what elements may be added.
	 * @param o element to be appended to this list.
	 * @return true (as per the general contract of the Collection.add method).
	 */
	public boolean add(Object o) {
		v.insertElementAt(o, startIndex + size());
		if (endIndex < Integer.MAX_VALUE) {
			endIndex++;
		}
		return true;
	}
	
	/**
	 * Removes the first occurrence in this list of the specified element (optional operation). 
	 * If this list does not contain the element, it is unchanged. 
	 * More formally, removes the element with the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists).
	 * @param o element to be removed from this list, if present.
	 * @return true if this list contained the specified element.
	 */
	public boolean remove(Object o) {
		int index = indexOf(o);
		if(index < 0) return false;
		remove(index);
		return true;
	}
	
	/**
	 * Returns true if this list contains all of the elements of the specified collection.
	 * @param c collection to be checked for containment in this list.
	 * @return true if this list contains all of the elements of the specified collection.
	 * @throws NullPointerException if the specified collection is null.
	 */
	public boolean containsAll(HCollection c) {
		if(c == null) throw new NullPointerException();
		HIterator iter = c.iterator();
		while(iter.hasNext()) {
			if(!contains(iter.next())) return false;
		}
		return true;
	}
	
	/**
	 * Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's iterator (optional operation). 
	 * The behavior of this operation is unspecified if the specified collection is modified while the operation is in progress. 
	 * (Note that this will occur if the specified collection is this list, and it's nonempty.)
	 * @param c collection whose elements are to be added to this list.
	 * @return true if this list changed as a result of the call.
	 * @throws NullPointerException if the specified collection contains one or more null elements and this list does not support null elements, or if the specified collection is null.
	 */
	public boolean addAll(HCollection c) {
		return addAll(size(), c);
	}
	
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
	 * @throws NullPointerException if the specified collection contains one or more null elements and this list does not support null elements, or if the specified collection is null.
	 */
	public boolean addAll(int index, HCollection c) {
		HListIterator listIter = listIterator(index);
		if(c == null) throw new NullPointerException();
		if(c.isEmpty()) return false;
		HIterator iter = c.iterator();
		while(iter.hasNext()) {
			listIter.add(iter.next());
		}
		return true;
	}
	
	/**
	 * Removes from this list all the elements that are contained in the specified collection (optional operation).
	 * @param c collection that defines which elements will be removed from this list.
	 * @return true if this list changed as a result of the call.
	 * @throws NullPointerException if the specified collection is null.
	 */
	public boolean removeAll(HCollection c) {
		if(c == null) throw new NullPointerException();
		boolean done = false;
		HIterator iter = c.iterator();
		while(iter.hasNext()) {
			boolean ris = false;
			Object o = iter.next();
			do{
				ris = remove(o);
				done = ris || done;
			}while(ris);
		}
		return done;
	}
	
	/**
	 * Retains only the elements in this list that are contained in the specified collection (optional operation). 
	 * In other words, removes from this list all the elements that are not contained in the specified collection.
	 * @param c collection that defines which elements this set will retain.
	 * @return true if this list changed as a result of the call.
	 * @throws NullPointerException if the specified collection is null.
	 */
	public boolean retainAll(HCollection c) {
		if(c == null) throw new NullPointerException();
		boolean done = false;
		HIterator iter = iterator();
		while(iter.hasNext()) {
			Object o = iter.next();
			if(!c.contains(o)) {
				iter.remove();
				done = true;
			}
		}
		return done;
	}
	
	/**
	 * Removes all of the elements from this list (optional operation). 
	 * This list will be empty after this call returns (unless it throws an exception).
	 */
	public void clear() {
		while (!isEmpty()) {
			remove(0);
		}
	}
	
	/**
	 * Compares the specified object with this list for equality. 
	 * Returns true if and only if the specified object is also a list, both lists have the same size, and all corresponding pairs of elements in the two lists are equal. 
	 * (Two elements e1 and e2 are equal {@code if(e1==null ? e2==null : e1.equals(e2))})
	 * In other words, two lists are defined to be equal if they contain the same elements in the same order. 
	 * This definition ensures that the equals method works properly across different implementations of the List interface.
	 * @param o the object to be compared for equality with this list.
	 * @return true if the specified object is equal to this list.
	 */
	public boolean equals(Object o) {
		if(o == null) return false;
		if(!(o instanceof HList)) return false;
		HList oStack = (HList) o;
		if(oStack.size()!=size()) return false;
		HIterator oIterator = oStack.iterator();
		HIterator myIterator = iterator();
		while(myIterator.hasNext()) {
			Object myElem = myIterator.next();
			Object oElem = oIterator.next();
			if(!(myElem == null ? oElem == null : myElem.equals(oElem))) return false;
		}
		return true;
	}
	
	/**
	 * Returns the hash code value for this list.
	 * 
	 * <p>The hash code is calculated as follows:</p>
	 * <pre>
	 * hashCode = 1;
	 * HIterator i = list.iterator();
	 * while (i.hasNext()) {
	 * 		Object obj = i.next();
	 * 		hashCode = 31*hashCode + (obj==null ? 0 : obj.hashCode());
	 * }
	 * </pre>
	 * <p>{@code list1.equals(list2)} implies that {@code list1.hashCode()==list2.hashCode()} for any two lists</p>
	 * 
	 * @return the hash code value for this list
	 */
	public int hashCode() {
		int hashCode = 1;
		HIterator i = iterator();
		while (i.hasNext()) {
			Object o = i.next();
			hashCode = 31*hashCode + (o == null ? 0 : o.hashCode());
		}
		return hashCode;
	}
	
	/**
	 * Returns the element at the specified position in this list.
	 * @param index index of element to return.
	 * @return the element at the specified position in this list.
	 * @throws IndexOutOfBoundsException if the index is out of range {@code(index < 0 || index >= size())}.
	 */
	public Object get(int index) {
		if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
		return v.elementAt(startIndex + index);
	}
	
	/**
	 * Replaces the element at the specified position with the specified element.
	 * @param index index of element to replace.
	 * @param element element to be stored at the specified position.
	 * @return the element previously at the specified position.
	 * @throws IndexOutOfBoundsException if the index is out of range {@code(index < 0 || index >= size())}.
	 */
	public Object set(int index, Object element) {
		Object obj = get(index);
		v.setElementAt(element, startIndex + index);
		return obj;
	}
	
	/**
	 * Inserts the specified element at the specified position in this list (optional operation). Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
	 * @param index index at which the specified element is to be inserted.
	 * @param element element to be inserted.
	 * @throws IndexOutOfBoundsException if the index is out of range {@code(index < 0 || index > size())}.
	 */
	public void add(int index, Object element) {
		if (index < 0 || index > size()) throw new IndexOutOfBoundsException();
		v.insertElementAt(element, startIndex + index);
		if (endIndex < Integer.MAX_VALUE) {
			endIndex++;
		}
	}
	
	/**
	 * Removes the element at the specified position in this list (optional operation). 
	 * Shifts any subsequent elements to the left (subtracts one from their indices). 
	 * Returns the element that was removed from the list.
	 * @param index the index of the element to removed.
	 * @return the element previously at the specified position.
	 * @throws IndexOutOfBoundsException if the index is out of range {@code(index < 0 || index >= size())}.
	 */
	public Object remove(int index) {
		Object removed = get(index);
		v.removeElementAt(startIndex + index);
		if (endIndex < Integer.MAX_VALUE) {
			endIndex--;
		}
		return removed;
	}
	
	/**
	 * Returns the index in this list of the first occurrence of the specified element, or -1 if this list does not contain this element. 
	 * More formally, returns the lowest index i such that {@code(o==null ? get(i)==null : o.equals(get(i)))}, or -1 if there is no such index.
	 * @param o element to search for.
	 * @return the index in this list of the first occurrence of the specified element, or -1 if this list does not contain this element.
	 */
	public int indexOf(Object o) {
		int index = 0;
		HIterator iter = iterator();
		while (iter.hasNext()) {
			Object myObj = iter.next();
			if (o == null) {
				if (myObj == null)
					return index;
			} else {
				if (o.equals(myObj))
					return index;
			}
			index++;
		}
		return -1;
	}
	
	/**
	 * Returns the index in this list of the last occurrence of the specified element, or -1 if this list does not contain this element. 
	 * More formally, returns the highest index i such that {@code(o==null ? get(i)==null : o.equals(get(i)))}, or -1 if there is no such index.
	 * @param o element to search for.
	 * @return the index in this list of the last occurrence of the specified element, or -1 if this list does not contain this element.
	 */
	public int lastIndexOf(Object o) {
		int index = size();
		HListIterator iter = listIterator(size());
		while (iter.hasPrevious()) {
			Object myObj = iter.previous();
			index--;
			if (o == null) {
				if (myObj == null)
					return index;
			} else {
				if (o.equals(myObj))
					return index;
			}
		}
		return -1;
	}
	
	/**
	 * Returns a list iterator of the elements in this list (in proper sequence).
	 * @return a list iterator of the elements in this list (in proper sequence).
	 */
	public HListIterator listIterator() {
		return new StackIterator();
	}
	
	/**
	 * Returns a list iterator of the elements in this list (in proper sequence), starting at the specified position in this list. 
	 * The specified index indicates the first element that would be returned by an initial call to the next method. 
	 * An initial call to the previous method would return the element with the specified index minus one.
	 * @param index index of first element to be returned from the list iterator (by a call to the next method).
	 * @return a list iterator of the elements in this list (in proper sequence), starting at the specified position in this list.
	 * @throws IndexOutOfBoundsException if the index is out of range {@code(index < 0 || index > size())}.
	 */
	public HListIterator listIterator(int index) {
		if (index < 0 || index > size()) throw new IndexOutOfBoundsException();
		return new StackIterator(index);
	}
	
	/**
	 * Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive. 
	 * (If fromIndex and toIndex are equal, the returned list is empty.) 
	 * The returned list is backed by this list, so non-structural changes in the returned list are reflected in this list, and vice-versa. 
	 * The returned list supports all of the optional list operations supported by this list.
	 * @param fromIndex low endpoint (inclusive) of the subList.
	 * @param toIndex high endpoint (exclusive) of the subList.
	 * @return a view of the specified range within this list.
	 * @throws IndexOutOfBoundsException for an illegal endpoint index value {@code(fromIndex < 0 || toIndex > size || fromIndex > toIndex)}.
	 */
	public StackAdapter subList(int fromIndex, int toIndex) {
		if(fromIndex < 0 || toIndex > size() || fromIndex > toIndex) throw new IndexOutOfBoundsException();
		if(toIndex == size()) {
			return new StackAdapter(v, startIndex+fromIndex, endIndex);
		}
		return new StackAdapter(v, startIndex+fromIndex, startIndex+toIndex);
	}
	
	/**
	 * Implementation of the HListIterator interface for StackAdapter.
	 */
	private class StackIterator implements HIterator, HListIterator {

		/**
		 * The cursor that indicates the iterator current position in the StackAdapter
		 */
		int index;
		
		/**
		 * The cursor that indicates the last element returned by the next() or previous() methods.
		 * It is used by set() and remove() methods which modify the last element returned by methods next() or previous().
		 * Default value is -1 until a call to next() or previous() methods.
		 * When add() or remove() are called the cursor returns to its default value;
		 */
		int lastIndex;
		
		/**
		 * Constructs a StackIterator positioned at the beginning of the StackAdapter.
		 */
		public StackIterator() {this(0);}
		
		/**
		 * Constructs a StackIterator positioned at the specified index of the StackAdapter.
		 */
		public StackIterator(int index) {
			this.index = index;
			lastIndex = -1;
		}
		
		/**
		 * Returns true if this list iterator has more elements when traversing the list in the forward direction. 
		 * (In other words, returns true if next would return an element rather than throwing an exception.)
		 * @return true if the list iterator has more elements when traversing the list in the forward direction.
		 */
		public boolean hasNext() {
			return index < size();
		}
		
		/**
		 * Returns the next element in the list. 
		 * This method may be called repeatedly to iterate through the list, or intermixed with calls to previous to go back and forth. 
		 * (Note that alternating calls to next and previous will return the same element repeatedly.)
		 * @return the next element in the list.
		 * @throws NoSuchElementException - if the iteration has no next element.
		 */
		public Object next() {
			if(!hasNext()) throw new java.util.NoSuchElementException();
			lastIndex = nextIndex();
			Object retNext = get(nextIndex());
			index++;
			return retNext;
		}
		
		/**
		 * Returns true if this list iterator has more elements when traversing the list in the reverse direction. 
		 * (In other words, returns true if previous would return an element rather than throwing an exception.)
		 * @return true if the list iterator has more elements when traversing the list in the reverse direction.
		 */
		public boolean hasPrevious() {
			return index > 0;
		}
		
		/**
		 * Returns the previous element in the list. 
		 * This method may be called repeatedly to iterate through the list backwards, or intermixed with calls to next to go back and forth. 
		 * (Note that alternating calls to next and previous will return the same element repeatedly.)
		 * @return the previous element in the list.
		 * @throws NoSuchElementException - if the iteration has no previous element.
		 */
		public Object previous() {
			if(!hasPrevious()) throw new java.util.NoSuchElementException();
			lastIndex = previousIndex();
			Object retPrevious = get(previousIndex());
			index--;
			return retPrevious;
		}
		
		/**
		 * Returns the index of the element that would be returned by a subsequent call to next. 
		 * (Returns list size if the list iterator is at the end of the list.)
		 * @return the index of the element that would be returned by a subsequent call to next, or list size if list iterator is at end of list.
		 */
		public int nextIndex() {
			return index;
		}
		
		/**
		 * Returns the index of the element that would be returned by a subsequent call to previous. 
		 * (Returns -1 if the list iterator is at the beginning of the list.)
		 * @return the index of the element that would be returned by a subsequent call to previous, or -1 if list iterator is at beginning of list.
		 */
		public int previousIndex() {
			return index - 1;
		}
		
		/**
		 * Removes from the list the last element that was returned by next or previous (optional operation). 
		 * This call can only be made once per call to next or previous. 
		 * It can be made only if HListIterator.add has not been called after the last call to next or previous.
		 * @throws IllegalStateException - neither next nor previous have been called, or remove or add have been called after the last call to * next or previous.
		 */
		public void remove() {
			if(lastIndex < 0) throw new IllegalStateException();
			StackAdapter.this.remove(lastIndex);
			if (index > lastIndex) {
				index--;
			}
			lastIndex = -1;
		}
		
		/**
		 * Replaces the last element returned by next or previous with the specified element (optional operation). 
		 * This call can be made only if neither HListIterator.remove nor HListIterator.add have been called after the last call to next or previous.
		 * @param o - the element with which to replace the last element returned by next or previous.
		 * @throws IllegalStateException - if neither next nor previous have been called, or remove or add have been called after the last call to next or previous.
		 */
		public void set(Object o) {
			if(lastIndex < 0) throw new IllegalStateException();
			StackAdapter.this.set(lastIndex, o);
		}
		
		/**
		 * Inserts the specified element into the list (optional operation). 
		 * The element is inserted immediately before the next element that would be returned by next, if any, and after the next element that would be returned by previous, if any. 
		 * (If the list contains no elements, the new element becomes the sole element on the list.) 
		 * The new element is inserted before the implicit cursor: a subsequent call to next would be unaffected, and a subsequent call to previous would return the new element. 
		 * (This call increases by one the value that would be returned by a call to nextIndex or previousIndex.)
		 * @param o - the element to insert.
		 */
		public void add(Object o) {
			StackAdapter.this.add(index, o);
			index++;
			lastIndex = -1;
		}
	}
}
