/*
백준 - 숨바꼭질3 13549
Start : 23.04.25-16:40
End : 23.04.18:55
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_13549 {

    static int n, k, x, temp = 0;
    static int[] check;
    static Deque<Integer> q = new LinkedList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        check = new int[100001];
        Arrays.fill(check, -1);
        x = n;
        q.add(n);
        check[n] = 0;


        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp == k) {
                break;
            }
            if (temp * 2 <= 100000 && check[temp * 2] < 0) {
                q.addFirst(temp * 2);
                check[temp * 2] = check[temp];
            }
            if (temp + 1 <= 100000 && check[temp + 1] < 0) {
                check[temp + 1] = check[temp] + 1;
                q.addLast(temp + 1);
            }

            if (temp - 1 >= 0 && check[temp - 1] < 0) {
                check[temp - 1] = check[temp] + 1;
                q.addLast(temp - 1);
                // System.out.println("이프문3"+ q.size());
            }

        }
        System.out.println(check[k]);

}
}
