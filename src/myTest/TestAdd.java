package myTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myAdapter.StackAdapter;
/**
 * TestAdd class
 */
public class TestAdd {
	
	StackAdapter emptyStack;
	StackAdapter oneStack;
	StackAdapter threeStack;
	
	/**
	 * TestAdd setUp
	 */
	@Before
	public void setUp(){
		emptyStack = new StackAdapter();
		
		oneStack = new StackAdapter();
		oneStack.push("asso");
		
		threeStack = new StackAdapter();
		threeStack.push("jack");
		threeStack.push("queen");
		threeStack.push("king");
	}

	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.add method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the add() method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the add method appends the specified element to the end of this StackAdapter. 
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * threeStack contains 3 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * The StackAdapter increases its size by one after the call to add() method.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The StackAdapter has increased its size due to the add() method, no exception is thrown.
	 */
	@Test
	public void testAdd() {
		assertTrue(emptyStack.isEmpty());
		assertEquals(1, oneStack.size());
		emptyStack.add("nothing");
		assertEquals(emptyStack.size(), oneStack.size());
		assertEquals("nothing", emptyStack.get(emptyStack.size()-1));
		assertFalse(emptyStack.isEmpty());
		assertEquals("nothing", emptyStack.remove(0));
		assertTrue(emptyStack.isEmpty());
		emptyStack.add("air");
		assertEquals(oneStack.size(), emptyStack.size());
		assertEquals(3, threeStack.size());
		threeStack.clear();
		for(int i = 0; i < 10; i++) {
			threeStack.add(i);
			assertEquals(threeStack.size(), i+1);
		}
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.add method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the add(int, Object) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the add method inserts the specified element at the specified position in this StackAdapter. 
	 * Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * threeStack contains 3 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * threeStack contains only one element.
	 * The StackAdapter increases its size by one after the call to add() method.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * Regardless its previous size, the StackAdapter has increased its size by one after the add() method is called, no exception is thrown.
	 */
	@Test
	public void testAddParam() {
		threeStack.clear();
		threeStack.add(0, "asso");
		assertArrayEquals(oneStack.toArray(), threeStack.toArray());
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.add method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the add(int, Object) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the add method inserts the specified element at the specified position in this StackAdapter. 
	 * Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
	 * In particular if the index is out of range {@code(index < 0)}.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * 
	 * <h4>Post-Condition</h4>
	 * emptyStack contains no elements.
	 * The add(int, Object) method fails and the StackAdapter hasn't changed its size.
	 * IndexOutOfBoundsException is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The add(int, Object) method fails and the StackAdapter hasn't changed its size, IndexOutOfBoundsException is thrown..
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public void testAddIndexOutOfBoundsException1() {
		emptyStack.add(-1, oneStack);
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.add method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the add(int, Object) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the add method inserts the specified element at the specified position in this StackAdapter. 
	 * Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
	 * In particular if the index is out of range {@code(index > size())}.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * 
	 * <h4>Post-Condition</h4>
	 * emptyStack contains no elements.
	 * The add(int, Object) method fails and the StackAdapter hasn't changed its size.
	 * IndexOutOfBoundsException is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The add(int, Object) method fails and the StackAdapter hasn't changed its size, IndexOutOfBoundsException is thrown..
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public void testAddIndexOutOfBoundsException2() {
		emptyStack.add(100, oneStack);
	}
	
}
