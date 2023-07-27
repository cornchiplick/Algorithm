import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }

    public int bfs(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Queue<Integer> steps = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(begin);
        steps.offer(0);

        while (!queue.isEmpty()) {
            String currentWord = queue.poll();
            int step = steps.poll();

            if (currentWord.equals(target)) {
                return step;
            }

            for (String word : words) {
                if (!visited.contains(word) && isCorrect(currentWord, word)) {
                    queue.offer(word);
                    steps.offer(step + 1);
                    visited.add(word);
                }
            }
        }

        return 0;
    }

    public boolean isCorrect(String word, String target) {
        int diff = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != target.charAt(i)) {
                diff++;
            }
        }
        if (diff == 1) {
            return true;
        }
        return false;
    }
}