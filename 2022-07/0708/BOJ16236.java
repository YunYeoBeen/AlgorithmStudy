import java.nio.Buffer;
import java.util.*;
import java.io.*;
public class BOJ16236 {
    static class Node {
        int x,y, distance ;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[][] maps;
    static int sharkSize;
    static Queue<Node> shark;
    // 아기 상어는 자신보다 큰 먹이는 지나갈 수 없고
    // 오로지 자신과 크기가 같거나 작은 먹이만 지나갈 수 있다.
    // 단 자신보다 크기가 작은 물고기는 먹을 수 있다.

    // 먹은 먹이의 횟수와 자신의 몸집 사이즈와 같다면 사이즈 ++
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        maps = new int[N][N];
        shark = new LinkedList<>();
        sharkSize = 2;
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(s[j]);
                if(maps[i][j]==9){
                    shark.add(new Node(i,j,0));
                    maps[i][j]=0;
                }
            }
        }





        // 이동할 때 거리가 가장 가까운 물고기를 먹으러 간다?
        // maps를 돌 때 물고기가 있는 node를 따로 저장
        // 물고기가 있는 위치랑 node에서 꺼내온 위치랑 비교교

    }
}
