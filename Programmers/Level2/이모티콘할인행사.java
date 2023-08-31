package Level2;
import java.util.*;

/**
 * 알고리즘 : DFS
 * 넘 어려움 다시 풀어보기 터
 */
public class 이모티콘할인행사 {


    class Solution {
        int[] sales = { 10, 20, 30, 40};
        int user_len, emot_len;
        ArrayList<int[]> ans;

        public int[] solution(int[][] users, int[] emoticons) {
            ans = new ArrayList<>();
            emot_len = emoticons.length;
            user_len = users.length;
            ans.add(new int[]{0, 0});

            dfs(users, emoticons, new int[emot_len], 0);

            Collections.sort(ans, (a, b) -> b[0] == a[0] ? b[1]-a[1] : b[0] - a[0]);

            return ans.get(0);
        }
        public void dfs (int[][] u, int[] e, int[] salesInfo, int depth)
        {

            if (depth == emot_len){
                int buyCnt = 0;
                int buySum = 0;

                for (int i = 0 ; i < user_len ; i++){
                    int sum = 0;
                    for (int j = 0 ; j < emot_len ; j++){
                        if (salesInfo[j] >= u[i][0])
                            sum+= e[j]/100*(100-salesInfo[j]);
                    }
                    if (sum >= u[i][1]){
                        buyCnt++;
                    }
                    else{
                        buySum+=sum;
                    }
                }
                ans.add(new int[] {buyCnt, buySum});
                return;
            }else {
                for (int i = 0 ; i < 4 ; i++){
                    salesInfo[depth] = sales[i];
                    dfs(u, e, salesInfo, depth+1);
                }
            }
        }
    }
}
