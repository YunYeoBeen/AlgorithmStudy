import java.io.*;
import java.util.*;
public class BOJ2667 {
    static class Node {
        int x,y;
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    static int N;
    static int count;
    static int[][] maps;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static Queue<Node> queue;
    static List<Integer> number;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        maps = new int[N][N];
        visited = new boolean[N][N];
        queue = new LinkedList<>();
        number = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] s = st.nextToken().split("");
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(s[j]);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[j][i] && maps[j][i]==1){
                    bfs(j,i);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(number);
        sb.append(number.size()).append("\n");
        for (int i = 0; i < number.size() ; i++) {
            sb.append(number.get(i)).append("\n");
        }
        System.out.println(sb);
    }
    private static void bfs(int y, int x) {
        queue.add(new Node(y,x));
        visited[y][x] = true;
        int count = 1;
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            for (int i = 0; i < 4 ; i++) {
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[ny][nx] && maps[ny][nx] == 1){
                    queue.add(new Node(ny, nx));
                    visited[ny][nx] = true;
                    count++;
                }
            }
        }
        number.add(count);
    }
}
