import java.util.ArrayList;

public class CosPro {

    public static void main(String[] args) {
        String s1 = new String("112001");
        String s2 = new String("12010");
        char[] s1Nums = s1.toCharArray();
        char[] s2Nums = s2.toCharArray();
        int p = 3;
        int q = 8;
        int s1Sum = 0;
        int s2Sum = 0;
        String answer = "";
        for(int i = s1Nums.length-1;i>=0;i--){
            s1Sum+=Integer.parseInt(String.valueOf(s1Nums[i]))*(Math.pow(p,Math.abs(i-(s1Nums.length-1))));
        }
        for(int i = s2Nums.length-1;i>=0;i--){
            s2Sum+=Integer.parseInt(String.valueOf(s2Nums[i]))*(Math.pow(p,Math.abs(i-(s2Nums.length-1))));
        }
        int totalSum = s1Sum+s2Sum;
        while(true){
            int remain = totalSum%q;
            answer=String.valueOf(remain)+answer;
            totalSum /= q;
            if(totalSum == 0) break;
        }

    }
}
