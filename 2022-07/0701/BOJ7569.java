import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {
    static class Node {
        int h, y, x;

        public Node(int h, int y, int x) {
            this.h = h;
            this.y = y;
            this.x = x;
        }
    }

    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int H, M, N,resDay;
    // 높이: H, Y, Z 순
    // 컴퓨터에서는 3차원에서는 z,y,x순
    static int[][][] maps;
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        maps = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    maps[i][j][k] = Integer.parseInt(st.nextToken());
                    if (maps[i][j][k] == 1) queue.add(new Node(i, j, k));
                }
            }
        }
        if(queue.size()==M*N*H) {
            System.out.println(0);
            return;
        }
        BFS();
        if(resDay==-1) System.out.println(-1);
        else System.out.println(resDay-1);
    }

    private static void BFS() {
        //resDay랑 익은 시점을 기준으로 뻗어나가면서 +1한 날짜를 비교
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            for(int i=0;i<6;i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                int nh = cur.h+dh[i];

                // nx = y고 ny = x고 nh = h
                if(nx<0 || ny<0 || nh<0 || nx>=M|| ny>=N || nh>=H) continue;
                if(maps[nh][ny][nx]==0){
                    maps[nh][ny][nx] = maps[cur.h][cur.y][cur.x]+1;
                    queue.add(new Node(nh,ny,nx));
                }

            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(maps[i][j][k] == 0) {
                        resDay = -1;
                        return;
                    }
                    if(resDay<maps[i][j][k]) resDay = maps[i][j][k];
                }
            }
        }
    }
}
