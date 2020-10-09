package lib;

public class Person {
  private int weight;
  private int dest;

  public Person(int weight, int dest) {
    this.weight = weight;
    this.dest = dest;
  }

  public int weight() {
    return this.weight;
  }

  public int dest() {
    return this.dest;
  }
}
