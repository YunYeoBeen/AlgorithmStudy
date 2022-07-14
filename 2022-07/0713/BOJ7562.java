import java.util.*;
import java.io.*;


public class BOJ7562 {
    static class Node {
        int x, y, dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int T, I;
    static int[][] maps;
    static boolean[][] visited;
    static Queue<Node> queue;
    static int[] dx = {-2, -1, 2, 1, 2, 1, -2, -1};
    static int[] dy = {1, 2, 1, 2, -1, -2, -1, -2};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            I = Integer.parseInt(br.readLine());
            maps = new int[I][I];
            visited = new boolean[I][I];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startx = Integer.parseInt(st.nextToken());
            int starty = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endx = Integer.parseInt(st.nextToken());
            int endy = Integer.parseInt(st.nextToken());

            sb.append(bfs(startx,starty,endx,endy)).append("\n");

        }
        System.out.println(sb.toString());

    }
    static int bfs(int startx, int starty, int endx, int endy) {
        queue = new LinkedList<>();
        visited[startx][starty] = true;
        queue.add(new Node(startx, starty,0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur.x == endx && cur.y==endy){
                return cur.dist;
            }
            for (int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= I || ny < 0 || ny >= I || visited[nx][ny]) continue;
                visited[nx][ny]=true;
                queue.add(new Node(nx, ny,cur.dist+1));
            }
        }
        return 0;
    }
}