import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11724 {
    static boolean[] visited;
    static int[][] maps;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // maps와 방면 여부 변수
        maps = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        // 연결 요소의 개수를 위한 변수
        int res = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            maps[start][end] = 1;
            maps[end][start] = 1;
        }
        for (int i = 1; i < N + 1; i++) {
            // 1행부터 체크 시작
            // 만약 visited[i]이 방문되어지지 않았다면?
            // dfs 실행
            if (!visited[i]) {
                dfs(i);
                res++;
            }
        }
        System.out.println(res);

    }

    private static void dfs(int start) {
        // dfs실행했으니 visited[start=i]는 true로 바꿔주고
        visited[start] = true;
        for (int i = 1; i < maps.length; i++) {
            // start와 i가 서로 연결됐고 i를 방문을 안했다면?
            // dfs실행
            if (maps[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
