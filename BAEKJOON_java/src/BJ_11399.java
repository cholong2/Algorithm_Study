/**
 * start : 2023-10-21 14:00
 * end : 2023-10-21 14:05
 * 알고리즘 : 그리디, 정렬
 * 넥토 코테 전 심신안정용,,
 */
import java.io.*;
import java.util.*;

public class BJ_11399 {
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[n];

        for (int i = 0 ; i <  n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int count = 0;
        int total = 0;
        for (int t : arr){
            count+= t;
            total+=count;
        }
        System.out.println(total);
    }
}
