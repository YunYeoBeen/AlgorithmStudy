import java.io.*;
import java.util.*;

public class BOJ1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // N을 위한 HashMap
        HashMap<String, Integer> people = new HashMap<>();

        // 결과를 위한 ArrayList
        List<String> result = new ArrayList<>();

        // 로직 시작
        /*
            0번째부터 N까지의 입력받은 이름을 people HashMap에 저장 후
            N번째부터 M번째까지는 보지 못한 사람
        */
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            people.put(name, 0);
        }
        for (int i = N; i < N + M; i++) {
            String name = br.readLine();
            if (people.containsKey(name)) {
                result.add(name);
            }
        }
        Collections.sort(result);

        // 이제 RESULT 출력
        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }

    }
}
