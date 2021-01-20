import java.io.FileReader;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.*;

public class TowerTycoon {
  public static void main(String[] args) throws IOException {
    HashMap<String, List<String>> vertexMap = new HashMap<>();
    Scanner sc = new Scanner(new FileReader("TowerTycoonIN.txt"));
    while (sc.hasNext()) {
      int numberOfLists = Integer.parseInt(sc.nextLine());
      for (int i = 0; i < numberOfLists; i++) {
        String line = sc.nextLine();
        String[] inhabitants = line.split(" ");
        for (int j = 0; j < inhabitants.length - 1; j++) {
          if (vertexMap.containsKey(inhabitants[j])) {
            List<String> keyList = vertexMap.get(inhabitants[j]);
            keyList.add(inhabitants[j + 1]);
            vertexMap.put(inhabitants[j], keyList);
          } else {
            List<String> list = new LinkedList<String>();
            list.add(inhabitants[j + 1]);
            vertexMap.put(inhabitants[j], list);
          }
        }
      }
      tower(vertexMap);
      vertexMap = new HashMap<String, List<String>>();
    }
    sc.close();

  }

  static void tower(Map<String, List<String>> map) {
    // Your implementation here!
  }
}
