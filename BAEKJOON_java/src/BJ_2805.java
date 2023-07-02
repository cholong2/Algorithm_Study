/*
백준 2805번 : 나무 자르기
start : 2023-06-27 11:30
end :  2023-06-27 17:12
알고리즘 : 이진탐색
한줄 평 : 이진탐색은 시간초과,, 근데 이진탐색이 맞아써 ?!
 */
import java.util.*;
import java.io.*;

public class BJ_2805 {
    static int n, m, ans;
    static int[] arr;
    public static void main (String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer (bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        int max = 0;

        st = new StringTokenizer(bf.readLine());

        for (int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i]>=max) {
                max = arr[i];
            }
        }

        long l = 0;
        long r = max;

        while (l<=r){
            long mid = (r+l)/2;

            long temp = 0;

            for (int i = 0 ; i < n ; i ++){
                if (arr[i]-mid>0){
                    temp+=(arr[i]-mid);
                }
            }
            //여기 == 표시 안해서 틀림왜지
            // long으로 바꾸니까 시간초과 안남
            if (m <= temp){
                l = mid+1;
            }
            else
                r = mid-1;
        }

        System.out.println(r);
    }

}
