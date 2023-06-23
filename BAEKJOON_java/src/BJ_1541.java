/*
백준 1541번 : 잃어버린 괄호
start : 2023-06-22 15:34
end : 2023-06-22 17:09
알고리즘 : 수학, 문자열, 그리디 알고리즘, 파싱
한줄평 : 잃어버린 내 1시간 반~
 */
import java.io.*;
import java.util.*;

public class BJ_1541 {
    static String[] input;

    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // + 앞에 -가 있으면 +먼저하기
        String temp = bf.readLine();

        input = temp.split("-");


        for (int i = 0; i < input.length; i++) {
            int t = 0;
            String num[] = input[i].split("\\+");
            for (int j = 0; j < num.length; j++) {
                t += Integer.parseInt(num[j]);
            }

            if (ans == Integer.MAX_VALUE)
                ans = t;
            else
                ans -= t;
        }
        System.out.println(ans);
    }
}



