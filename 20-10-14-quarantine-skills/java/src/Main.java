public class Main {

  public static String getSkillLevels(String artReq, String eplReq, String toSpend) {
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
        runTest("1 4", "3 8", "7 24", "4 1");
        runTest("11 13", "5 17", "102 176", "7 5");
        runTest("1 5", "2 10", "5 4", "-1 -1");
        runTest("0 1", "1 0", "5 12", "12 5");
        runTest("1 1", "0 1", "3 4", "3 1");
        runTest("0 0", "0 0", "0 0", "-1 -1");
        runTest("1001 101", "130 1195", "3393 3888", "3 3");
        runTest("203 407", "805 212", "3031 3273", "7 2");
        runTest("1 2", "3 7", "896 1920", "512 128");
        runTest("100 99", "10 9", "0 9", "-1 -1");
        runTest("12 2", "4872 2910", "0 0", "0 0");
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

    private void runTest(String artReq, String eplReq, String toSpend, String answer) {
      String id = artReq + " : " + eplReq + " : " + toSpend;
      try {
        String result = Main.getSkillLevels(artReq, eplReq, toSpend);
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
