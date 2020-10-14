public class Main {
  // Implement this method!
  public static String revrot(String s, int sz) {
    // Replace this with your implementation...
    throw new UnsupportedOperationException("Not yet implemented!");
  }

  // Below are tests...
  public static void main(String[] args) {
    Tester tester = new Tester();
    tester.test();
  }

  static class Tester {

    // See test cases:
    private void testExamples() {
      runTest("123456987654", 6, "234561876549");
      runTest("123456987653", 6, "234561356789");
      runTest("66443875", 4, "44668753");
      runTest("66443875", 8, "64438756");
      runTest("664438769", 8, "67834466");
      runTest("123456779", 8, "23456771");
      runTest("", 8, "");
      runTest("123456779", 0, "");
      runTest("563000655734469485", 4, "0365065073456944");
    }

    private boolean noErrors = true;

    public void test() {
      System.out.println("Running tests...");

      testExamples();

      System.out.println("Finished running tests!");
      if (this.noErrors) {
        System.out.println("All tests passed!");
      } else {
        System.out.println("Some tests failed.");
      }
    }

    private void runTest(String s, int sz, String answer) {
      try {
        String result = Main.revrot(s, sz);
        if (!result.equals(answer)) {
          printTestError(s, "Assertion failed: " + result + " != " + answer);
        }
      } catch (Exception e) {
        printTestError(s, "Exception caught: " + e);
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
