import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 1913번: 달팽이 (구현과 시뮬레이션)
start: 2023-05-02 16:19
end: 2023-05-02 18:13
 */
public class BJ_1913 {

    private static int n, m, x, y, s;
    private static int[][] board;
    private static int[] loc = new int[2];
    private static boolean dir = true;
    public static void main (String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        n = Integer.parseInt(bf.readLine());
        m = Integer.parseInt(bf.readLine());
        board = new int[n][n];

        s = (int) Math.pow(n,2);
        x = 0;
        y = 0;
        /*
        x=5
        y=4
         */
        for (int j = n ; j > 0 ; j--)
        {
            if (j == n){
                for (x = 0 ; x < n ; x++) {
                    board[x][y] = s;
                    s--;
                }
                x--;
                y++;
            }
            else{
                if (dir)
                {
                    int i; //i==1
                    for (i = y; i < y+j ; i++){
                        board[x][i]=s;
                        s--;
                    }
                    y = i-1; //y==6
                    for (i = x-1 ; i >= x-j ; i--)
                    {
                        board[i][y] = s;
                        s--;
                    }
                    y--;
                    x = i+1;
                    dir = !dir; //false
                }
                else
                {
                    int i;
                    for (i = y ; i> y-j ; i--){
                        board[x][i] = s;
                        s--;
                    }
                    y = i+1;
                    for (i = x+1 ; i <=x+j; i++){
                        board[i][y] = s;
                        s--;
                    }
                    y++;
                    x = i-1;
                    dir = !dir; //true
                }
            }
        }

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == m)
                {
                    loc[0] = i+1;
                    loc[1] = j+1;
                }
                sb.append(board[i][j]+" ");
            }
            sb.append("\n");
        }
        sb.append(loc[0]+" "+loc[1]);
        System.out.println(sb);
    }
}
