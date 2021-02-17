class MyMethods{
    public static int doubleMe(int b) {
        return (b + b);
    }
        
    public static String doubleMe(String b) {
        return (b + " " + b); // Note, this will concatonate the strings together with a space between them.
    }
        
    public static double doubleMe(double b) {
        return (b + b);
    }
        
    public static long doubleMe(long b) {
        return (b + b);
    }
}

public class FlowOfExecution{
    public static void main(String [] args) {
        int intNum        = 5;
        String stringWord = "NOW";
        double doubleNum  = 10.404;

        System.out.println("Passing already declared variables to MyMethods.doubleMe()");
        System.out.println(MyMethods.doubleMe(intNum));
        System.out.println(MyMethods.doubleMe(stringWord));
        System.out.println(MyMethods.doubleMe(doubleNum) + "\n");
    }
    
    public String arbitraryMethod(String a) {
    	String returnValue = "What did you call me?  A " + a + "?";
    	return returnValue;
    }
}
