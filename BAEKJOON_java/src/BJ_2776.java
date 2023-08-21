import java.io.*;
import java.util.*;

public class BJ_2776 {
    public static void main (String[] args)throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(bf.readLine());

        for (int i = 0 ; i < test ;i++) {
            Set <Integer> set = new HashSet<>();
            int n = Integer.parseInt(bf.readLine());
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < n; j++) {
                set.add(Integer.parseInt(st.nextToken()));
            }

            int m = Integer.parseInt(bf.readLine());

            st = new StringTokenizer(bf.readLine());
            for (int j = 0 ; j< m ; j++)
                sb.append(set.contains(Integer.parseInt(st.nextToken()))? 1 : 0).append("\n");

            System.out.print(sb);
        }

    }
}
