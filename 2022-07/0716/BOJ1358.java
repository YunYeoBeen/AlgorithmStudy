import java.util.*;
import java.io.*;


public class BOJ1358 {
    static class Node {
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int radius = H/2;
        int centerx = X;
        int centery = Y+H/2;

        Queue<Node> players = new LinkedList<>();

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            players.add(new Node(x,y));
        }

        int cnt = 0;
        while(!players.isEmpty()){
            Node cur = players.poll();
            int nx = cur.x;
            int ny = cur.y;
            int checkx = nx-centerx;
            int checky = ny -centery;
            int endx = (X+W)-nx;
            double distanceStart = Math.pow(Math.abs(checkx),2)+Math.pow(Math.abs(checky),2);
            double distanceEnd = Math.pow(Math.abs(endx),2)+Math.pow(Math.abs(checky),2);
            if(nx>=X && nx<=X+W && ny>=Y && ny<=Y+H) {
                cnt++;
                continue;
            }
            if(distanceStart<=radius*radius) {
                cnt++;
                continue;
            }
            if(distanceEnd<=radius*radius) {
                cnt++;
                continue;
            }
        }
        System.out.println(cnt);





    }
}
