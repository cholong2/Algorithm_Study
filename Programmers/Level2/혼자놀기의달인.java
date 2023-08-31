package Level2;

/**
 * 알고리즘 : DFS
 */

import java.util.*;

class 혼자놀기의달인 {
    boolean[] v;
    ArrayList<Integer> arr = new ArrayList<>();
    public int solution(int[] cards) {
        int answer = 0;
        int card_len = cards.length;
        v = new boolean [cards.length];
        //인접한 그래프 찾기 그냥 Arraylist로 넣어서 최댓값만 차자

        for (int i = 0 ; i < cards.length ; i++)
        {
            if (!v[i])
                dfs (cards, i, 1);
        }
        Collections.sort(arr, Collections.reverseOrder());

        if(arr.size()==1)
            answer = 0;
        else
            answer = arr.get(0)*arr.get(1);
        return answer;
    }
    public void dfs (int[] cards, int idx, int cnt){
        if (v[idx]){
            //Arraylist에 넣기
            arr.add(cnt-1);
            return;
        }
        else {
            v[idx] = true;
            dfs(cards, cards[idx]-1, cnt+1);

        }
    }
}
