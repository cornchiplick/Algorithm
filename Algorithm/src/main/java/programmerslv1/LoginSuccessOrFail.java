package programmerslv1;

public class LoginSuccessOrFail {

  public static void main(String[] args) {
    String[] id_pw = {"meosseugi", "1234"};
    String[][] db = {{"rardss", "123"}, {"yyoom", "1234"}, {"meosseugi", "1234"}};
    String result = "login";
    System.out.println(solution(id_pw, db));

  }

  public static String solution(String[] id_pw, String[][] db) {
    String answer = "";

    for (int i = 0; i < db.length; i++) {
      if (db[i][0].equals(id_pw[0])) {
        if (db[i][1].equals(id_pw[1])) {
          return "login";
        } else {
          return "wrong pw";
        }
      }
    }

    return "fail";
  }
}
