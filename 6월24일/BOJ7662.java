import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            TreeMap<Integer, Integer> result = new TreeMap<>();
            int Q = Integer.parseInt(br.readLine());
            for (int j = 0; j < Q; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (command.equals("I")) {
                    result.put(num, result.getOrDefault(num, 0) + 1);
                } else {
                    if(result.isEmpty()) continue;
                    if(num==1){
                        int ans = result.lastKey();
                        if(result.get(ans)==1){
                            result.remove(ans);
                        }else{
                            result.put(ans, result.get(ans)-1);
                        }
                    }else{
                        int ans = result.firstKey();
                        if(result.get(ans)==1){
                            result.remove(ans);
                        }else{
                            result.put(ans, result.get(ans)-1);
                        }
                    }
                }
            }
            if (result.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(result.lastKey()).append(" ").append(result.firstKey()).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
