import java.io.*;
import java.util.*;

public class Perfect {
  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(new FileReader("PerfectIN.txt"));
    while (sc.hasNext()) {
      System.out.println(isPerfect(sc.nextInt()));
    }

  }

  public static boolean isPerfect(int n) {
    // Your implementation here!
  }
}
