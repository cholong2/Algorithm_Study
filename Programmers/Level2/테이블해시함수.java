package Level2;

import java.util.*;
/**
 * start : 2023-09-25 15:00
 * end :  2023-09-25 15:38
 * 알고리즘 : 구현
 너 정렬 할 줄 아니? XOR연산할줄 아니? 문제
 */
class 테이블해시함수 {
    //col번째 컬럼의 값 오름차순 정렬, 값 같으면 기본키 첫번째 칼럼 값 기준으로 내림차순
    //s_i = i번째 행의 튜플에 대해 각 컬럼의 값을 i로 나눈 나머지들의 합으로 정의

    //일단 정렬하고 o
    //row_begin ~ row_end까지 계산하고 -> 함수  / 2진수로 변환 bitwise -> 함수
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        ArrayList<int[]> arr = new ArrayList<>();

        for (int i = 0 ; i < data.length ; i++){
            arr.add(data[i]);
        }
        arr.sort((o1, o2) -> o1[col-1]==o2[col-1] ? o2[0] - o1[0] : o1[col-1] - o2[col-1]);


        for (int i = row_begin-1 ; i < row_end ; i++){
            answer = si(answer, arr.get(i), i+1);
        }

        return answer;

    }
    public int si(int s1, int[] arr, int mod){
        int s2 = 0;
        for (int i = 0 ; i < arr.length ; i++){
            s2+=arr[i]%mod;
        }

        return s1^s2;
    }
}