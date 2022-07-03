import java.util.*;
import java.io.*;

public class BOJ17219 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String,String> res = new HashMap<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String url = st.nextToken();
            String pw = st.nextToken();
            res.put(url,pw);
        }
        for(int i=0;i<M;i++){
            sb.append(res.get(br.readLine())).append("\n");
        }
        System.out.println(sb.toString());

    }
}
