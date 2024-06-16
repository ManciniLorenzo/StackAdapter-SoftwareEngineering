package myTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myAdapter.StackAdapter;
/**
 * TestSearch class
 */
public class TestSearch {

	StackAdapter emptyStack;
	StackAdapter oneStack;
	StackAdapter longStack;
	
	/**
	 * TestSearch setUp
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
	 * Test StackAdapter.search method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the search() method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the search method returns the 1-based position from the top of the stack where an object is on this StackAdapter.
	 * If the object is not contained in the StackAdapter is returned -1.
	 * 
	 * <h4>Pre-Condition</h4>
	 * None.
	 * 
	 * <h4>Post-Condition</h4>
	 * An int index is returned from the method.
	 * The StackAdapter hasn't changed.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The StackAdapter hasn't changed, no exception is thrown.
	 */
	@Test
	public void testSearch() {
		assertEquals(emptyStack.search("asso"), -1);
		assertEquals(oneStack.search("asso"), 1);
		for(int i = 0; i < 100; i++) {
			assertEquals(longStack.search(i), longStack.size() - i);
		}
	}

}
