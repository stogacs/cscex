import java.util.*;
import java.io.*;


public class DotMatrixChecker {
	//DONT EVER TOUCH THESE SHITS - THIS WILL BE PROVIDED DURING COMPEITTION
    public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException
    {
        Scanner sc = new Scanner(new FileReader("DotMatrixCheckerIN.txt"));
        
        while (sc.hasNext()) {
            System.out.println(makeLogo(Integer.parseInt(sc.nextLine())));
        }
        
        
    }
    public static String makeLogo(int n)
    {
        String out = "";
        //write ur code here
               
        return out; 
    }
    //few extra notes - can use StringBuilder
}
