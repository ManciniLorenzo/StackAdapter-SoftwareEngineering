package myTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import myAdapter.*;

/**
 * Test suite for the {@link myAdapter.StackAdapter} class.
 * 
 * <h2>Summary</h2>
 * This test suite verify the proper functioning of the StackAdapter methods.
 * 
 * <h2>Test Suite Design</h2>
 * In this class, is tested every method of StackAdapter and every exception thrown by them.
 * The tests are divided by the name of every methods, and grouped together if similar methods differ from the others only by
 * the number or type of parameters.
 * <br>
 * In every test, the main purpose of the method is tested first, and after the exception-thrown cases, trying to cover all the cases possible, accordingly to the J2SE 1.4.2 version.
 * Different test cases check different situations where the method object of the test might fail.
 * Many tests are made by using other StackAdapter methods and exploiting the functionalities of the class itself.
 * All the initial fixtures are made in setUp() inside each test case.
 * 
 * <h2>Pre-Condition</h2>
 * The StackAdapter class implements the {@link HList} and {@link HCollection} interfaces. 
 * This means that all the methods declared inside the two interfaces needs to be fully defined inside the class.
 * The same applies to the StackIterator class which implements {@link HListIterator} and {@link HIterator}. 
 * The developed version is the J2SE 1.4.2
 * 
 * <h2>Post-Condition</h2>
 * The list of the failed tests out of the total is shown at the end of the execution.
 * If all the tests have been successfully completed then no list is created.
 * 
 * <h2>Test Cases</h2>
 * The 61 test cases are divided into the following classes:
 * <ul>
 * <li>{@link TestConstructors}</li>
 * <li>{@link TestPush}</li>
 * <li>{@link TestPop}</li>
 * <li>{@link TestPeek}</li>
 * <li>{@link TestEmpty}</li>
 * <li>{@link TestSearch}</li>
 * <li>{@link TestSize}</li>
 * <li>{@link TestIsEmpty}</li>
 * <li>{@link TestContains}</li>
 * <li>{@link TestIterator}</li>
 * <li>{@link TestToArray}</li>
 * <li>{@link TestAdd}</li>
 * <li>{@link TestRemove}</li>
 * <li>{@link TestContainsAll}</li>
 * <li>{@link TestAddAll}</li>
 * <li>{@link TestRemoveAll}</li>
 * <li>{@link TestRetainAll}</li>
 * <li>{@link TestClear}</li>
 * <li>{@link TestEquals}</li>
 * <li>{@link TestHashCode}</li>
 * <li>{@link TestGet}</li>
 * <li>{@link TestSet}</li>
 * <li>{@link TestIndexOf}</li>
 * <li>{@link TestLastIndexOf}</li>
 * <li>{@link TestListIterator}</li>
 * <li>{@link TestSubList}</li>
 * </ul>
 * 
 * <h2>Execution Variables</h2>
 * For each test case class, the necessary fixtures are initialized in the setUp method. 
 * Different StackAdapters are used to test different situations:
 * <ul>
 * <li>emptyStack: an empty StackAdapter</li>
 * <li>oneStack: a StackAdapter which contains only one element</li>
 * <li>threeStack: a StackAdapter which contains only three elements</li>
 * <li>longStack: a StackAdapter which contains 100 elements</li>
 * <li>stack: a general StackAdapter created for manipulations operations</li>
 * <li>fakeStack: a general StackAdapter created for manipulations operations</li>
 * </ul>
 * Only the necessary objects are created for each test case class.
 */
@RunWith(Suite.class)
@SuiteClasses({ TestConstructors.class, TestPush.class, TestPop.class, TestPeek.class, TestEmpty.class, TestSearch.class, TestSize.class, TestIsEmpty.class, 
	TestContains.class, TestIterator.class, TestToArray.class, TestAdd.class, TestRemove.class, TestContainsAll.class, TestAddAll.class, TestRemoveAll.class, 
	TestRetainAll.class, TestClear.class, TestEquals.class, TestHashCode.class, TestGet.class, TestSet.class, TestIndexOf.class, TestLastIndexOf.class, TestListIterator.class, 
	TestSubList.class, })

public class StackAdapterTestSuite {
}
