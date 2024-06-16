package myTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myAdapter.StackAdapter;
import myAdapter.Vector;
/**
 * TestConstructors class
 */
public class TestConstructors {
	
	StackAdapter oneStack;
	Vector v;
	
	/**
	 * TestConstructors setUp
	 */
	@Before
	public void setUp(){
		oneStack = new StackAdapter();
		oneStack.push("assoPicche");
		
		v = new Vector();
		v.addElement("assoPicche");
	}

	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter Default Constructor
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the default constructor of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that is constructed an empty StackAdapter.
	 * 
	 * <h4>Pre-Condition</h4>
	 * None.
	 * 
	 * <h4>Post-Condition</h4>
	 * An empty StackAdapter is created, without throwing exceptions.
	 * 
	 * <h4>Expected Result</h4>
	 * An empty StackAdapter is created.
	 */
	@Test
	public void testDefaultConstructor() {
		StackAdapter stack = new StackAdapter();
		assertNotNull(stack);
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter Parameterized Constructor
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the parameterized constructor of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that is constructed a StackAdapter where the elements are those contained in the vector parameter.
	 * 
	 * <h4>Pre-Condition</h4>
	 * The vector passed to the constructor needs to be constructed properly.
	 * 
	 * <h4>Post-Condition</h4>
	 * A StackAdapter with the same elements of the vector is created, without throwing exceptions.
	 * 
	 * <h4>Expected Result</h4>
	 * A StackAdapter with the same elements of the vector is created.
	 */
	@Test
	public void testParameterizedConstructor() {
		StackAdapter stack = new StackAdapter(v, 0, Integer.MAX_VALUE);
		assertNotNull(stack);
		assertFalse(stack.isEmpty());
		assertEquals(oneStack, stack);
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter Copy Constructor
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the copy constructor of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that is constructed a StackAdapter containing the elements of the specified collection.
	 * The HCollection object passed as a parameter needs to be not null.
	 * 
	 * <h4>Pre-Condition</h4>
	 * The collection passed to the constructor needs to be constructed properly.
	 * 
	 * <h4>Post-Condition</h4>
	 * A StackAdapter containing the elements of the specified collection, without throwing exceptions.
	 * 
	 * <h4>Expected Result</h4>
	 * A StackAdapter containing the elements of the specified collection is created.
	 */
	@Test
	public void testCopyConstructor() {
		StackAdapter stack = new StackAdapter(oneStack);
		assertNotNull(stack);
		assertFalse(stack.isEmpty());
		assertEquals("stack non uguali", oneStack, stack);
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter Copy Constructor with NullPointerException
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the copy constructor of the StackAdapter, when it is passed as a parameter a non valid collection.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that a NullPointerException is thrown if a null HCollection is passe to the constructor.
	 * 
	 * <h4>Pre-Condition</h4>
	 * None.
	 * 
	 * <h4>Post-Condition</h4>
	 * No StackAdapter object is created, a NullPointerException is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * No StackAdapter object is created.
	 * A NullPointerException is thrown.
	 */
	@Test(expected=NullPointerException.class)
	public void testCopyConstructorNull() {
		StackAdapter nullStack = new StackAdapter(null);
	}

}
