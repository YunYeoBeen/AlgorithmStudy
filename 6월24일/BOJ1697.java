import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    N부터 M까지 가는 모든 경우의 수를 트래킹
    --> BFS
 */
public class BOJ1697 {
    static int N,M;
    // 방문 여부 체크
    static boolean[] visited;
    // 시간 체크를 위한 일차원 배열
    static int[] nums;
    // 걷거나 순간이동
    static int[] dx = {-1,1,2};
    // 큐 생성(보통 bfs사용할 때 큐 사용)
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 수빈이와 동생의 최대 정수값 100000
        nums = new int[100001];
        visited = new boolean[100001];

        // 수빈이와 동생의 위치가 처음부터 같을 때
        if(N==M){
            System.out.println(0);
        }else{
            bfs(N,M);
        }
    }

    private static void bfs(int start, int end) {
        // start를 queue에 담고 방문 배열도 true로로
       visited[start]=true;
        queue.add(start);
        while(!queue.isEmpty()){
            int pos = queue.poll();
            for(int i =0; i<3;i++){
                int nx = 0;

                // 순간이동일 때는 곱하기 2
                if(i==2){
                    nx = pos*dx[i];
                }else{
                    nx = pos+dx[i];
                }

                // nx가 0보다 작거나 100000보다 클 때는 continue
                if(nx<0 || nx>100000){
                    continue;
                }

                if(!visited[nx]){
                    queue.add(nx);
                    visited[nx]=true;
                    // pos이후는 시간이 1씩 추가
                    nums[nx]=nums[pos]+1;
                    if(nx==end){
                        System.out.println(nums[end]);
                        return;
                    }
                }

            }
        }
    }
}
