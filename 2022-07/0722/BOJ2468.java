import java.util.*;
import java.io.*;


public class BOJ2468 {
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] maps;
    static boolean[][] visited;
    static Queue<Node> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        maps = new int[N][N];
        int maxHeight = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maps[i][j], maxHeight);
            }
        }
        int cnt = Integer.MIN_VALUE;
        for (int i = 0; i < maxHeight + 1; i++) {
            visited = new boolean[N][N];
            int check = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k] && maps[j][k] > i) {
                        bfs(j,k,i);
                        check++;
                    } else {
                        continue;
                    }
                }
            }
            cnt = Math.max(check, cnt);
        }
        System.out.println(cnt);


    }

    private static void bfs(int start, int end, int height) {
        queue = new LinkedList<>();
        visited[start][end] = true;
        queue.add(new Node(start, end));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && maps[nx][ny]>height) {
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                }
            }
        }
    }
}
