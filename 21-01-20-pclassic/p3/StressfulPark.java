import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StressfulPark {

  public static void main(String[] args) throws FileNotFoundException {

    Scanner fileInput = new Scanner(new File("StressfulParkIN.txt"));

    while (fileInput.hasNext()) {

      String inputStr = fileInput.nextLine().trim();
      String[] inputStrArr = inputStr.split(" ");
      int N = Integer.parseInt(inputStrArr[0]);
      int M = Integer.parseInt(inputStrArr[1]);

      int[][] parkGrid = new int[N][M];

      for (int i = 0; i < N; i++) {
        String[] nextRow = fileInput.nextLine().trim().split(" ");

        for (int j = 0; j < M; j++) {
          parkGrid[i][j] = Integer.parseInt(nextRow[j]);
        }
      }

      System.out.println(shortestTimeToExit(parkGrid));

    }
    fileInput.close();

  }

  public static int shortestTimeToExit(int[][] parkGrid) {
    // Your implementation here!
    return 0;
  }

}
