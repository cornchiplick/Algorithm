package curriculum.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Guess_1248_Fail {
  public static int[] arr;

  public static void main(String[] args) throws IOException {
    // 입력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String sign = br.readLine();

    // matrix S 만들기
    String[][] matrix = parsedSign(n, sign);

    // 초기값 세팅
    arr = new int[n];
    initialize(arr, matrix);
    int depth = 0;

    // 옳은 수열 찾기
    findSequence(depth, arr, matrix);

    // 출력
    StringBuilder sb = new StringBuilder();
    for (int e : arr) {
      sb.append(e).append(" ");
    }
    System.out.println(sb);

  }

  private static void findSequence(int depth, int[] arr, String[][] matrix) {
    int[] inspected = arr.clone();
    // 종료조건
    // depth가 n이상이 되면.
    if (depth >= inspected.length) {
      return;
    }

    // depth번째 원소 변화시키며 대조해보기
    loop:
    for (int i = 0; i < 10; i++) {
      // matrix의 결과표와 대조
      if (inspect(matrix, inspected)) {
        // 맞으면 해당 array를 return
        Guess_1248_Fail.arr = inspected;
        return;

      } else {
        // 다했는데도 없으면 depth번째 원소를 조건에 맞게 증감시키기(재귀)
        switch (matrix[depth][depth]) {
          case "+": {
            inspected[depth]++;
            // depth번째 원소를 변화시켜서는 답이 없다. 그 다음 원소로 다시 간다.
            findSequence(depth + 1, inspected, matrix);
            break;
          }
          case "-": {
            inspected[depth]--;
            // depth번째 원소를 변화시켜서는 답이 없다. 그 다음 원소로 다시 간다.
            findSequence(depth + 1, inspected, matrix);
            break;
          }
          default: {
            // depth번째 원소를 변화시켜서는 답이 없다. 그 다음 원소로 다시 간다.
            findSequence(depth + 1, inspected, matrix);
            break loop;
          }
        }
      }

    }

  }

  private static boolean inspect(String[][] matrix, int[] inspected) {
    // arr의 원소가 옳은지 검사
    for (int e : inspected) {
      if (e < -10 || e > 10) {
        return false;
      }
    }

    // matrix의 결과표와 대조
    for (int i = 0; i < inspected.length; i++) {
      for (int j = i; j < inspected.length; j++) {
        if (!elementSum(inspected[i], inspected[j]).equals(matrix[i][j])) {
          return false;
        }
      }
    }
    return true;
  }

  private static String elementSum(int i, int j) {
    if (i + j > 0) {
      return "+";
    } else if (i + j < 0) {
      return "-";
    } else {
      return "0";
    }

  }

  private static void initialize(int[] arr, String[][] matrix) {
    for (int i = 0; i < arr.length; i++) {
      switch (matrix[i][i]) {
        case "+":
          arr[i] = 1;
          break;
        case "-":
          arr[i] = -1;
          break;
        default:
          arr[i] = 0;
          break;
      }
    }

  }

  private static String[][] parsedSign(int n, String sign) {
    String[][] matrix = new String[n][n];

    char[] signs = sign.toCharArray();
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        matrix[i][j] = String.valueOf(signs[count++]);
      }
    }
    return matrix;
  }


}

