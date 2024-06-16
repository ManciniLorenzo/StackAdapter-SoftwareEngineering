package myTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myAdapter.StackAdapter;
/**
 * TestToArray class
 */
public class TestToArray {

	StackAdapter emptyStack;
	StackAdapter oneStack;
	StackAdapter longStack;
	
	/**
	 * TestToArray setUp
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
	 * Test StackAdapter.toArray method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the toArray() method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the toArray method returns an array containing all of the elements in this StackAdapter in proper sequence. 
	 * Obeys the general contract of the hCollection.toArray method.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * An array is returned from the method toArray.
	 * The StackAdapter hasn't changed due to the creation of the array.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The StackAdapter hasn't been modified by the toArray() method, no exception is thrown.
	 */
	@Test
	public void testToArray() {
		Object[] emptyArray = {};
		assertArrayEquals(emptyArray, emptyStack.toArray());
		
		Object[] longArray = new Object[100];
		for(int i = 0; i < 100; i++) {
			longArray[i] = i;
		}
		assertArrayEquals(longArray, longStack.toArray());
		
		StackAdapter stackList = new StackAdapter();
		stackList.add(emptyStack);
		stackList.add(oneStack);
		stackList.add(longStack);
		Object[] stackListArray = {emptyStack, oneStack, longStack};
		assertArrayEquals(stackList.toArray(), stackListArray);
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.toArray method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the toArray(Object[]) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the toArray method returns an array containing all of the elements in this StackAdapter in proper sequence. 
	 * The runtime type of the returned array is that of the specified array.
	 * Obeys the general contract of the hCollection.toArray(Object[]) method.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * An array is returned from the method toArray.
	 * The StackAdapter hasn't changed due to the creation of the array.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The StackAdapter hasn't been modified by the toArray(Object[]) method, no exception is thrown.
	 */
	@Test
	public void testToArrayParam() {
		String[] array1 = {"jolly", "due", "tre", "quattro"};
		String[] array2 = {"asso", null, "tre", "quattro"};
		Object[] testArray = oneStack.toArray(array1);
		assertArrayEquals(testArray, array2);
		
		String[] stringArray = {"asso"};
		Object[] stackToArray = oneStack.toArray(new String[1]);
		assertArrayEquals(stringArray, stackToArray);
		
		StackAdapter stackList = new StackAdapter();
		stackList.add(emptyStack);
		stackList.add(oneStack);
		stackList.add(longStack);
		Object[] stackListArray = {emptyStack, oneStack, longStack};
		assertArrayEquals(stackList.toArray(new Object[3]), stackListArray);
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.toArray method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the toArray(Object[]) method of the StackAdapter.
	 * In particular when the specified array passed as parameter is null.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the toArray method returns an array containing all of the elements in this StackAdapter in proper sequence. 
	 * The runtime type of the returned array is that of the specified array.
	 * Obeys the general contract of the hCollection.toArray(Object[]) method.
	 * 
	 * <h4>Pre-Condition</h4>
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * The StackAdapter hasn't changed, no array is created.
	 * NullPointerException is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The StackAdapter hasn't been modified by the toArray(Object[]) method, NullPointerException exception is thrown.
	 */
	@Test(expected=NullPointerException.class)
	public void testToArrayNullPointerException() {
		longStack.toArray(null);
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.toArray method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the toArray(Object[]) method of the StackAdapter.
	 * In particular when the length of the specified array is not enough to contain all the elements.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the toArray method returns an array containing all of the elements in this StackAdapter in proper sequence. 
	 * The runtime type of the returned array is that of the specified array.
	 * Obeys the general contract of the hCollection.toArray(Object[]) method.
	 * 
	 * <h4>Pre-Condition</h4>
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * The StackAdapter hasn't changed, no array is created.
	 * IllegalArgumentException is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The StackAdapter hasn't been modified by the toArray(Object[]) method, IllegalArgumentException exception is thrown.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testToArrayIllegalArgumentException() {
		longStack.toArray(new Object[1]);
	}

}
