package Level2;
import java.util.*;
public class 요격시스템 {

    class Solution {
        public int solution(int[][] targets) {
            int answer = 0;

            Arrays.sort(targets, (o1, o2) -> {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            });

            int end = targets[0][1];
            answer++; // 첫 번째로 만들어지는 요격 시스템

            for(int[] tar : targets){
                if(tar[0] >= end){
                    end = tar[1];
                    answer++; // 시점이 요격 시스템의 상한보다 오른쪽에 있기 때문에 새로운 요격 시스템 추가
                }
            }

            return answer;
        }
    }

//내풀이
//    class Solution {
//
//        public int solution(int[][] targets) {
//            int answer = 0;
//            int[] range = new int[100000000];
//            boolean[] v = new boolean[targets.length];
//            int idx = -1;
//            int max = 0;
//            int E = 0;
//
//            for (int i = 0 ; i < targets.length ; i++){
//                int s = targets[i][0];
//                int e = targets[i][1];
//                E = Math.max(E, e);
//
//                for (int j = s ; j < e ; j++){
//                    range[j]++;
//
//                    if (idx < 0){
//                        idx = j;
//                        max = range[j];
//                    }
//
//                    if (range[idx] < range[j]){
//                        idx = j;
//                        max = range[j];
//                    }
//                }
//            }
//            int cnt = targets.length;
//
//            //다 뽀갤때까지
//            while (max>0){
//                answer++;
//                // System.out.println(cnt);
//                for (int i = 0 ; i < targets.length ; i++){
//                    //아직 안터짐 + 구간에 있다면
//                    if (!v[i] && targets[i][0] <= idx && targets[i][1] > idx)
//                    {
//                        int s = targets[i][0];
//                        int e = targets[i][1];
//                        // System.out.println("S는 "+s + " E는 " + e);
//                        cnt--;
//                        //터뜨려~
//                        for (int j = s ; j < e ; j++){
//                            range[j]--;
//                        }
//                    }
//                }
//                max = -1;
//                idx = -1;
//
//                for (int k = 0 ; k < E ; k++){
//                    if (max <= range[k]){
//                        idx = k;
//                        max = range[k];
//                    }
//                }
//
//            }
//
//
//            // System.out.println(max);
//            // System.out.println(idx);
//            // System.out.println(E);
//
//            return answer;
//        }
//    }
}
