import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ14888 {
    static int n, max, min;
    static int[] num, oper;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        // 1. 숫자입력받기
        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0;i<n;i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 기호 입력받기
        oper = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0;i<4;i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        dfs(1, num[0]);
        System.out.println(max);
        System.out.println(min);

    }
    public static void dfs(int cnt, int sum) {
        if (cnt == n) {
            // 연산자를 다 썼다면 최댓값 최솟값 비교
            max = Math.max(sum, max);
            min = Math.min(sum, min);
            return;
        }

        for(int i=0;i<4;i++) {
            if(oper[i]==0) {
                // 사용할 수 없는 연산자라면 넘기기
                continue;
            }
            oper[i]--;
            switch (i) {
                case 0:
                    dfs(cnt+1, sum+num[cnt]);
                    break;
                case 1:
                    dfs(cnt+1, sum-num[cnt]);
                    break;
                case 2:
                    dfs(cnt+1, sum*num[cnt]);
                    break;
                case 3:
                    dfs(cnt+1, sum/num[cnt]);
                    break;
            }
            oper[i]++;
        }
    }
}
