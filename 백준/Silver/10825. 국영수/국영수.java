import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    List<Record> list = new ArrayList<>();
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      list.add(new Record(st.nextToken(), Integer.parseInt(st.nextToken()),
              Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }

    Collections.sort(list);

    StringBuilder sb = new StringBuilder();
    for (Record element : list) {
      sb.append(element.name).append('\n');
    }
    
    System.out.println(sb);

  }

}

class Record implements Comparable<Record> {
  String name;
  int language;
  int english;
  int math;

  Record(String name, int language, int english, int math) {
    this.name = name;
    this.language = language;
    this.english = english;
    this.math = math;
  }

  @Override
  public int compareTo(Record o) {
    if (this.language == o.language) {
      if (this.english == o.english) {
        if (this.math == o.math) {
          return this.name.compareTo(o.name);
        } else {
          return o.math - this.math;
        }
      } else {
        return this.english - o.english;
      }
    } else {
      return o.language - this.language;
    }
  }
}
