import java.util.*;
import java.io.*;

public class BOJ16928 {
    static class Node {
        int x, cnt;

        public Node(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }

    // 방문 여부
    static boolean[] visited;

    // 주사위 결과를 담을 queue
    static Queue<Node> queue;

    // 어차피 일직선 그래프니깐
//    static int[] maps;

    // ladder와 snake 저장할 변수
    static HashMap<Integer, Integer> jump;
    // 주사위
    static int[] dx = {0, 1, 2, 3, 4, 5, 6};

    // N,M
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();
        visited = new boolean[101];
        jump = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            jump.put(start, end);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            jump.put(start, end);
        }

        BFS(1);
    }

    private static void BFS(int x) {
        visited[x] = true;
        queue.offer(new Node(x, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int i = 0; i < 7; i++) {
                int nx = cur.x + dx[i];
                int cnt = cur.cnt;
                // 여기에서 만약 걸린다?
                // 그럼 nx가 1~6 사이 아무 숫자나 나와도 100이 된다는 소리니깐
                // 같이 저장한 cnt에 +1을 해줘야 한다.
                // 예를 들어 같이 저장한 Node가 (x: 98,cnt: 2)이면
                // 98에서 주사위 2가 나오면 이 if문에 걸리니깐 최종 cnt는 +1을 해줘야 한다.
                if(nx==100){
                    System.out.println(cnt+1);
                    return;
                }
                if (nx >= 100 || visited[nx]) continue;
                // 사다리나 스네이크에 포함되어 있지 않다면?
                if (!jump.containsKey(nx)) {
                    visited[nx] = true;
                    cnt++;
                    queue.offer(new Node(nx, cnt));
                }
                // 사다리나 스네이크에 포함되어 있다면?
                else {
                    visited[nx] = true;
                    nx = jump.get(nx);
                    cnt++;
                    queue.add(new Node(nx, cnt));
                }

            }
        }

    }
}
