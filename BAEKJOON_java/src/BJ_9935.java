/**
 * 백준 9935 : 문자열 폭발
 * start : 2023.07.31 17:00
 * end : 2023.07.31 17:32
 * 알고리즘 : stack
 * @@ contains, replace로 풀려고 했는데 replace가 내부적으로 GC(garbage collection)적격 객체가 생성됨 => 메모리 초과가 난다고 함
 * 문자열 자르고 붙이고 이런건 스택으로 풀자~
 */

import java.io.*;
import java.util.Stack;

public class BJ_9935 {
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String arr = bf.readLine();
        String target = bf.readLine();
        int arr_len = arr.length();
        int target_len = target.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0 ; i < arr_len ; i++){
            int cnt = 0;
            stack.push(arr.charAt(i));

            if (stack.size() >= target_len){
                for (int j = 0 ; j < target_len ; j++){
                    if (stack.get(stack.size()-target_len+j) == target.charAt(j)){
                        cnt++;
                    }
                }
                if (cnt == target_len){
                    for (int k = 0 ; k < target_len ; k++){
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty())
            System.out.println("FRULA");
        else {
            for (char ch : stack){
                sb.append(ch);
            }
        }
        System.out.println(sb);
    }
}
