import java.io.BufferedReader;

/*
백준 : 15650번 N과 M(2)
알고리즘 : 백트래킹
뮨제 : 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
- 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
- 고른 수열은 오름차순이어야 한다.
입력 : 1 <= m <= n 8
시간 : 1초
start : 2023-06-04 17:00
end : 2023-06-04 17:23
 */
import java.io.*;
import java.util.*;

public class BJ_15650 {
    static int n, m, depth =0;
    static boolean[] v;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void dfs (int depth, int start) {
        if (depth == m){
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append('\n');
            return;
        }
        for (int i = start ; i < n ; i++){
            if ( !v[i] ) {
                arr[depth] = i + 1;
                v[i] = true;
                dfs(depth + 1, i+1);
                v[i] = false;
            }
        }
    }
    public static void main (String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    v = new boolean[n];
    arr = new int[m];

    dfs (depth , 0);
    System.out.println(sb.toString());
    }
}
