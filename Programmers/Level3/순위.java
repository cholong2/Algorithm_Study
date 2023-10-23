package Level3;
//플로이드 와샬
public class 순위 {

    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] floyd = new int[n+1][n+1];

        for (int i = 0 ; i < results.length ; i++){
            int a = results[i][0];
            int b = results[i][1];

            floyd[a][b] = 1;
            floyd[b][a] = -1;
        }

        for (int i = 1 ; i <= n ; i++){//출발지

            for (int j = 1 ; j <= n ; j++){//도착지
                if (i==j) continue;
                for (int k = 1 ; k <=n ; k++){//경유 노드
                    if (i == k) continue;
                    if (floyd[i][k] == 1 && floyd[k][j] == 1){
                        floyd[i][j] = 1;
                        floyd[j][i] = -1;
                    }
                    if (floyd[i][k] == -1 && floyd[k][j] == -1){
                        floyd[i][j] = -1;
                        floyd[j][i] = 1;
                    }
                }
            }
        }

        for (int i = 1 ; i<=n ; i++){
            int cnt = 0;

            for (int j = 1 ; j <=n ; j++){
                if (floyd[i][j] != 0) cnt++;
            }

            if (cnt==n-1) answer++;
        }

        for (int i = 1 ; i <= n ; i++){
            for (int j = 1 ; j <= n ; j++){
                System.out.print(floyd[i][j]+" ");
            }
            System.out.println();
        }
        return answer;
    }
}
