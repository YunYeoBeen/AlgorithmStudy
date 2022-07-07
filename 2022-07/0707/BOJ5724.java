import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ5724 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            int result = 0;
            int N = Integer.parseInt(br.readLine());
            if(N==0) break;
            while (N >= 0) {
                result += Math.pow(N, 2);
                N--;
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }
}
