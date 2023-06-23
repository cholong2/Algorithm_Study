package Level2;

// dfs
// 예외에 걸리지 않고 좋게 마무리 될 때도 처리를 해줘야하는데 안했음 ^^ 바ㅜ바붑~
public class 피로도 {
    class Solution {
        boolean[] v;
        int answer = -1;

        public int solution(int k, int[][] dungeons) {
            v = new boolean [dungeons.length];
            dfs(k, 0, dungeons);

            if (answer <= 0)
                answer =  0;

            return answer;
        }
    /*
    방문하지 않고
    k가 최소 피로도보다 높으면
    -> 방문, k = k-소모량

    */

        public void dfs(int k, int cnt, int[][] dungeons){
            if (dungeons.length == cnt){
                answer = cnt;
                return;
            }

            for (int i = 0 ; i < dungeons.length ; i++){
                if (!v[i] && dungeons[i][0] <= k)
                {
                    int check = k-dungeons[i][1];
                    System.out.println(check);
                    if (check < 0){
                        answer = Math.max(cnt, answer);
                        return;
                    }
                    else {
                        v[i] = true;
                        dfs(check, cnt+1, dungeons);
                        v[i] = false;
                    }
                }
            }
            answer= Math.max(cnt, answer);
        }
    }
}
