import java.util.*;
import java.io.*;

public class BOJ11478 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Set<String> res = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            String ans = "";
            for (int j = i; j < s.length(); j++) {
                ans+=s.substring(j,j+1);
                res.add(ans);
            }
        }
        System.out.println(res.size());

    }
}
