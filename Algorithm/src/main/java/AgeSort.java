import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class AgeSort {

  public static void main(String[] args) throws Exception {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder out = new StringBuilder();

    int N = Integer.parseInt(in.readLine());
    Person[] humans = new Person[N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(in.readLine());
      humans[i].age = Integer.parseInt(st.nextToken());
      humans[i].name = st.nextToken();
    }

    Arrays.sort(humans, new Comparator<Person>() {
      @Override
      public int compare(Person o1, Person o2) {
        if (o1.age == o2.age) {
          return o1.name.compareTo(o2.name);
        } else {
          return o1.age - o2.age;
        }
      }
    });

    for (Person human : humans) {
      out.append(human.age).append(" ").append(human.name).append('\n');
    }

    System.out.println(out);

  }

  class Person {
    int age;
    String name;
  }

}