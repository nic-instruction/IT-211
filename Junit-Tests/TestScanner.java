import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.*;


class TestScanner {
    @Test
    @DisplayName("Unhook stIn and stOut and replace with our own ByteArrayI/O streams")
    public void rearangeStreams() {
    	// Output stream!! 
		ByteArrayOutputStream byteArrayOSOut = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOSOut);
		
		PrintStream old = System.out;    // don't lose System.out, save it.  
		System.setOut(ps);  // use your stream instead of System Out.
		    
	  // Input stream!  Set it up, feed our input to it, save the old one, fed ours to System.setIn
	  String testString = "Hello!";     // Gets fed to the input stream below
		ByteArrayInputStream byteArrayOSIn = new ByteArrayInputStream(testString.getBytes());  // set up new input stream
		
		InputStream oldIn = System.in;  // Save Old stream
		
		System.setIn(byteArrayOSIn);    // Set our input stream as the system input stream
		
    // actual code that isn't just setup!
    ScannerTest.main(null);    // call our class ScannerTest.main
    String expected = "You said " + testString + "\n";  // expected output
        
    // clean up and get our values
	  System.out.flush();     // Clean things up, flush it
	  System.setOut(old);     // put System.out back
	  System.setIn(oldIn);    // put System.in back
	  String actual = byteArrayOSOut.toString();  // Get our output from ScannerTest back and stick it in actual
    assertEquals(expected, actual);
    
    }
}


