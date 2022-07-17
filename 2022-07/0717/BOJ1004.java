import java.util.*;
import java.io.*;
public class BOJ1004 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int startx = Integer.parseInt(st.nextToken());
            int starty = Integer.parseInt(st.nextToken());
            int endx = Integer.parseInt(st.nextToken());
            int endy = Integer.parseInt(st.nextToken());

            int N = Integer.parseInt(br.readLine());
            int res = 0;
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int planetx = Integer.parseInt(st.nextToken());
                int planety = Integer.parseInt(st.nextToken());
                int planetRadius = Integer.parseInt(st.nextToken());

                boolean start = isContain(startx,starty,planetx,planety,planetRadius);
                boolean end = isContain(endx,endy,planetx,planety,planetRadius);

                if(!(start && end) && (start || end)){
                    res++;
                }
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb.toString());

    }
    static boolean isContain(int startx,int starty, int planetx,int plaenty, int radius){
        int x = startx-planetx;
        int y = starty-plaenty;
        double check = Math.pow(x,2)+Math.pow(y,2);
        return check<Math.pow(radius,2);
    }
}
