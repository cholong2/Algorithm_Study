/**
 * start : 2023-10-19 15:14
 * end : 2023-10-19 16:40
 * 알고리즘 : 백트래킹?
 * 퀸을 보드를 돌면서 두는 식으로 접근했는데 이렇게 하면 뒀던 곳에 또 다른 퀸을 둘 수 있고 머 그럼 퀸은 다 같으니까 중복됨여
 * 한 행 or 한 열에는 퀸을 하나밖에 못두는 걸 활용해서 첨부터 끝까지가 아닌 한 행이나 한 열만 도는식으로 하면 된다!
 * 대각선 판별 쉽게 하는 방법
 * math.abs(행-행) == math.abs(열-열)을 이용하면 된다 ~
 */
import java.io.*;
import java.util.*;

public class BJ_9663 {
    static int n, cnt;
    static int[] arr;

    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        nQ(0);
        System.out.println(cnt);
    }
    public static void nQ(int q){
        if (q == n){
            cnt++;
            return;
        }

        for (int i = 0 ; i < n ; i++){
            arr[q] = i;
            if (check(q)){
                nQ(q+1);
            }
        }
    }
    public static boolean check(int col){
        for (int i = 0 ; i < col ; i++){
            if (arr[col] == arr[i]){
                return false;
            }

            else if (Math.abs(col-i) == Math.abs(arr[col]-arr[i])){
                return false;
            }
        }

        return true;

    }
}
