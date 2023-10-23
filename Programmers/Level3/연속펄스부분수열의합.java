package Level3;

public class 연속펄스부분수열의합 {
    public long solution(int[] sequence) {
        long answer = 0;
        int n = sequence.length;
        int min = 1;

        int[] seq1 = new int[n]; // -1 1 -1
        int[] seq2 = new int[n]; // 1 -1 1

        for (int i = 0 ; i < n ; i++){
            seq1[i] = sequence[i]*(min);
            min *= -1;
            seq2[i] = sequence[i]*min;
        }



        long[][] dp = new long[2][n];
        dp[0][0] = seq1[0];
        dp[1][0] = seq2[0];
        answer = Math.max(dp[0][0], dp[1][0]);


        for (int i = 1 ; i < n ; i++){
            dp[0][i] = Math.max(dp[0][i-1] + seq1[i], seq1[i]);
            dp[1][i] = Math.max(dp[1][i-1] + seq2[i], seq2[i]);

            long max = Math.max(dp[0][i], dp[1][i]);
            answer = Math.max(answer, max);
        }

        return answer;
    }
}
