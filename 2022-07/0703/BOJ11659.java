import java.io.*;
import java.util.*;

public class BOJ11659 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] nums = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        // 누적합 시작
        // 1번째처럼 여기기 위해서 크기+1 해주었다.
        for (int i = 1; i < N+1; i++) {
            nums[i]+=nums[i-1];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(nums[end]-nums[start-1]).append("\n");
        }
        System.out.println(sb.toString());


    }
}
