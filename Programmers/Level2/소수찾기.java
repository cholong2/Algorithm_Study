package Level2;
import java.util.*;
//dfs, 소수판별
public class 소수찾기 {

    class Solution {
        HashSet <Integer> hs = new HashSet<>();
        boolean v[] = new boolean[7];
        String[] arr;

        public int solution(String numbers) {
            int answer = 0;
            arr = new String[numbers.length()];
            arr = numbers.split("");


            dfs("", 0);

            answer = hs.size();
            return answer;
        }
        public void dfs (String temp, int depth){
            if (temp!=""){
                int num = Integer.parseInt(temp);
                if (check(num)) hs.add(num);
            }
            if (depth == arr.length) return;

            for (int i = 0 ; i < arr.length ; i++){
                if (!v[i]){
                    v[i] =true;
                    dfs(temp+arr[i], depth+1);
                    v[i]=false;
                }
            }

        }
        public boolean check (int num){
            if (num<2)
                return false;
            for (int i = 2 ; i*i<=num ; i++){
                if (num%i == 0)
                    return false;
            }
            return true;
        }

    }
}
