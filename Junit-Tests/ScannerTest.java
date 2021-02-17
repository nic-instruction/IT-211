import java.util.Scanner;

public class ScannerTest {
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		System.out.println("You said " + input);
	    in.close();
	    return;
	
	}
	

}
