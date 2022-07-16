import java.util.*;
import java.io.*;

public class BOJ5430 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            Deque<Integer> dq = new ArrayDeque<>();
            char[] p = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");
            for (int j = 0; j < n; j++) {
                dq.offer(Integer.parseInt(st.nextToken()));
            }
            boolean direction = true;
            boolean isError= false;
            for (char c : p) {
                if(c=='R'){
                    direction = !direction;
                }else{
                    if(!dq.isEmpty()) {
                        if (direction) dq.pollFirst();
                        else dq.pollLast();
                    }else{
                        sb.append("error").append("\n");
                        isError = true;
                        break;
                    }
                }
            }
            //isError가 false
            // 즉 에러없이 잘 내려왔으면 이 조건문을 타고
            // 아니면 바로 다음 테케로로
           if(!isError){
                sb.append("[");
                while(!dq.isEmpty()){
                    if(direction) sb.append(dq.pollFirst());
                    else sb.append(dq.pollLast());
                    if(!dq.isEmpty()) sb.append(",");
                }
                sb.append("]").append("\n");
            }
        }
        System.out.println(sb.toString());
    }

}
