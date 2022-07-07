import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class BOJ1912 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N+1];
        int[] DP = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N ; i++) {
            DP[i]=Math.max(DP[i-1]+nums[i],nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <=N ; i++) {
            res = Math.max(res, DP[i]);
        }
        System.out.println(res);


    }
}
