import java.io.*;
import java.util.*;

public class BOJ11403 {
    static final int INF = 999999;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] distance = new int[N][N];
        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                distance[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 경유지 - 출발지 - 도착지
        for (int k = 0; k < N; k++) {
            // 경유지와 출발지
            for (int i = 0; i < N; i++) {
                // 경유지-출발지 , 경유지 - 도착지
                for (int j = 0; j < N; j++) {
                    // 기존에는 자기 자신으로 오는 경우는 빼고 플로이드 워샬을 구현했었는데
                    // 이번에는 자기 자신까지 오는 최단 거리까지 구해야 하므로
                    if(distance[i][k]==1 && distance[k][j]==1){
                        distance[i][j]=1;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(distance[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}
