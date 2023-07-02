/*
백준 14888번 : 연산자 끼워넣기
start : 2023-07-02 00:04
end : 2023-07-02 14:43
알고리즘 : 백트래킹
한줄평 : dp랑 브루트포스랑 구분을 잘 해보자
dp는 이전값을 저장해놓고 다음에 쓸 수 있을때 사용
브루트포스 - 백트래킹 : 계속 탐색할 수 있으면 탐색, 조건에 막히면 탐색종료
 */

import java.io.*;
import java.util.*;
public class BJ_14888 {
    static int n;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] num, sign;
    static boolean[] v;

    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        num = new int[n];
        sign = new int[n-1];
        v = new boolean[n-1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0 ; i < n ; i++)
            num[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int sidx = 0;
        for (int i = 0 ; i < 4 ; i++){
            int temp = Integer.parseInt(st.nextToken());
            for (int j = 0 ; j < temp ; j++){
                sign[sidx] = i;
                sidx++;
            }
        }

        for (int i =0 ; i < n-1 ; i++){
            if (!v[i]){
                //부호가 같으면 패스
                if (i>0 && sign[i] == sign[i-1])
                    continue;

                v[i] = true;
                int res = cal(num[0], num[1], sign[i]);
                search(2, res);
                v[i] = false;
            }
        }

        System.out.println(max);
        System.out.println(min);
    }

    public static void search (int depth, int res) {
        if (depth == n){
            max = Math.max(max, res);
            min = Math.min(min, res);
            return;
        }

        for (int i = 0 ; i < n-1 ; i++){
            if (!v[i]){
                v[i] = true;
                int value = cal(res, num[depth], sign[i]);
                search(depth+1, value);
                v[i] = false;
            }
        }
    }

    public static int cal (int a, int b, int s){
        if (s == 0)
            return a+b;

        else if (s == 1)
            return a-b;

        else if (s == 2)
            return a*b;

        else
            return a/b;
    }
}
