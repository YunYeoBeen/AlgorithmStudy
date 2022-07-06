import java.io.*;
import java.util.*;

public class BOJ17298 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < N; i++){
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                nums[stack.pop()]=nums[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            nums[stack.pop()]=-1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(nums[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
