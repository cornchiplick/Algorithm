class Solution {
public int solution(String[] babbling) {
    int answer = 0;
    String[] word = {"aya", "ye", "woo", "ma"};


    for (int i = 0; i < babbling.length; i++) {
      for (int j = 0; j < word.length; j++) {
        if (babbling[i].contains(word[j])) {
          babbling[i] = babbling[i].replaceAll(word[j], " ");
        }
      }
    }

    for (int i = 0; i < babbling.length; i++) {
      babbling[i] = babbling[i].replaceAll(" ", "");
      if (babbling[i].length() == 0) {
        answer++;
      }
    }

    return answer;
  }
}