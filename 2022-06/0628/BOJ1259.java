import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1259  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String s = br.readLine();
            String res = "";
            if(s.equals("0")) break;
            for (int i = s.length()-1; i >= 0; i--) {
                res += s.charAt(i);
            }
            String check = "yes";
            for (int i = 0; i < s.length(); i++) {
                char a = s.charAt(i);
                char b = res.charAt(i);
                if(a!=b){
                    check = "no";
                    break;
                }
            }
            System.out.println(check);
        }

    }
}
