/*
알고리즘 : DP
셋을 이용한 DP
처음에 HashMap으로 구현하다가 실패
개수만큼 만들 수 있는 숫자 계산하고 그 뒤에 붙여서 연산해줬음
근데 이러면 ()도 포함이라 순서가 다를때는 못찾음 ㅠ

list에 만들 수 있는 모든 경우의 수 만들고
만약 지금 4개 사용해야하면
13 31 22 일케 다 해줘야함
그리고 담긴 애들끼리 모두 연산~
 */
package Level3;

import java.util.*;

class N으로_표현 {
    public void unionSet(Set<Integer> union, Set<Integer> a, Set<Integer> b){
        for (int n1 : a){
            for (int n2 : b){
                union.add(n1+n2);
                union.add(n1-n2);
                union.add(n1*n2);
                if (n2!=0)
                    union.add(n1/n2);
            }
        }
    }
    public int solution(int N, int number) {
        List<Set<Integer>> list = new ArrayList<>();

        for (int i = 0 ; i <= 8 ; i++)
            list.add(new HashSet<>());

        list.get(1).add(N);//첫번째 리스트

        if (number == N)
            return 1;

        //1은 N으로 초기화 2부터 시작
        for (int i = 2 ; i <= 8 ; i++){
            for (int j = 1 ; j <=i ; j++){
                unionSet(list.get(i), list.get(i-j), list.get(j));
                unionSet(list.get(i), list.get(j), list.get(i-j));
            }
            String n = Integer.toString(N);
            list.get(i).add(Integer.parseInt(n.repeat(i)));
            for (int num : list.get(i)){
                if (num == number)
                    return i;
            }
        }

        return -1;
    }
}
