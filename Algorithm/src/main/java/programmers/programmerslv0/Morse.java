package programmers.programmerslv0;

public class Morse {
  public static void main(String[] args) {

    String letter = ".... . .-.. .-.. ---";
    System.out.println(solution(letter));
  }


    public static String solution(String letter) {
      StringBuilder answer = new StringBuilder();
      // 모스부호 해석표
      String morse = "'.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e','..-.':'f','--.':'g','....':'h','..':'i','.---':'j','-.-':'k','.-..':'l','--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r','...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x','-.--':'y','--..':'z'";

      // 모스부호 ','로 parsing => [  '.-':'a'  ]
      String[] data = morse.split(",");

      // data 문자열배열의 모든 원소에 대해 "'" 제거 => [  .-:a  ]
      for (int i = 0; i < data.length; i++) {
        data[i] = data[i].replaceAll("'","");
      }

      // data 배열 크기의 두배 사이즈의 twiceData 배열 생성
      String[] twiceData = new String[data.length*2];

      // Data 배열의 모든 원소에 대해 ":"로 parsing => [  .-  ], [  a  ]
      for (int i = 0; i < data.length; i++) {
        twiceData[i*2] = data[i].split(":")[0];
        twiceData[i * 2 + 1] = data[i].split(":")[1];
      }

      // twiceData 배열크기의 절반 크기의 두 배열을 각각 생성
      String[] parsedmorse = new String[twiceData.length/2]; // 모스부호
      String[] chara = new String[twiceData.length/2]; // 알파벳

      //
      for (int i = 0; i < chara.length; i++) {
        parsedmorse[i] = twiceData[2*i];
        chara[i] = twiceData[2*i+1];
      }

      String[] parsedletter = letter.split(" ");

      for (String s : parsedletter) {
        for (int j = 0; j < parsedmorse.length; j++) {
          if (s.equals(parsedmorse[j])) {
            answer.append(chara[j]);
            break;
          }
        }

      }

      return answer.toString();
    }





}
