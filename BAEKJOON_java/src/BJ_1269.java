/*
백준 1269번 : 대칭 차집합
start : 2023-06-27 17:13
end : 2023-06-27 17:37
알고리즘 : 해시셋
한줄평 : Arraylist를 이용해서 풀었는데 시간초과
-> Arrayslist는 순서와 값을 함께 저장하고 탐색해서 시간이 오래 걸림
-> set은 값만 저장하는데 중복X 순서가 보장되지 않아서 훨씬 빠름
 */
import java.io.*;
import java.util.*;

public class BJ_1269 {
    static int n, m;
    static HashSet<Integer> set = new HashSet<>();

    public static void main (String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int cnt = 0;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        for (int i = 0 ; i < n ; i++){

            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0 ; i < m ; i++){
            int temp = Integer.parseInt(st.nextToken());
            if (set.contains(temp)){
                cnt++;
            }else{
                set.add(temp);
            }
        }

        System.out.println(n+m-2*cnt);

    }
}
