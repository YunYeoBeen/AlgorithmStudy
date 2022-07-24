import java.util.*;
import java.io.*;

public class BOJ11121 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String answer = st.nextToken();
            String result = st.nextToken();
            if(answer.equals(result)) sb.append("OK").append("\n");
            else sb.append("ERROR").append("\n");
        }
        System.out.println(sb.toString());
    }
}
