import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1012 {
    static int N, M, K;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] maps;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // 배추밭 크기 초기화
            maps = new int[M][N];
            visited = new boolean[M][N];

            // 총 배추흰지렁이 수
            int cnt = 0;

            // 배추가 있는 위치 배추밭에 표시
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                maps[x][y] = 1;
            }

            // 배추가 있는 위치(1)부터 시작해야 하니깐 이중 포문 사용
            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (maps[x][y] == 1 && !visited[x][y]) {

                        // bfs 혹은 dfs 사용
                        dfs(x, y);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }

    // dfs 메서드
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && maps[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}
