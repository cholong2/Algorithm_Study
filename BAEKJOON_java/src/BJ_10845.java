/*
백준 10845번: 큐
start : 2023-05-03 16:16
end : 2023-05-03 16:41
 */

import java.io.*;
import java.util.*;

public class BJ_10845 {

    public static int n;
    public static String com;
    public static int m;
    public static Deque<Integer> q = new LinkedList<>();
    public static void main (String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        n = Integer.parseInt(bf.readLine());

        for (int i = 0 ; i < n ; i ++){
            st = new StringTokenizer(bf.readLine());
            com = st.nextToken();


            switch (com) {
                case "push" :
                    m = Integer.parseInt(st.nextToken());
                    q.add(m);
                    break;
                case "front":
                    if (q.peek()!=null){
                        sb.append(q.peek());
                    }
                    else
                        sb.append(-1);

                    sb.append("\n");
                    break;

                case "back":
                    if (q.peekLast()!=null){
                        sb.append(q.peekLast());
                    }
                    else
                        sb.append(-1);

                    sb.append("\n");
                    break;
                case "pop":
                    if (q.peek()!=null)
                        sb.append(q.poll());
                    else
                        sb.append(-1);

                    sb.append("\n");
                    break;

                case "size":
                    sb.append(q.size());
                    sb.append("\n");
                    break;

                case "empty":
                    if (q.isEmpty())
                        sb.append(1);
                    else
                        sb.append(0);

                    sb.append("\n");
                    break;
            }

        }
        System.out.println(sb);
    }
}
