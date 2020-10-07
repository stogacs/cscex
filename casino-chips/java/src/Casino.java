import java.util.Arrays;

public class Casino {

  public static void main(String[] args) {
    assert Casino.solve(new int[] {1, 1, 1}) == 1;
    assert Casino.solve(new int[] {1, 2, 1}) == 2;
    assert Casino.solve(new int[] {8, 2, 8}) == 9;
    assert Casino.solve(new int[] {8, 1, 4}) == 5;
    assert Casino.solve(new int[] {7, 4, 10}) == 10;
    assert Casino.solve(new int[] {12, 12, 12}) == 18;
    assert Casino.solve(new int[] {1, 23, 2}) == 3;
  }

  public static int solve(int[] a) {
    int count = 0;

    while (a[0] != 0 && a[1] != 0 && a[2] != 0) {
      Arrays.sort(a);
      a[1]--;
      a[2]--;
      count++;
    }

    return count;
  }
}
