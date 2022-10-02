import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3568 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] format = br.readLine().split(" ");
        String prefix = format[0];
        for(int i=1;i<format.length;i++){
            solution(prefix,format[i]);
        }
        System.out.println(sb.toString());
    }

    private static void solution(String prefix, String s) {
        String result = "";
        String variable ="";
        for (int i = 0;i<s.length();i++) {
            char string = s.charAt(i);
            if(string == '&' || string =='*') result+=Character.toString(string);
            else if(string == '[') result+= Character.toString(']');
            else if(string == ']') result +=Character.toString('[');
            else if(('a'<=string && 'z'>=string) || ('A'<=string && 'Z'>=string)){
                variable += Character.toString(string);
            }
        }
        String reverseResult = "";
        char[] a = result.toCharArray();
        for (int i=a.length-1;i>=0;i--) {
            reverseResult+=a[i];
        }
        sb.append(prefix+reverseResult+" ").append(variable).append(";").append("\n");
    }
}


