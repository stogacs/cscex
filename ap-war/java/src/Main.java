public class Main {
  // Implement this method!
  public static String underVsUpper(String under, String upper) {
    // Replace this with your implementation...
    throw new UnsupportedOperationException("Not yet implemented!");
  }



  // Below are tests...
  public static void main(String[] args) {
    Tester tester = new Tester();
    tester.test();
  }

  static class Tester {

    private boolean noErrors = true;

    // See test cases:
    private void testUnderWins() {
      runTest("under1", "1 0 1 0 0", "0 1 0 0 0", UNDER_VICTORY);
      runTest("under2", "0 0 0 0 10", "0 0 0 0 0", UNDER_VICTORY);
    }

    private void testUpperWins() {
      runTest("upper1", "0 1 0 0 1", "0 0 0 1 1", UPPER_VICTORY);
      runTest("upper2" , "0 0 0 0 0", "0 0 0 0 10", UPPER_VICTORY);
    }

    private void testTie() {
      runTest("tie1", "0 0 1 0 1", "1 0 1 1 0", TIE);
      runTest("tie2", "2 0 4 0 5", "6 2 2 0 3", TIE);
      runTest("tie3", "0 0 0 0 10", "0 0 0 0 10", TIE);
    }


    private static final String UNDER_VICTORY = "Underclassmen are victorious";
    private static final String UPPER_VICTORY = "Upperclassmen are victorious";
    private static final String TIE = "No victor on this battlefield";

    public void test() {
      System.out.println("Running tests...");

      testUnderWins();
      testUpperWins();
      testTie();

      System.out.println("Finished running tests!");
      if (this.noErrors) {
        System.out.println("All tests passed!");
      } else {
        System.out.println("Some tests failed.");
      }
    }

    private void runTest(String id, String under, String upper, String answer) {
      try {
        String result = Main.underVsUpper(under, upper);
        if (!result.equals(answer)) {
          printTestError(id, "Assertion failed: " + result + " != " + answer);
        }
      } catch (Exception e) {
        printTestError(id, "Exception caught: " + e);
      }
    }

    private void printTestError(String id, String message) {
      if (this.noErrors) {
        System.err.println();
        this.noErrors = false;
      }
      System.err.println("Test '" + id + "'\n... " + message + "\n");
    }
  }
}
