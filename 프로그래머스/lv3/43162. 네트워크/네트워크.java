class Solution {
    static boolean[] visited;
    static int count;
    
    public int solution(int n, int[][] computers) {
        count = 0;
        visited = new boolean[n];
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                dfs(i, computers);
                count++;
            }
        }

        return count;
    }
    
    public static void dfs(int index, int[][] computers) {
        visited[index] = true;

        for (int j = 0; j < computers.length; j++) {
            if (index != j && !visited[j] && computers[index][j] == 1) {
                dfs(j, computers);
            }
        }
    }
}