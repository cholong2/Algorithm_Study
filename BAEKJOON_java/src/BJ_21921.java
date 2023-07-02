/*
백준 21921번 : 블로그
start : 2023-06-21 14:56
end : 2023-06-21 15:26
알고리즘 : 누적합, 슬라이딩 윈도우
한줄평 :
 */
import java.io.*;
import java.util.*;

public class BJ_21921 {
    static int n, x, max, cnt;
    static int[] arr;

    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        max = Integer.MIN_VALUE;
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new int[n];
        cnt = 0;
        st = new StringTokenizer(bf.readLine());

        for (int i = 0 ; i < n ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int temp = 0;

        for (int i = 0 ; i <= n-x ; i++){
            if (i == 0)
            {
                for (int j = 0; j < x ; j++)
                    temp+=arr[j];
                max = temp;
                cnt++;

            }
            else {
                temp = temp - arr[i - 1] + arr[i + x-1];

                if (max < temp) {
                    max = temp;
                    cnt = 1;

                } else if (max == temp)
                    cnt++;
            }
        }

        if (max == 0)
            System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(cnt);
        }

    }
}
