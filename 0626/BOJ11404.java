import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11404 {
    static final int INF = 9999999;
    static int[][] adjMatrix;
    static int N,M;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adjMatrix = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j && adjMatrix[i][j] == 0) {
                    adjMatrix[i][j] = INF;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjMatrix[a][b]= Math.min(adjMatrix[a][b],c);

        }
        // 경유지-출발지-목적지 순
        for (int k = 1; k <= N; k++) { // 거쳐가는 중간 노드
            for (int i = 1; i <= N; i++) { // 시작 노드
                if (i == k) continue;
                for (int j = 1; j <= N; j++) { // 마지막 노드
                    if (i == j || k == j) continue;
                    if (adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) {
                        adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
                    }
                }
            }
        }
        // 최솟값 갱신을 위한 부분
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 갈 수 없는 곳은 0으로 초기화
                if (adjMatrix[i][j] == INF) {
                    adjMatrix[i][j] = 0;
                }
                sb.append(adjMatrix[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

