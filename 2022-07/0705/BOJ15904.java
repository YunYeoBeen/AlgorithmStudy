import java.util.*;
import java.io.*;

public class BOJ15904 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] str_array = str.split("");

        // 투포인터 느낌처럼 풀어봤음
        // point는 "UCPC"의 인덱스라고 생각하였다.
        int point = 0;
        for (int i = 0; i < str_array.length; i++) {
            if(str_array[i].equals("U")) {
                if(point ==0 ){
                    point++;
                    continue;
                }
            }
            if(str_array[i].equals("C")) {
                if(point ==1 || point ==3){
                    point++;
                    continue;
                }
            }
            if(str_array[i].equals("P")) {
                if(point == 2){
                    point++;
                    continue;
                }
            }
        }
        if(point==4) System.out.println("I love UCPC");
        else System.out.println("I hate UCPC");
    }


}
