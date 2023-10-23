/**
 * start : 2023-10-17 16:55
 * end : 2023-10-17 17:57
 * 알고리즘 : 스케쥴링
 * 백준 1931번 회의실 배정
 * 시간초과 -> 10만이여서 이중포문 될까..? 일단 함 했는데 응 아니야 돌아가
 * 이런 문제들을 활동 선택 문제(Activity Selection problem)라고 함
 * 한사람이 하나의 활동에 대해서만 작업할 수 있을 떄 최대한 많은 활동을 할 수 있는 수를 선택하는 문제!
 * 종료시간이 짧으면 남은 시간이 많아진다? -> 남은 시간이 많으면 선택할 수 있는 선택지가 더 많아짐!
 * 그럼 종료시간을 기준으로 오름차순 한 후 겹치는 것 제외하면서 선택 ㄹㅈㄷㄹㅈㄷ
 * sort할 때 종료시간이 같다면 시작시간은 빠른 순서로 정렬
 * 반례 -> [4, 8]과 [8, 8]일때  [4, 8]배정 후 [8, 8] 배정 할 수 있음
 */

import java.util.*;
import java.io.*;

public class BJ_1931 {
    static int n;
    static int[][] meet;
    static int[][] time;

    public static void main (String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        meet = new int[n][2];
        time = new int[n][2];
        StringTokenizer st;

        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(bf.readLine());
            meet[i][0] = Integer.parseInt(st.nextToken());
            meet[i][1] = Integer.parseInt(st.nextToken());
        }
        //초기값 설정
        int answer = 1;
        Arrays.sort(meet, (o1, o2) -> {
            if (o1[1] == o2[1]){
                return o1[0]-o2[0];
            }
            return o1[1]-o2[1];
        });
        long lastT = meet[0][1];

        for (int i = 1 ; i < n ; i++){
            if (meet[i][0] >= lastT){
                lastT = meet[i][1];
                answer++;
            }
        }
        System.out.println(answer);

    }
}
