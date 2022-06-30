import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] nums = new int[K];
        for (int i = 0; i < K ; i++) {
            nums[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);

        long high = nums[K-1];
        long low = 1;
        long mid = 0;
        while(low<=high){
            mid = (low+high)/2;
            long cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                cnt += nums[i]/mid;
            }
            if(cnt<N){
                high = mid-1;
            }
            if(cnt>=N) low = mid+1;
        }
        System.out.println(high);

    }
}
