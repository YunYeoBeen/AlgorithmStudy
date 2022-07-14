import java.util.*;
import java.io.*;

public class BOJ16918 {
    static class Node {
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }
    static int R,C,N;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static char[][] maps;
    static boolean[][] visited;
    static Queue<Node> Bomb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        maps = new char[R][C];
        Bomb = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            char[] s = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                maps[i][j]=s[j];
                if(maps[i][j]=='O') Bomb.add(new Node(i,j));
            }
        }
        StringBuilder sb = new StringBuilder();
        if(N<2) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sb.append(maps[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
        }
        else{
            for (int i = 2; i <= N; i++) {
                if (i % 2 == 0) setBomb();
                else if (i % 2 == 1) BFS();
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sb.append(maps[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
        }
    }

    private static void BFS() {
        visited= new boolean[R][C];
        while(!Bomb.isEmpty()){
            Node cur = Bomb.poll();
            visited[cur.x][cur.y]=true;
            maps[cur.x][cur.y]='.';
            for (int i = 0; i < 4; i++) {
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                if(nx>=0 && nx<R && ny>=0 && ny<C && !visited[nx][ny]){
                    maps[nx][ny]='.';
                    visited[nx][ny]=true;
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(maps[i][j]=='O') Bomb.add(new Node(i,j));
            }
        }
    }

    private static void setBomb() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(maps[i][j]=='.') maps[i][j]='O';
            }
        }
    }
}
