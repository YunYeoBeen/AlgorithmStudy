import java.util.*;
import java.io.*;

public class BOJ3273 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(nums);
        int start = 0;
        int end = N-1;
        int cnt = 0;
        long sum = 0;
        while(start<end){
            sum = nums[start]+nums[end];
            if(sum>x){
                end--;
            }else if(sum<x){
                start++;
            }
            if(sum==x) {
                start++;
                end--;
                cnt++;
            }

        }
        System.out.println(cnt);
    }
}
