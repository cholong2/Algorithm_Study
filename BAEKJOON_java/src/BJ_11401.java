/*
백준 11401번: 이항 계수3
start : 2023-04-26 14:00
end : 2023-04-26 16:18
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11401 {

        public static int n, k, r;
        public static int[][] arr;
        final static long P = 1000000007;


        public static void main (String args[]) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            long N = fact(n);
            long K = fact(k) * fact (n-k) % P;

            System.out.println(N*pow(K, P-2)%P);


        }

        public static long fact (long n){
            long fac = 1L;
            while (n>1){
                fac = (fac*n)%P;
                n--;
            }
            return fac;
        }

        public static long pow (long base, long expo){
            if (expo == 1){
                return base % P;
            }
            long temp = pow(base, expo/2);
            if (expo%2 ==1){
                return (temp*temp%P)*base %P;
            }

            return temp * temp % P;
        }

}
