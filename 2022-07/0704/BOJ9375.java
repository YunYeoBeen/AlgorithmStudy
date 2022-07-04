import java.util.*;
import java.io.*;

public class BOJ9375 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            HashMap<String,Integer> res = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            for(int k=0;k<N;k++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                // cloth는 입력을 받든 말든 상관없으니 그냥 지나가도록
                st.nextToken();

                // 옷의 종류가 중요
                String categories = st.nextToken();

                // 이미 있는 옷의 종류라면 +1 아니면 그냥 values는 1로 저장
                if(!res.containsKey(categories)){
                    res.put(categories,1);
                }else {
                    int cnt = res.get(categories);
                    cnt++;
                    res.put(categories,cnt);
                }
            }

            int sum = 1;
            for(int category:res.values()){
                // 옷의 종류가 A A B가 있다면?
                // A:2, B:1 이니깐
                // (2+1)*(1+1)-1을 해줘야 한다.
                int result = category+1;
                sum *= result;
            }
            sb.append(sum-1).append("\n");
        }
        System.out.println(sb.toString());
    }
}
