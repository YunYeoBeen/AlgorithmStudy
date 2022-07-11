import java.util.*;
import java.io.*;

public class BOJ10815 {
    static int[] res;
    static int[] nums;
    static int N,M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        M =Integer.parseInt(br.readLine());
        res = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            res[i] = Integer.parseInt(st.nextToken());
        }
        for (int re : res) {
            int value = search(re);
            sb.append(value).append(" ");
        }
        System.out.println(sb.toString());

    }

    private static int search(int find) {
        int first = 0;
        int last = nums.length-1;
        int mid = 0;
        while(first<=last){
            mid = (first+last)/2;
            if(nums[mid]==find){
                return 1;
            }
            if(nums[mid]<find){
                first = mid+1;
            }else{
                last = mid-1;
            }
        }
        return 0;
    }
}
