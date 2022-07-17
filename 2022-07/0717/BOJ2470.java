
import java.util.*;
import java.io.*;

public class BOJ2470 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] nums = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(nums);
        int start = 0;
        int end = N - 1;
        int x=0;
        int y=0;
        long check = Long.MAX_VALUE;
        while (start < end) {
            long sum = nums[start] + nums[end];
            long absSum = Math.abs(sum);
            if (absSum < check) {
                check = absSum;
                x = start;
                y = end;
            }
            if(sum>0){
                end--;
            }else{
                start++;
            }
        }
        System.out.println(nums[x]+" "+nums[y]);
    }
}
