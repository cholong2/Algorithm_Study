package Level2;

/**
 * start : 2023-08-30 14:40
 * end : 2023-08-30 15:40
 * Algorithm : DFS
 */

import java.util.*;

class 광물캐기 {
    int n = 0;
    int[] num;
    int[] min_conv;
    int[][] somo = {{1, 1, 1},
            {5, 1, 1} ,
            {25, 5, 1}};
    int min = Integer.MAX_VALUE;

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        n = minerals.length;
        min_conv = new int[n];
        int temp = 0;


        for (int i = 0 ; i < n ; i++){
            if (minerals[i].equals("diamond")){
                min_conv[i] = 0;
            }
            else if (minerals[i].equals("iron")){
                min_conv[i] = 1;
            }
            else if (minerals[i].equals("stone")){
                min_conv[i] = 2;
            }
        }

        for (int i = 0 ; i < 3 ; i++)
            temp += picks[i];

        if (n%5 !=0)
            n = n/5+1;
        else n /=5;

        if (temp < n)
            n = temp;

        num = new int[n];
        // System.out.println(n);

        //순열뽑고 그 중에서 최솟값 찾기

        dfs(0, picks, min_conv);

        return min;
    }
    public void dfs (int cnt, int[] picks, int[] min_conv){
        if (cnt == n){
            //arr에 있는거 다 피로도 계산하기
            int idx = 0;
            int sum = 0;
            for (int i = 0 ; i < min_conv.length ; i++){
                if (i%5==0 && i>0)
                    idx++;
                if (idx == cnt)
                    break;


                sum+=somo[num[idx]][min_conv[i]];

            }

            min = Math.min(min, sum);
            // System.out.println(min);
            return;
        }

        for (int i = 0 ; i < 3 ; i++){
            if (picks[i] > 0)
            {
                num[cnt] = i;
                picks[i]--;
                dfs(cnt+1, picks, min_conv);
                picks[i]++;
            }
        }

    }
//     public void cal(ArrayList arr, minerals){
//         for (int mine : arr){

//         }
//     }
}