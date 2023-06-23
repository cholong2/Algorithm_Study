package Level2;
//완전탐색

public class 카펫 {
    class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];

            for (int i = 1 ; i <= yellow ; i++){
                if (yellow%i == 0)
                {
                    int row = i;
                    int col = yellow/i;
                    if (row<=col){

                        if (2*(row+col)+4 == brown){
                            answer[0] = col+2;
                            answer[1] = row+2;
                            break;
                        }
                    }
                }
            }

            return answer;
        }
    }
}
