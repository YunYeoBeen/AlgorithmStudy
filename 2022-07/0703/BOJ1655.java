import java.util.*;
import java.io.*;


public class BOJ1655 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxRes = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minRes = new PriorityQueue<>();

        for(int i=0;i<N;i++){
            // 부른 수의 개수가 홀수일 때
            int num = Integer.parseInt(br.readLine());
            if(maxRes.size()<=minRes.size()){
                maxRes.offer(num);
            }else{
                minRes.offer(num);

            }
            // 중간값을 구해야 하니깐 최대값은 내림차순으로 쌓이고
            // 최소힙은 오른차순으로 쌓인다.
            // 최대힙의 peek값이 최소힙의 peek값보다 크면 중간값을 구하려는 로직이 엉망이 된다.
            // 최대 힙: 1,5...
            // 최소힙 : 2 이렇게 되면 1 5 2 순으로 되니깐 1,2,5로 되어줄라면 끝의 두 peek을 swap해줘야 한다.
            if((!minRes.isEmpty() && maxRes.peek()>minRes.peek())){
                maxRes.offer(minRes.poll());
                minRes.offer(maxRes.poll());
            }
            sb.append(maxRes.peek()).append("\n");
        }
        System.out.println(sb.toString());

    }
}
