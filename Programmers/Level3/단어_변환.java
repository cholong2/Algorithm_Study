package Level3;
/*
BFS
한글자만 틀렸을때 방문하면서 타겟 찾기~ 둥
 */
//String.valueOf(char) char -> string 변환
import java.util.*;
class Node {
    String word;
    int cnt;

    public Node (String temp, int count){
        this.word = temp;
        this.cnt = count;
    }
}
class 단어_변환 {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int be_len = begin.length();
        Queue <Node> q = new LinkedList<>();
        boolean v[] = new boolean[words.length];

        q.offer(new Node(begin, 0));

        while (!q.isEmpty()){
            Node now = q.poll();
            String nowW = now.word;
            int nowC = now.cnt;

            //찾았으면? 끝내기~
            if (nowW.equals(target))
            {
                System.out.println("들어옴");
                answer = nowC;
                break;
            }

            for (int i = 0 ; i < words.length ; i++){
                int temp = 0;
                if (!v[i]){
                    for (int j = 0 ; j < be_len ; j++){
                        if (nowW.charAt(j)!=words[i].charAt(j))
                            temp++;
                    }
                    if (temp==1){
                        q.offer(new Node(words[i], nowC+1));
                        v[i] = true;
                    }
                }
            }
        }

        return answer;
    }
}