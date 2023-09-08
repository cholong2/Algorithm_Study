import java.io.*;
import java.util.*;

/**
 * start : 2023-09-08 17:57
 * end : 2023-09-08 17:57
 * 알고리즘 : 수학, 분할재귀를 이용한 거듭제곱
 */

public class BJ_1629 {
    static int[] arr;
    static long a, b, c;
    public static void main (String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        long ans;


        ans = recur(a, b);
        System.out.println(ans);
    }

    public static long recur (long A, long exp){
        //1보다 크면
        if (exp == 1){
            return a%c;
        }
        long temp = recur(A, exp/2);

        if (exp%2 ==1){
            return (temp*temp%c)*A%c;
        }
        return temp*temp%c;
    }
}
