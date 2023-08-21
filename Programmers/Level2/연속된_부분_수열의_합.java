package Level2;
/*
알고리즘 : 투포인터
전형적인 투포인터 문제라고 하네요^^ 물론 난 처음풀어봄 ㅋㅋ
 */
class 연속된_부분_수열의_합 {습
    public int[] solution(int[] sequence, int k) {
        int seq_len = sequence.length;
        int left = 0, right = seq_len;
        int sum = 0;

        for (int L = 0, R = 0 ; L < seq_len ; L++){

            while (sum < k && R < seq_len){
                sum +=sequence[R++];
            }

            if (sum == k){
                if (right-left > R-L-1)
                {
                    right = R-1;
                    left = L;
                }
            }
            sum -= sequence[L];

        }
        int[] answer = {left, right};

        return answer;
    }
}