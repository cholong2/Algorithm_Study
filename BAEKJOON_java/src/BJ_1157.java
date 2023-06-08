/*
백준 1157번: 단어 공부
start : 2023-06-08 16:08
end : 2023-06-08 16:56
 */

import java.io.*;
import java.util.*;

public class BJ_1157 {
    static Character[] arr;
    static String s;
    static char result;
    static int[] cnt;
    static int num = 0;

    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        s = st.nextToken();
        s = s.toUpperCase();
        arr = new Character[s.length()];
        cnt = new int[s.length()];


        for (int i = 0 ; i < s.length() ; i++){
            if(Arrays.asList(arr).contains(s.charAt(i)))//포함되어 있ㅇ르떄
                {
                    int tmp = Arrays.asList(arr).indexOf(s.charAt(i));
                    cnt[tmp]++;

                }
            else {//포함되지 않을때
                arr[num] = s.charAt(i);
                cnt[num]++;
                num++;
            }
        }


       result = max();
        System.out.println(result);

    }
    public static Character max (){
        int max = -1;
        int tmp = 0;
        int idx = 0;
        int[] copy = cnt.clone();

        for (int i = 0 ; i < num ; i++)
            max = Math.max(max, copy[i]);

        for (int i = 0 ; i < num ; i++){
            if (cnt[i] == max) {
                tmp++;
                idx = i;
            }

        }
        if (tmp>1)
            return '?';

        else
            return arr[idx];

    }

}
