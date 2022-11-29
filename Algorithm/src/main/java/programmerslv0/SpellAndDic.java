package programmerslv0;

public class SpellAndDic {

  public static void main(String[] args) {
    String[] spell = {"p", "o", "s"};
    String[] dic = {"sod", "eocd", "qixm", "adio", "soo"};
    int result = 2;

    System.out.println(solution(spell, dic));

  }

  public static int solution(String[] spell, String[] dic) {
    int answer = 2;


    for(String dict : dic) {

      boolean isRight = true;

      for(String spel : spell) {
        if(dict.indexOf(spel) == -1) {
          isRight = false;
          break;
        }
      }

      if(isRight) {
        answer = 1;
        break;
      }
    }

    return answer;
  }
}
