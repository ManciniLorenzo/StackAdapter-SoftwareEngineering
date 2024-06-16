package myTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myAdapter.StackAdapter;
/**
 * TestIndexOf class
 */
public class TestIndexOf {
	StackAdapter emptyStack;
	StackAdapter oneStack;
	StackAdapter longStack;
	
	/**
	 * TestIndexOf setUp
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
	 * Test StackAdapter.indexOf method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the indexOf(Object) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the indexOf method returns the index in this StackAdapter of the first occurrence of the specified element, or -1 if this StackAdapter does not contain this element. 
	 * More formally, returns the lowest index i such that {@code(o==null ? get(i)==null : o.equals(get(i)))}, or -1 if there is no such index.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * After the call to indexOf() method this StackAdapter hasn't changed.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * After the call to indexOf() method this StackAdapter hasn't changed, no exception is thrown.
	 */
	@Test
	public void testIndexOf() {
		assertEquals(-1, emptyStack.indexOf("something"));
		assertEquals(0, oneStack.indexOf("asso"));
		
		for(int i = 0; i < 100; i++) {
			assertEquals(i, longStack.indexOf(i));
		}
	}

}
