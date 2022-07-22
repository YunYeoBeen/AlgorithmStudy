import java.util.*;
import java.io.*;

public class BOJ1260 {
    static int N, M, V;
    static int[][] maps;
    static boolean[] visited;
    static Queue<Integer> queue;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        maps = new int[N + 1][N + 1];
        visited = new boolean[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            maps[start][end] = maps[end][start] = 1;
        }
        dfs(V);
        System.out.println();
        bfs();


    }

    private static void dfs(int v) {
        visited[v]=true;
        System.out.print(v+" ");
        for (int i = 1; i < N+1 ; i++) {
            if(maps[v][i]==1 && !visited[i]){
                dfs(i);
            }
        }
    }

    private static void bfs() {
        queue = new LinkedList<>();
        visited = new boolean[N + 1];
        queue.add(V);
        visited[V] = true;
        System.out.print(V+" ");
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (maps[cur][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i]=true;
                    System.out.print(i+" ");
                }
            }
        }


    }
}
