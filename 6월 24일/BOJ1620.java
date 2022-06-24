import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 빠른 출력을 위한 StringBuilder()
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 포켓몬을 담을 해쉬맵 선언
        HashMap<String, String> result = new HashMap<>();

        // 포켓몬 담기 시작
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            // 포멧몬의 index도 key값으로 담자.
            String index = String.valueOf(i+1);
            result.put(name,index);
            result.put(index,name);
        }

        // 이제 출력을 위한 입력
        for (int i = 0; i < N; i++) {
            String ans = br.readLine();
            if(result.containsKey(ans)){
                sb.append(result.get(ans)).append("\n");
            }
        }
        System.out.println(sb.toString());
    }


}
