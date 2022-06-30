import java.util.*;
import java.io.*;
public class BOJ1018 {
    static char[][] maps;
    static int N,M,res = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maps = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                maps[i][j]=s.charAt(j);
            }

        }
        for (int i = 0; i <N-7 ; i++) {
            for (int j = 0; j < M-7; j++) {
                int num = findMap(i,j);
                res = Math.min(res,num);

            }
        }
        System.out.println(res);

    }

    private static int findMap(int i, int j) {
        int cnt = 0;
        char check = maps[i][j];
        for (int k = i; k < i+8; k++) {
            for (int l = j; l < j+8 ; l++) {
                if(maps[k][l] != check) {
                    cnt++;
                }
                if(check == 'W') check = 'B';
                else if(check == 'B') check = 'W';
            }
            if(check == 'W') check = 'B';
            else if(check == 'B') check = 'W';
        }
        return Math.min(64-cnt, cnt);
    }
}
