import java.util.*;
import java.io.*;


public class test
{
    private static int w,n, result, max;
    private static ArrayList<Integer> m = new ArrayList<>();
    private static ArrayList<Integer> p = new ArrayList<>();
    public static void main(String args[]) throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer (bf.readLine());

        w = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        result = 0;
        max = 0;
        for (int i = 0 ; i < n ; i++){
            st = new StringTokenizer (bf.readLine());
            m.add(Integer.parseInt(st.nextToken()));
            p.add(Integer.parseInt(st.nextToken()));
        }

        while (w>0){
            int max = Collections.max(p);//2 1
            int idx = p.indexOf(max);//1 0

            if (m.get(idx)<=w)
            {
                w = w-m.get(idx);//30
                result = result + max*m.get(idx);//140
            }
            else{
                result = result+ w*max;//30 *1 / 170
                w = 0;
                break;
            }

        }
        System.out.println(result);
    }
}