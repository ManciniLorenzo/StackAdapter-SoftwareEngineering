package myTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myAdapter.*;
import java.util.NoSuchElementException;
/**
 * TestIterator class
 */
public class TestIterator {

	StackAdapter emptyStack;
	StackAdapter oneStack;
	StackAdapter longStack;
	
	/**
	 * TestIterator setUp
	 */
	@Before
	public void setUp(){
		emptyStack = new StackAdapter();
		
		oneStack = new StackAdapter();
		oneStack.push("asso");
		
		longStack = new StackAdapter();
		for(int i = 0; i < 100; i++) {
			longStack.push(i);
		}
	}

	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.iterator method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the iterator() method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the iterator method returns an HIterator object as iterator of StackAdapter.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * An HIterator object is returned from the method.
	 * The StackAdapter hasn't changed due to the creation of the iterator.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The StackAdapter hasn't been modified by the iterator() method, no exception is thrown.
	 */
	@Test
	public void testIterator() {
		assertNotNull(emptyStack.iterator());
		assertNotNull(oneStack.iterator());
		
		HIterator iter = longStack.iterator();
		assertNotNull(iter);
		while(iter.hasNext()) {
			iter.next();
			iter.remove();
		}
		assertTrue(longStack.isEmpty());
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.iterator method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the iterator() method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the proper functioning of the HIterator returned by iterator().
	 * In particular the next() method on of an HIterator on an empty StackAdapter.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * 
	 * <h4>Post-Condition</h4>
	 * An HIterator object is returned from the method.
	 * The StackAdapter hasn't changed due to the creation of the iterator.
	 * NoSuchElementException is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The StackAdapter hasn't been modified by the iterator() method, NoSuchElementException is thrown.
	 */
	@Test(expected=NoSuchElementException.class)
	public void testIteratorNoSuchElementException() {
		HIterator iter = emptyStack.iterator();
		assertFalse(iter.hasNext());
		iter.next();
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.iterator method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the iterator() method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the proper functioning of the HIterator returned by iterator().
	 * In particular the remove() method on of an HIterator on an empty StackAdapter.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * 
	 * <h4>Post-Condition</h4>
	 * An HIterator object is returned from the method.
	 * The StackAdapter hasn't changed due to the creation of the iterator.
	 * IllegalStateException is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The StackAdapter hasn't been modified by the iterator() method, IllegalStateException is thrown.
	 */
	@Test(expected=IllegalStateException.class)
	public void testIteratorIllegalStateException() {
		HIterator iter = emptyStack.iterator();
		iter.remove();
	}


}
