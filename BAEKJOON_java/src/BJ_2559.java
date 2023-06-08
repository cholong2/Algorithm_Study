/*
백준: 2559 수열
start: 2023-06-01 17:02
end: 2023-06-01 17:40
 */

import java.io.*;
import java.util.StringTokenizer;

public class BJ_2559 {
    private static int n,k, max, temp;
    private static int[] arr=null;
    private static String[] arr1=null;
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];

        arr1 = bf.readLine().split(" ");
        for (int i = 0 ; i < n; i++)
            arr[i] = Integer.parseInt(arr1[i]);

        max=Integer.MIN_VALUE;

        for (int i = 0 ; i < n-k+1 ; i++)
        {
            temp = 0;
            for (int j = i ; j < i+k ; j++)
            {
                temp +=arr[j];
            }
            if (temp>max)
                max = temp;
        }

        System.out.println(max);
    }
}
