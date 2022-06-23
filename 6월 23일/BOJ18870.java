import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18870 {
    static int[] nums, cloneNums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 결과 출력하기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();

        // 기존 배열
        nums = new int[T];

        // 복사한 배열
        cloneNums = new int[T];

        // 중복을 허용하지 않으면서 순위를 맺기 위한 변수(rank)와 HashMap
        int rank = 0;
        HashMap<Integer, Integer> result = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 두 번째 줄을 nums와 cloneNums에 각각 넣기
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
            cloneNums[i] = num;
        }

        // cloneNums를 작은 수부터 정렬
        Arrays.sort(cloneNums);

        // -10 -9 2 4 4를 예로 들면
        // -10은 중복하지 않으면서 가장 작은 수니 rank는 0
        // -9는 중복하지 않으면서 두 번째로 작은 수니 rank는 1
        // 2는 중복하지 않으면서 세 번째로 작은 수니 rank는 2
        // 4는 중복하고 가장 큰 수니 rank는 3
        for (int i = 0; i < T; i++) {
            if(!result.containsKey(cloneNums[i])){
                result.put(cloneNums[i],rank);
                rank++;
            }
        }

        // result -->
        // -10 : 0
        // -9 : 1
        // 2 : 2
        // 4: 3
        // 이제 이거를 기존 nums에 대입하여 nums의 수에 맞는 value를 출력하면 끝!
        for(int i=0;i<T;i++){
            if(result.containsKey(nums[i])){
                sb.append(result.get(nums[i])).append(" ");
            }
        }
        System.out.println(sb.toString());
    }

}
