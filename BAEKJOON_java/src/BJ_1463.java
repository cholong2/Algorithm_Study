/**
 * start : 2023-10-20 15:11
 * end : 2023-10-20 15 16:20
 * 알고리즘 : DP, 수
 * dp와 수에 약한 나 무너져버린,,
 * 앞에서 부터 그냥 dp[i] = math.min(dp[i], dp[i/2]+1) 일케 하면 되는거슬,,,
 * 굳이굳이 뒤에서부터 ,,,
 */

import java.util.*;
import java.io.*;

public class BJ_1463 {

    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n+1];
//        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[n] = 0;

//        10 9 8 7 6 5 4 3 2 1
//         0 1 2 3 4 5 6 7 8 9

        for (int i = n ; i >=1 ; i--){
            arr[i] = n-i;
        }

        for (int i = n ; i >= 1 ; i--) {
            if (i % 2 == 0) {
                arr[i / 2] = Math.min(arr[i / 2], arr[i] + 1);
                arr[i / 2] = Math.min(arr[i / 2 + 1] + 1, arr[i / 2]);
            }
            if (i % 3 == 0) {
                arr[i / 3] = Math.min(arr[i / 3], arr[i] + 1);
                arr[i / 3] = Math.min(arr[i / 3 + 1] + 1, arr[i / 3]);
            }
        }


        System.out.println(arr[1]);
    }


}
