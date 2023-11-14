/**
 * 백준 1644번 : 소수의 연속합
 * start : 2023-11-14 16:53
 * end : 2023-11-14
 * 알고리즘 : DP
 * 한줄평 :
 * 1~n까지 에라토스테네츠 어쩌고 그거로 소수 판별하고? 그중에서 n을 만들 수 있는 연속합 찾기
 * 이분탐색? 으로
 */

import java.io.*;
import java.util.*;

public class BJ_1644 {
    static int n;
    static ArrayList<Integer> prime = new ArrayList<>();
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        for (int i = 2 ; i <= n ; i++){
            if (isPrime(i)){
                prime.add(i);
            }
        }
        int size = prime.size();
        prime.add(0);
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
                sum+=prime.get(e);
                e++;
            }
            else {
                sum-=prime.get(s);
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
