import java.io.*;
import java.util.*;

public class BOJ2108 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        // 산술평균
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int avg = (int)Math.round(((double)sum / N));

        // 중앙값
        Arrays.sort(nums);
        int middle = nums[N/2];


        // 범위
        int range = nums[N - 1] - nums[0];

        // 최빈값
        int[] plusNums = new int[4002];
        int[] minusNums = new int[4001];
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            if (num < 0) {
                minusNums[Math.abs(num)]++;
            } else {
                plusNums[Math.abs(num)]++;
            }
        }

        // 가장 높은 빈도수를 체크
        int maxPlus = Integer.MIN_VALUE;
        for (int i = 0; i < 4002; i++) {
            maxPlus = Math.max(maxPlus, plusNums[i]);
        }
        for (int i = 0; i < 4001; i++) {
            maxPlus = Math.max(maxPlus, minusNums[i]);
        }

        for (int num : nums) {
            if (num < 0) {
                if (minusNums[Math.abs(num)] == maxPlus && !(list.contains(num))) {
                    list.add(num);
                }
            } else {
                if (plusNums[num] == maxPlus && !(list.contains(num))) {
                    list.add(num);
                }
            }
        }
        int many = 0;
        if (list.size() >= 2) {
            many = list.get(1);
        } else {
            many = list.get(0);
        }
        System.out.println(avg);
        System.out.println(middle);
        System.out.println(many);
        System.out.println(range);


    }
}
