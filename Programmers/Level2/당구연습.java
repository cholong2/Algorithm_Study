package Level2;

import java.util.*;
/*
알고리즘 : 수
내가 제일 싫어하는 수~ 솔직히 이거 코테 나오면 못풀거 같음 수학이 젤 싫어 정말도
 */
class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int ball_len = balls.length;
        int[] answer = new int [ball_len];

        for (int i = 0 ; i < ball_len ; i++){
            answer[i] = cal(balls[i][0], balls[i][1], startX, startY, m, n);
        }



        return answer;

    }
    public int cal (int targetX, int targetY, int startX, int startY, int m, int n){
        int up = pow(startX-targetX) + pow(2*n-startY-targetY);
        int down= pow(startX-targetX) + pow(targetY + startY);
        int left= pow(targetX+startX) + pow(startY-targetY);
        int right = pow(2*m-targetX-startX) +pow(startY - targetY);

        if (startY == targetY)
        {
            if(startX>targetX){
                return get_min(up, down, right);
            }
            else {
                //오른쪽 안됨
                return get_min(up, down, left);
            }
        }
        else if (startX == targetX){
            if (startY > targetY){
                //아래 안됨
                return get_min(up, right, left);
            }
            else {
                //위 안됨
                return get_min(right, down, left);
            }
        }
        else {
            return get_min(right, down, left, up);
        }

    }
    public int get_min(int ...num){
        int min = Integer.MAX_VALUE;
        for (int n : num) {
            min = Math.min(min, n);
        }
        return min;
    }
    public int pow(int num) {
        return (int) Math.pow(num, 2);
    }
}