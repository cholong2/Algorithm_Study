/*
백준 5568번 : 카드 놓기
start : 2023-06-29 16:45
end : 2023-06-29 17:05
알고리즘 : 해시셋
한줄평 : 컷 ㅋ
 */
import java.io.*;
import java.util.*;

public class BJ_5568 {
    static int n, k, ans;
    static String[] arr;
    static Set <Integer> hm = new HashSet<>();
    static boolean[] v;
    public static void main (String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        v = new boolean[n];
        k = Integer.parseInt(bf.readLine());
        arr = new String[n];

        for (int i = 0 ; i < n ; i++){
         arr[i] = bf.readLine();
        }
        for (int i = 0 ; i < n ; i++) {
            if (!v[i]) {
                v[i] = true;
                check(arr[i], 1);
                v[i] = false;
            }
        }
        System.out.println(hm.size());
    }
    public static void check (String temp, int depth){

        if (depth == k) {
            int num = Integer.parseInt(temp);
            hm.add(num);
            return;
        }

        for (int i = 0 ; i < n ; i++){
            if (!v[i]){
                v[i] = true;
                check(temp+arr[i], depth+1);
                v[i] = false;
            }
        }
    }
}
