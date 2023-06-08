//세로 입력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class BJ_10798 {
    private static String result = " ";

    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        String [][] arr = new String[15][5];

        String temp = "";

        for (int i = 0; i < 5 ; i ++){
                temp = bf.readLine();

                for (int j = 0; j < temp.length() ; j++)
                {
                    arr[j][i] = String.valueOf((temp.charAt(j)));
                }
        }

        for (int i = 0; i < arr.length ; i ++)
        {
            for (int j=0 ; j < arr[i].length ; j++){
                if (arr[i][j] != null)
                sb.append(arr[i][j]);
        }
        }
        result = sb.toString();
        result  = result.replace(" ", "");

        System.out.println(result);
    }
}
