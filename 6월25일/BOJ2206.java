import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206 {
    // 벽을 뚫고 간 횟수의 변수 jump
    // 총 횟수의 변수 cnt
    static class Node {
        int x, y, jump, cnt;

        public Node(int x, int y, int jump, int cnt) {
            this.x = x;
            this.y = y;
            this.jump = jump;
            this.cnt = cnt;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int M, N;
    static int[][] maps;
    static boolean[][][] visited;
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maps = new int[N][M];
        visited = new boolean[2][N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                // 입력은 문자열이니 charAt으로 한 문자씩 정수로
                maps[i][j] = Integer.parseInt(s.charAt(j) + "");
            }
        }
        // bfs 시작
        System.out.println(bfs(0, 0));
    }

    private static int bfs(int startx, int starty) {
        queue.add(new Node(startx, starty, 0, 1));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            // cur의 x,y좌표가 끝지점에 도착할 때 bfs종료
            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.cnt;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int jump = cur.jump;
                int cnt = cur.cnt;
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[jump][nx][ny]) {
                    continue;
                }
                // 벽을 부수지 않고 이동하는 경우
                if (maps[nx][ny] == 0) {
                    visited[jump][nx][ny] = true;
                    queue.add(new Node(nx, ny, jump, cnt + 1));
                    // 벽을 부수고 이동하는 경우
                } else if (maps[nx][ny] == 1 && jump == 0) {
                    visited[jump][nx][ny] = true;
                    // 벽을 부쉈으니 이제 앞으로는 벽을 못부수니깐 jump+1
                    queue.add(new Node(nx, ny, jump + 1, cnt + 1));
                }
            }
        }
        return -1;
    }
}
