import java.io.*;
import java.util.*;

/**
 * start : 2023-09-05 17:08
 * end : 2023-09-05 17:58
 * 알고리즘 : 수학, 이분탐색
 */

public class BJ_2512 {
    static int n = 0, tot = 0, max = 0;
    static int[] arr;


    public static void main (String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr = new int[n];
        int avg = 0;
        int sum = 0;
        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
            sum+=arr[i];
        }
        avg = sum/arr.length;
//        System.out.println(avg);

        tot = Integer.parseInt(bf.readLine());


        //만약 총합이 예산보다 작거나 같다면 상한액 안정해도 되니까 ㄱㅊ
        if (sum <= tot){
            System.out.println(max);
            return;
        }

        //그게 아니면 상한액을 정해야겠지..?
        //정렬을 해? 이거 냅색 같은데 어케 풀었더라 그리디..?
        //정렬하고 총합을 갯수로 나눈거보다 커지면 상한액 정하기
        //상한액은 지금까지 나온애들에서 총예산 빼고 남은 금액을 다음 남은 애들 수만큼 나누기
        Arrays.sort(arr);
        int cal = 0;
        for (int i = 0 ; i < n ; i++) {
            if (arr[i]>(tot-cal)/(n-i))
            {
//                System.out.println(tot-cal);
                int rem = (tot-cal)/(n-i);
                max = rem;
                System.out.println(max);
                return;
            }
            else {
                cal += arr[i];
//                System.out.println(cal);
            }

        }
    }
}
