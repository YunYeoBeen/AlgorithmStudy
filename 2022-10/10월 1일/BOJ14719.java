import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BOJ14719 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] blockHeight = new int[W+1];
        int[] waterHeight = new int[W+1];
        int[] result = new int[W+1];
        int[] water = new int[W+1];
        for (int i = 1; i < water.length; i++) {
            water[i] = Integer.parseInt(st.nextToken());
        }

        // 오른쪽에서 왼쪽으로 최대값 저장
        int rightToLeft = -1;
        for (int i = 1; i < waterHeight.length ; i++) {
            if(rightToLeft<water[i]){
                rightToLeft = water[i];
                waterHeight[i] = water[i];
            }else{
                waterHeight[i]=rightToLeft;
            }
        }

        // 왼쪽에서 오른쪽으로 최대값 저장
        int leftToRight = -1;
        for (int i = water.length-1; i > 0 ; i--) {
            if(leftToRight<water[i]){
                leftToRight = water[i];
                blockHeight[i] = water[i];
            }else{
                blockHeight[i]=leftToRight;
            }
        }

        // water와 blcok을 비교해서 더 작은 값 저장
        for(int i=1;i<waterHeight.length;i++){
            result[i]= Math.min(waterHeight[i],blockHeight[i] );
        }
        int sum =0;

        // 이제 result와 실제 물높이를 비교해서 뺀 값 저장
        for(int i=1;i<water.length;i++){
            sum+= Math.abs(water[i]-result[i]);
        }
        System.out.println(sum);

    }
}
