import java.util.*;
import java.io.*;

public class BOJ1269 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        HashSet<Integer> numA = new HashSet<>();
        HashSet<Integer> numB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            numA.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            numB.add(Integer.parseInt(st.nextToken()));
        }

        int size = 0;
        for (int num : numB) {
            if (!numA.contains(num)) size++;
        }
        for (int num : numA) {
            if (!numB.contains(num)) size++;
        }


        System.out.println(size);


    }
}
