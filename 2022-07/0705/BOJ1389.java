import java.util.*;
import java.io.*;

public class BOJ1389 {
    static final int INF = 999999;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] maps = new int[N + 1][N + 1];

        // maps는 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i==j) {
                    maps[i][j]=0;
                    continue;
                }
                maps[i][j]=INF;
            }
        }

        // 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            maps[start][end]=maps[end][start]=1;
        }

        // 경유지(k) - 출발지(i) - 도착지 순(j)
        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                if(i==k) continue;
                for(int j=1;j<=N;j++){
                    if(i==j||k==j) continue;
                    if(maps[i][j]>maps[i][k]+maps[k][j]){
                        maps[i][j]=maps[i][k]+maps[k][j];
                    }
                }
            }
        }
        // 최소인 사람
        // check와 sum을 비교해서 check가 더 크다면? sum과 change 후
        // minPerson은 i로
        // 여기서 관점은 어차피 i를 순서대로 할 것이니 >=로 두지 않고 >로 둠으로써
        // 동일한 합이 나오더라도 더 작은 사람을 뽑을 수 있게 했다. (왜냐? i는 순서대로 증가하니깐)
        int minPerson = 0;
        int check = 99999;
        for (int i =1;i<=N;i++){
            int sum = 0;
            for (int j = 1; j < N+1; j++) {
                sum += maps[i][j];
            }
            if(check>sum){
                check = sum;
                minPerson = i;
            }
        }
        System.out.println(minPerson);


    }
}
