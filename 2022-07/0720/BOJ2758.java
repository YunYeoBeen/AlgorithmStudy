import java.util.*;
import java.io.*;

public class BOJ2758 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            long[][] nums = new long[n+1][m+1];

            for (int j = 0; j < m+1; j++) {
                nums[0][j]=1L;
            }
            for (int j = 1; j < n+1; j++) {
                for (int k = 1; k < m+1; k++) {
                    nums[j][k]=nums[j-1][k/2]+nums[j][k-1];
                }
            }
            sb.append(nums[n][m]).append("\n");
        }
        System.out.println(sb.toString());

    }
}
