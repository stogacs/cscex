package exercise;

import java.util.ArrayList;

public class TestRunner {

  ArrayList<String> functions = new ArrayList<String>();
  int passed = 0;
  Exercise exercise = new Exercise();

  public static void main(String args[]) { runTests(); }

  void runTests() {
    //-------
    ArrayList<String> namesInitial = new ArrayList();
    namesInitial.add("john");
    namesInitial.add("ADAM");
    namesInitial.add("Robert");
    ArrayList<String> namesFinal = new ArrayList();
    namesFinal.add("john");
    namesFinal.add("ADAM");
    namesFinal.add("Robert");

    if (exercise.capitalizeTheNames(namesInitial).equals(namesFinal)) {
      passed += 1;
    } else {
      functions.add("capitalizeTheNames");
    }
    //-------
    String initalAccumulate = "defgh" String finalAccumulate =
        "D-Ee-Fff-Gggg-Hhhhh" if (exercise.accumulate(initalAccumulate)
                                      .equals(finalAccumulate)) {
      passed += 1;
    }
    else {
      functions.add("accumulate");
    }
    //-------

    if (exercise.rightTriangle(140, 170, 220) == false &&
        exercise.rightTriangle(915, 1748, 1973) == true) {
      passed += 1;
    } else {
      functions.add("rightTriangle");
    }
    //-------
    if (exercise.isNarcissistic(472335975) == true &&
        exercise.isNarcissistic(42300981) == false) {
      passed += 1;
    } else {
      functions.add("isNarcissistic");
    }
    //-------
    if (exercise
            .stripUrlParams("https://edabit.com?a=1&b=2", new String[] {"c"})
            .equals("https://edabit.com?a=1&b=2") &&
        exercise.stripUrlParams("https://edabit.com?a=1&b=2", null)
            .equals("https://edabit.com?a=1&b=2")) {
      passed += 1;
    } else {
      functions.add("stripUrlParams");
    }

    System.out.println("You completed " + Integer.toString(passed) + " tasks.");
    if (passed != 5) {
      System.out.println("The following are not working:");
      for (String v : functions) {
        System.out.println("\t" + v);
      }

    } else {
      System.out.println("Congratulations!");
    }
  }
}
