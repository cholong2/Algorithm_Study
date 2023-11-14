/**
 * 백준 1644번 : 소수의 연속합
 * start : 2023-11-14 16:53
 * end : 2023-11-14
 * 알고리즘 : 투포인터, 소수
 * 한줄평 :
 * 1~n까지 에라토스테네츠 어쩌고 그거로 소수 판별하고? 그중에서 n을 만들 수 있는 연속합 찾기
 * 이분탐색?이 아니라 투포인터
 * 에라토스테네츠의 채? 소수인지 찾고 내가 소수라면 배수들 모두 쳐내기
 * 훠어어어ㅓㅇㄹ씬 빠름여
 *
 */

import java.io.*;
import java.util.*;

public class BJ_1644 {
    static int n;
   static ArrayList<Integer> primeArr = new ArrayList<>();
    public static boolean[] prime;
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        prime = new boolean[n+1];
        Arrays.fill(prime, true);
        for (int i = 2 ; i*i <=n ; i++){
            for (int j = i*2 ; j <= n ; j+=i){
                if (prime[j]){
                    prime[j] = false;
                }
            }
        }
        for (int i = 2 ; i <= n ; i++){
            if (prime[i]){
                primeArr.add(i);
            }
        }
        int size = primeArr.size();
        primeArr.add(0);
        int s = 0;
        int e = 0;
        int sum = 0;
        int cnt = 0;


//        for (int s = 0 ; s < prime.size() ; s++){
//            while (sum<n && e<prime.size()){
//                sum+=prime.get(e);
//                e++;
//            }
//            if (sum == n){
//                cnt++;
//            }
//            sum-=prime.get(s);
//        }

        while (e <= size && s <= size){
            if (sum<n){
                sum+=primeArr.get(e);
                e++;
            }
            else {
                sum-=primeArr.get(s);
                s++;
            }
            if (sum==n) cnt++;
        }
        System.out.println(cnt);
    }
    public static boolean isPrime(int num){

        for (int i = 2 ; i <= Math.sqrt(num) ; i++){
            if (num%i == 0) return false;
        }
        return true;
    }
}
