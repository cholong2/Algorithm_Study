/*
알고리즘 : DFS
그냥 -+로 둘다 DFS돌리면 되지롱
 */
package Level2;

class 타겟넘버 {
    int answer = 0;
    public int solution(int[] numbers, int target) {

        dfs(0, numbers, target, 0);
        return answer;
    }
    public void dfs (int idx, int[] numbers, int target, int sum){
        if (idx == numbers.length )
        {
            if (sum==target)
                answer++;
        }
        else {
            dfs(idx+1, numbers, target, sum+numbers[idx]);
            dfs(idx+1, numbers, target, sum-numbers[idx]);
        }

    }
}
