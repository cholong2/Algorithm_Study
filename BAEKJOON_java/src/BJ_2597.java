/*
백준 2597번 : 줄자접기
알고리즘 : 구현
start : 2023-06-14 23:19
end : 2023-06-15 01:27
 */

import java.io.*;
import java.util.*;

public class BJ_2597 {
    static int n;

    static double answer, l, r, m =0;
    static double[][] ru = new double[3][2];
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());

        for (int i = 0 ; i < 3 ; i++){
            st = new StringTokenizer(bf.readLine());
            int x, y;
            ru[i][0] = Integer.parseInt(st.nextToken());
            ru[i][1] = Integer.parseInt(st.nextToken());
        }

        r = n;
        l = 0;
        answer = r-l;

        for (int i = 0 ; i < 3 ; i++){
            if (ru[i][0] == ru[i][1])
                continue;

            m = (l + r) / 2;
            double temp = (ru[i][0] + ru[i][1])/2;

            if (temp < m) {
                l = temp;
                for (int j = i + 1; j < 3; j++) {
                    for (int k = 0 ; k < 2 ; k++){
                     if (ru[j][k] < temp)
                    {
                        ru[j][k] = temp + Math.abs(temp - ru[j][k]);
                    }
                    }
                }
            }
            else {
                r = temp;
                for (int j = i + 1; j < 3; j++) {
                    for (int k = 0 ; k < 2 ; k++){
                        if (ru[j][k] > temp)
                        {
                            ru[j][k] = temp - Math.abs(temp - ru[j][k]);
                        }
                    }
                }
            }


            answer = r - l;

        }
        String a = String.format("%.1f", answer);
        System.out.println(a);
    }
}
