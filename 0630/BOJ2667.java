import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2667 {
    static class Node {
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int[][] maps;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static boolean[][] visited;
    static Queue<Node> queue;
    static List<Integer> list;
    static int homeCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        maps = new int[N][N];
        list = new ArrayList<>();
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N ; j++) {
                int num = s.charAt(j)-'0';
                maps[i][j]=num;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(maps[i][j]==1 && !visited[i][j]){
                    BFS(i,j);
                }
            }

        }
        System.out.println(homeCnt);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    private static void BFS(int start, int end) {
        int cnt=1;
        queue = new LinkedList<>();
        visited[start][end]=true;
        queue.add(new Node(start,end));
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            for(int i =0; i<4;i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny] && maps[nx][ny]==1){
                    visited[nx][ny]=true;
                    queue.add(new Node(nx,ny));
                    cnt++;
                }
            }
        }
        list.add(cnt);
        homeCnt++;

    }
}
