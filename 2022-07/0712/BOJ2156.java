import java.util.*;
import java.io.*;

public class BOJ2156 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = nums[1];

        //dp[N-1],dp[N-2]+nums[N],dp[N-3]+nums[N-1]+nums[N];
        if (N >= 2) dp[2] = nums[1] + nums[2];
        for (int i = 3; i < N + 1; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + nums[i], dp[i - 3] + nums[i - 1] + nums[i]));
        }
        System.out.println(dp[N]);


    }
}
