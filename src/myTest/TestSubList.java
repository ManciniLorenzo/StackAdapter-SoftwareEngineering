package myTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myAdapter.*;
/**
 * TestSubList class
 */
public class TestSubList {

	StackAdapter emptyStack;
	StackAdapter oneStack;
	StackAdapter longStack;
	
	/**
	 * TestSubList setUp
	 */
	@Before
	public void setUp(){
		emptyStack = new StackAdapter();
		
		oneStack = new StackAdapter();
		oneStack.push(0);
		
		longStack = new StackAdapter();
		for(int i = 0; i < 100; i++) {
			longStack.push(i);
		}
	}

	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.subList method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the subList(int, int) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the subList method Returns a view of the portion of this StackAdapter between the specified fromIndex, inclusive, and toIndex, exclusive. 
	 * (If fromIndex and toIndex are equal, the returned StackAdapter is empty.) 
	 * The returned StackAdapter is backed by this StackAdapter, so non-structural changes in the returned StackAdapter are reflected in this StackAdapter, and vice-versa. 
	 * The returned StackAdapter supports all of the optional list operations supported by this StackAdapter.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * After the call to subList() method this StackAdapter hasn't changed, a new StackAdapter is created.
	 * This new StackAdapter contain all the elements between the specified indexes passed as parameters to the method.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * After the call to subList() method this StackAdapter hasn't changed, a new StackAdapter is returned.
	 * No exception is thrown.
	 */
	@Test
	public void testSubList() {
		assertEquals(oneStack, longStack.subList(0, 1));
		assertEquals(emptyStack, longStack.subList(0, 0));
		
		StackAdapter player1 = longStack.subList(0, 5);
		StackAdapter player2 = longStack.subList(0, 5);
		assertEquals(player1.get(0), player2.get(0));
		player1.set(0, "game");
		assertEquals("game", player2.get(0));
		longStack.set(0, "tryagain");
		assertEquals("tryagain", player1.get(0));
		assertEquals("tryagain", player2.get(0));
		longStack.clear();
		assertTrue(longStack.isEmpty());
		assertFalse(player1.isEmpty());
		assertFalse(player2.isEmpty());

	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.subList method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the subList(int, int) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the subList method Returns a view of the portion of this StackAdapter between the specified fromIndex, inclusive, and toIndex, exclusive. 
	 * (If fromIndex and toIndex are equal, the returned StackAdapter is empty.) 
	 * The returned StackAdapter is backed by this StackAdapter, so non-structural changes in the returned StackAdapter are reflected in this StackAdapter, and vice-versa. 
	 * The returned StackAdapter supports all of the optional list operations supported by this StackAdapter.
	 * In particular for an illegal endpoint index value {@code(fromIndex < 0)}.
	 * 
	 * <h4>Pre-Condition</h4>
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * The call to subList() method fails. This StackAdapter hasn't changed and no StackAdapter is created.
	 * IndexOutOfBoundsException is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The call to subList() method fails. This StackAdapter hasn't changed and no StackAdapter is created.
	 * IndexOutOfBoundsException is thrown.
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public void testSubListIndexOutOfBoundsException1() {
		longStack.subList(-1, longStack.size()-1);
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.subList method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the subList(int, int) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the subList method Returns a view of the portion of this StackAdapter between the specified fromIndex, inclusive, and toIndex, exclusive. 
	 * (If fromIndex and toIndex are equal, the returned StackAdapter is empty.) 
	 * The returned StackAdapter is backed by this StackAdapter, so non-structural changes in the returned StackAdapter are reflected in this StackAdapter, and vice-versa. 
	 * The returned StackAdapter supports all of the optional list operations supported by this StackAdapter.
	 * In particular for an illegal endpoint index value {@code(toIndex > size)}.
	 * 
	 * <h4>Pre-Condition</h4>
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * The call to subList() method fails. This StackAdapter hasn't changed and no StackAdapter is created.
	 * IndexOutOfBoundsException is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The call to subList() method fails. This StackAdapter hasn't changed and no StackAdapter is created.
	 * IndexOutOfBoundsException is thrown.
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public void testSubListIndexOutOfBoundsException2() {
		longStack.subList(0, longStack.size() + 1);
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.subList method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the subList(int, int) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the subList method Returns a view of the portion of this StackAdapter between the specified fromIndex, inclusive, and toIndex, exclusive. 
	 * (If fromIndex and toIndex are equal, the returned StackAdapter is empty.) 
	 * The returned StackAdapter is backed by this StackAdapter, so non-structural changes in the returned StackAdapter are reflected in this StackAdapter, and vice-versa. 
	 * The returned StackAdapter supports all of the optional list operations supported by this StackAdapter.
	 * In particular for an illegal endpoint index value {@code(fromIndex > toIndex)}.
	 * 
	 * <h4>Pre-Condition</h4>
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * The call to subList() method fails. This StackAdapter hasn't changed and no StackAdapter is created.
	 * IndexOutOfBoundsException is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The call to subList() method fails. This StackAdapter hasn't changed and no StackAdapter is created.
	 * IndexOutOfBoundsException is thrown.
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public void testSubListIndexOutOfBoundsException3() {
		longStack.subList(100, 0);
	}

}
