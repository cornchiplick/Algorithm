import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder out = new StringBuilder();

    int N = Integer.parseInt(in.readLine());
    Person[] humans = new Person[N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(in.readLine());
      humans[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken(), i);
    }

    in.close();

    // ---

    Arrays.sort(humans, ((o1, o2) -> {
      if (o1.age == o2.age) {
        return o1.no - o2.no;
      } else {
        return o1.age - o2.age;
      }
    }));

    // ---

//    Arrays.sort(humans, new Comparator<Person>() {
//      @Override
//      public int compare(Person o1, Person o2) {
//        if (o1.age == o2.age) {
//          return o1.no - o2.no;
//        } else {
//          return o1.age - o2.age;
//        }
//      }
//    });

    for (Person human : humans) {
      out.append(human.age).append(" ").append(human.name).append('\n');
    }

    System.out.println(out);

  }

  static class Person {
    int age;
    String name;
    int no;

    Person(int age, String name, int no) {
      this.age = age;
      this.name = name;
      this.no = no;
    }
  }

}