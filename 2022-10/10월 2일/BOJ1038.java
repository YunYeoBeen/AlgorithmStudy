import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ1038 {
    static int N;
    static List<Long> nums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if (N <= 10) {
            System.out.println(N);
            return;
        } else if (N > 1022) {
            // 여기 처리하는 방법을 몰랐다.
            System.out.println(-1);
            return;
        } else {
            for (int i = 1; i < 10; i++) {
                createNum(i);
            }
            Collections.sort(nums);
            System.out.println(nums.get(N-1));
        }
    }

    private static void createNum(long num) {
        long remain = num % 10;
        nums.add(num);
        if(remain == 0) return;
        for(long i = remain-1; i >=0; i--){
            createNum(num*10+i);
        }
    }
}
