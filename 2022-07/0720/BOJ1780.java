import java.util.*;
import java.io.*;

public class BOJ1780 {
    static int[][] maps;
    static int ONE, ZERO, MINUSONE ;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        maps = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divid(0,0,N);
        System.out.println(MINUSONE);
        System.out.println(ZERO);
        System.out.println(ONE);
    }

    private static void divid(int start, int end, int size) {

        boolean check = checkColor(start, end, size);
        if(check){
            if(maps[start][end]==0) ZERO++;
            else if(maps[start][end]==1) ONE++;
            else MINUSONE++;
            return;
        }

        int newSize = size / 3;

        divid(start, end, newSize);
        divid(start, end+newSize, newSize);
        divid(start, end+2*newSize, newSize);

        divid(start+newSize, end, newSize);
        divid(start+newSize, end+newSize, newSize);
        divid(start+newSize, end+2*newSize, newSize);

        divid(start+2*newSize, end, newSize);
        divid(start+2*newSize, end+newSize, newSize);
        divid(start+2*newSize, end+2*newSize, newSize);


    }

    private static boolean checkColor(int start, int end, int size) {
        int color = maps[start][end];
        for (int i = start; i < start+size ; i++) {
            for (int j = end; j < end+size; j++) {
                    if(color != maps[i][j]) {
                        return false;
                    }
            }
        }
        return true;
    }
}
