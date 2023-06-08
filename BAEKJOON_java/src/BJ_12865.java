import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12865 {
    private static int n, max, w, v, result[][];

    public static void main (String[] args) throws IOException{
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuffer sb = new StringBuffer();
        n = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(st.nextToken());

        int [][] arr = new int[n+1][2];

        for (int i = 1 ; i < n+1 ; i++) {
            String[] temp = bf.readLine().split(" ");
            arr[i][0] = Integer.parseInt(temp[0]);
            arr[i][1] = Integer.parseInt(temp[1]);
        }

        result = new int[n+1][max+1];

        for (int i = 1 ; i < n+1 ; i++){
            for (int j = 1 ; j<max+1 ; j++){
                result[i][j] = result[i-1][j];
                if (arr[i][0] <= j)
                {
                    result[i][j] = Math.max(result[i-1][j-arr[i][0]] + arr[i][1], result[i][j]);
                }
            }

        }



        System.out.println(result[n][max]);
    }
}
