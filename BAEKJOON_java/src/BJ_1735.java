/*
백준 1735번: 분수 합
start: 2023-06-10 20:09
end: 2023-06-10 20:34
알고리즘 : 정수론, 유클리드 호제법, 최대공약수 구하기
최대공약수는 a>b일때 (a, b)최대공약수 == (b, a%b) 최대공약수
 */

import java.io.*;
import java.util.*;
public class BJ_1735 {
    static int[][] arr = new int[2][2];
    static int a, b, r;
    static int ra, rb;
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0 ; i< 2 ; i++){
            st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        b = arr[0][1] * arr[1][1];
        a = (arr[0][1] * arr[1][0]) + (arr[1][1]*arr[0][0]);

        r = gcd(b, a);

        int ra = a/r;
        int rb = b/r;

        System.out.println(ra+" "+rb);

    }
    public static int gcd(int n, int m){
        if (m == 0)
            return n;
        else
            return gcd(m, n%m);
    }
}
