import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayDiff {

    public static int[] arrayDiff(int[] a, int[] b) {
        Set<Integer> bSet = IntStream.of(b).boxed().collect(Collectors.toSet());
        return IntStream.of(a).filter(x -> !bSet.contains(x)).toArray();
        // throw new UnsupportedOperationException("Not implemented!");
    }


    /**
     * HERE BE TESTS
     */

    // I now see new int[] in my sleep.
    private static void testEmpty() {
        testCases(
                new Case(new int[0], new int[0], new int[0]),
                new Case(new int[]{5}, new int[0], new int[]{5}),
                new Case(new int[]{3, 4}, new int[0], new int[]{3, 4}),
                new Case(new int[0], new int[]{2}, new int[0])
        );
    }

    private static void testSingle() {
        testCases(
                new Case(new int[]{1, 2}, new int[]{1}, new int[]{2}),
                new Case(new int[]{2, 3}, new int[]{0}, new int[]{2, 3}),
                new Case(new int[]{6, 4}, new int[]{5}, new int[]{6, 4}),
                new Case(new int[]{0, 1}, new int[]{1, 3}, new int[]{0})
        );
    }

    private static void testMultiple() {
        testCases(
                new Case(new int[]{1, 2, 3, 3}, new int[]{2}, new int[]{1, 3, 3}),
                new Case(new int[]{3, 3, 5, 2}, new int[]{2}, new int[]{3, 3, 5}),
                new Case(new int[]{2, 4, 6, 2, 5}, new int[]{2}, new int[]{4, 6, 5})
        );
    }

    private static class Case {
        public int[] a, b, expected;

        public Case(int[] a, int[] b, int[] expected) {
            this.a = a;
            this.b = b;
            this.expected = expected;
        }
    }

    private static void test() {
        testEmpty();
        testSingle();
        testMultiple();
    }

    private static void testCases(Case... cases) {
        for (Case c : cases) {
            testCase(c.a, c.b, c.expected);
        }
    }

    private static void testCase(int[] a, int[] b, int[] expected) {
        int[] result = arrayDiff(a, b);
        if (!Arrays.equals(result, expected)) {
            System.out.println("Failed: " + Arrays.toString(result) + " != " + Arrays.toString(expected));
        }
    }

    public static void main(String[] args) {
        ArrayDiff.test();
    }
}