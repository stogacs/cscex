import lib.Runner;

public class Main {

  public static void main(String[] args) {
    Control control = new Control();
    Runner runner = new Runner();
    int n = runner.run(control);

    System.out.println("Took " + n + " moves");
  }

}
