import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1303 {
    static class Node {
        int x, y;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] maps;
    static boolean[][] visited;
    static Queue<Node> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maps = new char[M][N];
        visited = new boolean[M][N];
        queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < N; j++) {
                maps[i][j] = s.toCharArray()[j];
            }
        }
        int whiteColor = 0;
        int blackColor = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // 방문하지 않은 곳부터 시작해야 한다. 거기서부터 bfs를 돌려야 한다.
                if (!visited[i][j]) {
                    if(maps[i][j]=='W'){
                        int count = bfs('W', i, j);
                        whiteColor += count * count;
                    }else{
                        int count = bfs('B', i, j);
                        blackColor += count * count;

                    }
                }
            }
        }
        System.out.print(whiteColor + " ");
        System.out.print(blackColor);

    }

    private static int bfs(char color, int y, int x) {
        visited[y][x] = true;
        int team = 1;
        queue.add(new Node(y, x));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[ny][nx] && maps[ny][nx] == color) {
                    visited[ny][nx] = true;
                    queue.add(new Node(ny, nx));
                    team++;
                }
            }
        }
        return team;
    }
}
