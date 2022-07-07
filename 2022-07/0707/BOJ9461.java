import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ9461 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            Long[] DP = new Long[101];
            DP[1]=1L;
            DP[2]=1L;
            DP[3]=1L;
            for (int j = 4; j <= N; j++) {
                DP[j] = DP[j-3]+DP[j-2];
            }
            sb.append(DP[N]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
