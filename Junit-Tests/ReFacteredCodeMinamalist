import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.*;


class ReFacteredCodeMinamalist {
	
	public static PrintStream reWireOutput(ByteArrayOutputStream byteArrayOSOut) {
		PrintStream ps = new PrintStream(byteArrayOSOut);
		PrintStream old = System.out; 
		System.setOut(ps);
		return old;
	}
	
	public static InputStream reWireInput(String a) {
		ByteArrayInputStream byteArrayOSIn = new ByteArrayInputStream(a.getBytes());
		InputStream oldIn = System.in;
		System.setIn(byteArrayOSIn); 
		return oldIn;
	}
	
	public static void restoreSystemInAndSystemOut(PrintStream old, InputStream oldIn) {
	    System.out.flush();    
	    System.setOut(old);    
	    System.setIn(oldIn); 
	}

    @Test
    @DisplayName("Unhook stIn and stOut and replace with our own ByteArrayI/O streams")
    public void rearangeStreams() {

    	ByteArrayOutputStream byteArrayOSOut = new ByteArrayOutputStream();
		  PrintStream previousSystemOut = reWireOutput(byteArrayOSOut);
	    
	    String testString = "Hello You!";
      
      InputStream previousSystemIn = reWireInput(testString);
 
      ScannerTest.main(null);  // The Class.main method we're testing.

      restoreSystemInAndSystemOut(previousSystemOut, previousSystemIn);
      
      String expected = "You said " + testString + "\n";  // expected output
	    String actual = byteArrayOSOut.toString();  // Get our output from ScannerTest back and stick it in actual
       
	    assertEquals(expected, actual);
    }
}


