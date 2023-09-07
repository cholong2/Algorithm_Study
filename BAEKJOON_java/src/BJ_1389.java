import java.io.*;
import java.util.*;

/**
 * start : 2023-09-07 16:36
 * end : 2023-09-07 17:00
 * 알고리즘 : 플로이드워셜
 */
public class BJ_1389 {
    static int n, m;

    public static void main (String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        ArrayList<ArrayList<Integer>> f = new ArrayList<>();


        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;
        int answer = 0;

        for (int i = 0 ; i <= n ; i++)
           f.add(new ArrayList<>());

        for (int i = 0 ; i < m ; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            f.get(a).add(b);
            f.get(b).add(a);
        }

        //1부터 베이컨씨 찾기
        for (int i = 1 ; i <= n ; i++){
            boolean[] v = new boolean[n+1];
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{i, 1});
            int cnt = 0;
            v[i] = true;
            while (!q.isEmpty()){
                int[] me = q.poll();

                for (int link : f.get(me[0])){
                    if (!v[link]){
                        v[link] = true;
                        q.add(new int[] {link, me[1]+1});
                        cnt+=me[1];
                    }
                }

            }
//            System.out.println(i+ "번 베이컨" + cnt);
            if (min > cnt){
                min = cnt;
                answer = i;
            }
        }

        System.out.println(answer);
    }
}
