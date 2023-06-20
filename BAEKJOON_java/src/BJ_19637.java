/*
백준 19637번 : if문 좀 대신 써줘
start : 2023-06-20 22:15
end : 2023-06-20 23:58
알고리즘 : 이진탐색
한줄평 : 너무 쉬운걸 너무 어렵게 풀려고 했음 ㅜ
 */
import java.io.*;
import java.util.*;

public class BJ_19637 {
    static String[] title;
    static int[] power;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main (String[] args) throws IOException {
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        title = new String[n];
        power = new int[n];

        for (int i = 0 ; i < n ;  i++){
            st = new StringTokenizer(bf.readLine());
            title[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0 ; i <  m ; i ++){
            long c = Long.parseLong(bf.readLine());
            search(c, 0, n-1);
        }
        System.out.println(sb.toString());
    }

    public static void search (long num, int lo, int hi){
        int mid = 0;
        while (lo <= hi){
            mid = (hi+lo)/2;
            if (power[mid] < num)
                lo = mid+1;
            else
                hi = mid-1;
        }
        sb.append(title[lo]).append('\n');
    }

    }

