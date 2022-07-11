import java.io.*;

public class BOJ2447 {
    public static void main(String[] args) throws IOException {
        String[][] arr;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        arr = new String[N][N];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = " ";
            }
        }
        star(arr, 0, 0, N);

        for (String[] strings : arr) {
            for (String string : strings) {
                bw.write(string + "");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void star(String[][] arr, int x, int y, int N) {
        if (N == 1) {
            arr[x][y] = "*";
            return; // 종료
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 2 && j == 2)) {
                    star(arr, x + i * (N / 3), y + j * (N / 3), N / 3);
                }
            }
        }
    }
}
