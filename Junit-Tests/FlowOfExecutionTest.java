import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FlowOfExecutionTest {

	@Test
	@DisplayName("Test overloaded method dobuleMe() for accurate string value.") 
    public void testDoubleMeString() {
		
		String expected = "test test";
		String actual = MyMethods.doubleMe("test");   // Given & When because public static void
		
		assertEquals(expected, actual);
		
		
	}
	
    @Test
    @DisplayName("Test overloaded method doubleMe() for accurate long value.")
    public void testDoubleMeLong() {
    	
    	long expected = 20000000L;
    	long actual   = MyMethods.doubleMe(10000000L);
    	
    	assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test overloaded method doubleMe() for accurate int value.")
    public void testDoubleMeInt() {
    	
    	int expected = 20;
    	int actual   = MyMethods.doubleMe(10);
    	
    	assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test overloaded method doubleMe() for accurate double value.")
    public void testDoubleMeDouble() {
    	
    	double expected = 5.0;
    	double actual   = MyMethods.doubleMe(2.5);
    	
    	assertEquals(expected, actual, 0.01);
    	
    }
    
    @Test
    @DisplayName("Test FlowOfExecution Class")
    public void testFlowOfExecutionClass() {
    	FlowOfExecution foeAM = new FlowOfExecution();      // This works because arbitraryMethod is not static
    	String actual = foeAM.arbitraryMethod("Sad Face");  // if it was, we wouldn't have to build the object
    	String expected = "What did you call me?  A Sad Face?";  // So eclipse would tell us we were doing it wrong.
    	
    	assertEquals(expected, actual);
    	
    }


}
