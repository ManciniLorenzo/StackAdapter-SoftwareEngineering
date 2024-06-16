package myTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myAdapter.StackAdapter;
/**
 * TestLastIndexOf class
 */
public class TestLastIndexOf {

	StackAdapter emptyStack;
	StackAdapter oneStack;
	StackAdapter longStack;
	
	/**
	 * TestLastIndexOf setUp
	 */
	@Before
	public void setUp(){
		emptyStack = new StackAdapter();
		
		oneStack = new StackAdapter();
		oneStack.push("asso");
		
		longStack = new StackAdapter();
		for(int i = 0; i < 100; i++) {
			longStack.push("" + i);
		}
	}

	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.lastIndexOf method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the lastIndexOf(Object) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the lastIndexOf method returns the index in this StackAdapter of the last occurrence of the specified element, or -1 if this StackAdapter does not contain this element. 
	 * More formally, returns the highest index i such that {@code(o==null ? get(i)==null : o.equals(get(i)))}, or -1 if there is no such index.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * After the call to lastIndexOf() method this StackAdapter hasn't changed.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * After the call to lastIndexOf() method this StackAdapter hasn't changed, no exception is thrown.
	 */
	@Test
	public void testLastIndexOf() {
		assertEquals(-1, emptyStack.lastIndexOf("something"));
		assertEquals(0, oneStack.lastIndexOf("asso"));
		longStack.add("item");
		assertEquals(100, longStack.lastIndexOf("item"));
		for(int i = 0; i < 100; i++) {
			assertEquals(i, longStack.lastIndexOf("" + i));
		}
	}

}
