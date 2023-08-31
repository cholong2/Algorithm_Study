package Level2;

/**
 * 알고리즘 : 문자열틱
 *
 */
public class 큰수만들기 {
    class Solution {
        public String solution(String number, int k) {
//         String answer = "";
//         Stack <Character> q = new Stack<>();
//         int num_len = number.length();
//         int cnt = num_len-k;//2

//         q.add(number.charAt(0));
//         // 1 9 2 4    k = 2
//         for (int i = 1 ; i < num_len ; i++){

//             if (q.peek() < number.charAt(i)){
//                 System.out.println(q.peek());
//                 while (!q.isEmpty() && q.peek() < number.charAt(i) && cnt-q.size() <= num_len-i-1){
//                     q.pop();
//                 }
//             }
//              q.add(number.charAt(i));
//         }

//         StringBuilder sb = new StringBuilder();
//         while (!q.isEmpty()){
//          sb.append(q.pop());
//         }

//         return sb.toString();
            String answer = "";
            StringBuilder answerBuilder = new StringBuilder();


            char[] array = number.toCharArray();

            int len = array.length - k;

            // 문자 비교를 시작하는 인덱스를 나타내는 start 변수
            int start = 0;

            for(int i =0; i<len; i++){
                char max = '0';
                for(int j = start; j <= i + k; j++){
                    // 가장 큰수를 골라서 그 다음 인덱스를 시작 인덱스로 설정하기
                    if(array[j] > max){
                        max = array[j];
                        start=j+1;
                    }
                }
                // 가장 큰 문자를 String에 넣어주기
                answerBuilder.append(Character.toString(max));
            }

            // k개의 수를 제거할 때 얻을 수 있는 가장 큰 숫자를 구하려 한다
            answer = answerBuilder.toString();
            return answer;
        }
    }
}
