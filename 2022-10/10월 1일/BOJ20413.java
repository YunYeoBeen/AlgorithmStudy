import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20413 {
    static int N;
    static int s, g, p, d;
    static String[] mvp;

    public static void main(String[] args) throws Exception {
        // 브론즈, 실버, 골드, 플래티넘, 다이아몬드
        // 현재 달과 지난 달 => 총 2개월간의 과금액
        // 최대 아이아몬드 등급 기준액까지만 과금, 만원 단위로만 과금
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());


        mvp = new String[N];
        int monthMoney = 0;
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        String[] mvpRate = st.nextToken().split("");
        for (int i = 0; i < N; i++) {
            mvp[i] = mvpRate[i];
        }
        for (String rate : mvp) {
            if (rate.equals("B")) {
                sum += s - 1 - monthMoney;
                monthMoney = s - 1 - monthMoney;
            } else if (rate.equals("S")) {
                sum += g - 1 - monthMoney;
                monthMoney = g - 1 - monthMoney;
            } else if (rate.equals("G")) {
                sum += p - 1 - monthMoney;
                monthMoney = p - 1 - monthMoney;
            } else if (rate.equals("P")) {
                sum += d - 1 - monthMoney;
                monthMoney = d - 1 - monthMoney;
            } else {
                sum += d;
            }
        }
        System.out.println(sum);


    }
}
