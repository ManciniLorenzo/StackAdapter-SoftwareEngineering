package myTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myAdapter.StackAdapter;
/**
 * TestHashCode class
 */
public class TestHashCode {

	StackAdapter emptyStack;
	StackAdapter oneStack;
	StackAdapter longStack;

	/**
	 * TestHashCode setUp
	 */
	@Before
	public void setUp() {
		emptyStack = new StackAdapter();

		oneStack = new StackAdapter();
		oneStack.push(1);

		longStack = new StackAdapter();
		for (int i = 0; i < 100; i++) {
			longStack.push(i);
		}
	}

	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.hashCode method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the hashCode() method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the hashCode method Returns the hash code value for this list.
	 * 
	 * <p>The hash code is calculated as follows:</p>
	 * <pre>
	 * hashCode = 1;
	 * HIterator i = list.iterator();
	 * while (i.hasNext()) {
	 * 	Object obj = i.next();
	 * 	hashCode = 31*hashCode + (obj==null ? 0 : obj.hashCode());
	 * }
	 * </pre>
	 * <p>{@code list1.equals(list2)} implies that {@code list1.hashCode()==list2.hashCode()} for any two lists</p>
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * The StackAdapter isn't affected by the call to hashCode() method.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The StackAdapter isn't affected by the call to hashCode() method, no exception is thrown.
	 */
	@Test
	public void testHashCode() {
		assertEquals(emptyStack.hashCode(), 1);
		
		int hashCode = 1;
		hashCode = 31*hashCode + 0;
		hashCode = 31*hashCode + 1;
		hashCode = 31*hashCode + 2;
		hashCode = 31*hashCode + 3;
		hashCode = 31*hashCode + 4;
		hashCode = 31*hashCode + 5;
		StackAdapter toHash = new StackAdapter();
		for(int i = 0; i < 6; i++) {
			toHash.push(i);
		}
		assertEquals(hashCode, toHash.hashCode());
		toHash.add(6);
		assertEquals(31*hashCode + 6, toHash.hashCode());
		
		assertEquals(oneStack.hashCode(), oneStack.hashCode());
		
		toHash.clear();
		for(int i = 0; i < 100; i++) {
			toHash.push(i);
		}
		assertEquals(longStack.hashCode(), toHash.hashCode());
	}

}
