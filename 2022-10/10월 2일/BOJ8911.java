import java.io.*;
import java.util.*;
public class BOJ8911 {
    static int[] dx = {0,-1,0,1}; // 북, 서, 남, 동
    static int[] dy = {1,0,-1,0};
    static List<Integer> stateX,stateY;
    static int T;
    public static void main(String[] args) throws IOException{
        // 방향을 바꾼다라?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc< T;tc++){
            char[] direction = br.readLine().toCharArray();
            int x = 0;
            int y = 0;
            int xDirection = 0;
            int yDirection = 0;
            int result = 0;
            stateX = new ArrayList<>();
            stateY = new ArrayList<>();
            stateX.add(x);
            stateY.add(y);
            for (char c : direction) {
                if(c=='F'){
                    x = x + dx[xDirection];
                    y = y + dy[yDirection];
                    stateX.add(x);
                    stateY.add(y);
                }else if(c=='L'){
                    xDirection += 1;
                    if(xDirection == 4) xDirection = 0;
                    yDirection += 1;
                    if(yDirection == 4) yDirection = 0;
                } else if(c=='B'){
                    x = x - dx[xDirection];
                    y = y - dy[yDirection];
                    stateX.add(x);
                    stateY.add(y);
                } else{
                    xDirection -= 1;
                    if(xDirection == -1 ) xDirection = 3;
                    yDirection -= 1;
                    if(yDirection == -1 ) yDirection = 3;
                }
            }
            ListSort(stateX, stateY);
            result = (stateX.get(stateX.size()-1)-stateX.get(0))*(stateY.get(stateY.size()-1)-stateY.get(0));
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void ListSort(List<Integer> stateX, List<Integer> stateY) {
        Collections.sort(stateX);
        Collections.sort(stateY);
    }
}
