/*
백준 : 1107번 리모컨
알고리즘 : 브루트포스
문제 : 수빈이는 TV를 보고 있다. 수빈이는 채널을 돌리려고 했지만, 버튼을 너무 세게 누르는 바람에, 일부 숫자 버튼이 고장났다.
리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다. +를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, -를 누르면 -1된 채널로 이동한다. 채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.
수빈이가 지금 이동하려고 하는 채널은 N이다. 어떤 버튼이 고장났는지 주어졌을 때, 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오.
수빈이가 지금 보고 있는 채널은 100번이다.
입력 : 0<= n <= 500,000 /0<=  m <= 10
시간 : 1초
start : 2023-06-05 15:23
end : 2023-06-05 16:30
 */
//https://moonsbeen.tistory.com/64
import java.io.*;
import java.util.*;
public class BJ_1107 {
    static int n, m, s, min;
    static boolean[] v= new boolean[10];
    static String arr;

    public static void main (String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        m = Integer.parseInt(st.nextToken());
        s = 100;

        arr= bf.readLine();
        st = new StringTokenizer(arr);

        for (int i = 0 ; i < m ; i++) {
            int num = Integer.parseInt(st.nextToken());
            v[num] = true;
        }

        min = Math.abs(n - s);

        if (min==0)
            System.out.println(0);
        else{
            for (int i = 0 ; i < 999999 ; i++){
                String str = String.valueOf(i);
                int len = str.length();

                boolean isBreak = false;
                for (int j = 0 ; j < len ; j++){
                    if (v[str.charAt(j)-'0']){
                        isBreak = true;
                        break;
                    }
                }
                if (!isBreak){
                    min = Math.min(min, Math.abs(n-i)+len);
                }

            }
            System.out.println(min);
        }

    }
}






















