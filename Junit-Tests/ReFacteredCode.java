import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.*;


class ReFacteredCode {
	
	public static PrintStream reWireOutput(ByteArrayOutputStream byteArrayOSOut) {
		PrintStream ps = new PrintStream(byteArrayOSOut);
		PrintStream old = System.out;    // don't lose System.out, save it.  
		System.setOut(ps);
		return old;
	}
	
	public static InputStream reWireInput(String a) {
		ByteArrayInputStream byteArrayOSIn = new ByteArrayInputStream(a.getBytes());
		InputStream oldIn = System.in;  // Save Old stream
		System.setIn(byteArrayOSIn); 
		return oldIn;
	}
	
	public static void restoreSystemInAndSystemOut(PrintStream old, InputStream oldIn) {
	    System.out.flush();     // Clean things up, flush it
	    System.setOut(old);     // put System.out back
	    System.setIn(oldIn); 
	}



    @Test
    @DisplayName("Unhook stIn and stOut and replace with our own ByteArrayI/O streams")
    public void rearangeStreams() {
    	// Output stream!! 
      // use your stream instead of System Out.
    	ByteArrayOutputStream byteArrayOSOut = new ByteArrayOutputStream();
      // Pass in the byte array for rewiring, it will return the previous system out
      // So we can pass it to restoreSystemInAndSystemOut durring cleanup.
		  PrintStream previousSystemOut = reWireOutput(byteArrayOSOut);
	    
	    // Input stream!  Set it up, feed our input to it, save the old one, fed ours to System.setIn
	    String testString = "Hello You!";     // Gets fed to the input stream below
      InputStream previousSystemIn = reWireInput(testString);
 
      // Call the main method, there should be input ready for it.
      ScannerTest.main(null);    // call our class ScannerTest.main
      String expected = "You said " + testString + "\n";  // expected output
        
      // clean up and get our values
      restoreSystemInAndSystemOut(previousSystemOut, previousSystemIn);
	    String actual = byteArrayOSOut.toString();  // Get our output from ScannerTest back and stick it in actual
       
	    assertEquals(expected, actual);
    }
}


