import java.io.*;
import java.util.*;

public class BOJ1932 {
    static int N, ans;
    static int [][] map, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int d[][] = new int[n+1][n+1];
        int a[][] = new int[n+1][n+1];

        for(int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=i; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        /*
            위에서 아래로 내려가면서 값을 더하며 최하단층에서 가장 최댓값을 구한다.
            점화식 d[i][j] = (i,j)에 도착했을 때의 최댓값
            (i,j)는 i-1번째에서 왼쪽 혹은 오른쪽 수를 받는다.
            따라서 (i-1,j-1), (i-1,j) =>
         */
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                d[i][j] = Math.max(d[i-1][j-1], d[i-1][j]) + a[i][j];
            }
        }
        int ans=0;
        //마지막층 각각에 최댓값을 가지고 있어서 가장 큰 값 찾아준다.
        for(int i=1; i<=n; i++) {
            if(ans < d[n][i]) ans = d[n][i];
        }

        System.out.println(ans);
    }
}