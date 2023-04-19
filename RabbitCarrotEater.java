import java.util.*;

public class RabbitCarrotEater {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the square garden matrix:");
        int size = scanner.nextInt();
        int[][] garden = new int[size][size];
        System.out.println("Enter the garden matrix- '1' for carrots and '0' for no carrots");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                garden[i][j] = scanner.nextInt();
            }
        }
        int jumps = countCarrotJumps(garden);
        System.out.println("Jumps:" + jumps);
    }

    public static int countCarrotJumps(int[][] garden) {
        int jumps = 0;
        boolean[][] visited = new boolean[garden.length][garden[0].length];
        for (int i = 0; i < garden.length; i++) {
            for (int j = 0; j < garden[0].length; j++) {
                if (!visited[i][j] && garden[i][j] == 1) {
                    jumps++;
                    dfs(garden, i, j, visited);
                }
            }
        }
        return jumps;
    }

    public static void dfs(int[][] garden, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= garden.length || j >= garden[0].length || visited[i][j] || garden[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        dfs(garden, i - 1, j, visited); // up
        dfs(garden, i + 1, j, visited); // down
        dfs(garden, i, j - 1, visited); // left
        dfs(garden, i, j + 1, visited); // right
    }
}