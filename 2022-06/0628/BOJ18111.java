import java.io.*;
import java.util.StringTokenizer;

public class BOJ18111 {
    static int N, M, B, time = Integer.MAX_VALUE, height;
    static int[][] maps;
    static int maxValue, minValue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        maxValue = Integer.MIN_VALUE;
        minValue = Integer.MAX_VALUE;
        maps = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int check = Integer.parseInt(st.nextToken());
                maps[i][j] = check;
                maxValue = Math.max(check, maxValue);
                minValue = Math.min(check, minValue);
            }
        }
        findSolution();
        System.out.println(time + " " + height);

    }

    private static void findSolution() {
        for (int i = minValue; i <= maxValue; i++) {
            int countTime = 0;
            int limitBlock = B;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (i < maps[j][k]) {
                        countTime += ((maps[j][k] - i) * 2);
                        limitBlock += (maps[j][k] - i);
                    } else if (i > maps[j][k]) {
                        countTime += (i - maps[j][k]) * 1;
                        limitBlock -= (i - maps[j][k]);
                    }
                }
            }
            if (limitBlock >= 0) {
                if (time >= countTime) {
                    time = countTime;
                    height = i;
                }

            }
        }
    }
}
