import java.util.*;
import java.io.*;

public class BOJ2981 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);
        int check = nums[1]-nums[0];
        for (int i = 2; i <N; i++) {
            check = gcd(check,nums[i]-nums[i-1]);
        }

        for(int i =2;i<check+1;i++){
            if(check%i == 0) ts.add(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int t : ts) {
            sb.append(t).append(" ");
        }
        System.out.println(sb.toString());
    }
    static int gcd(int a, int b){
        int temp = 0;
        if(a<b) {
            temp = a;
            a = b;
            b= temp;
        }
        while(b!=0){
            int mod = a%b;
            a = b;
            b = mod;
        }
        return a;
    }
}
