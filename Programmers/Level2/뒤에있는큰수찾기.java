package Level2;

import java.util.*;
/**
 start: 2023-08-07 14:45
 end : 2023-08-07 14:45
 알고리즘 :  stack
 */

class 뒤에있는큰수찾기 {
    public int[] solution(int[] numbers) {
        int num_len = numbers.length;
        int[] answer = new int[num_len];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i = 0 ; i<num_len ; i++){
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }
        return answer;
    }
}