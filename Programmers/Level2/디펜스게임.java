package Level2;

/**
 * start : 2023-09-22 15:20
 * end : 2023-09-22 16:55
 * 알고리즘 : 우선순위 큐
 * 접근은 잘 했는데 조건을 잘못 나눠서 tc 10, 29에서 계속걸림 ㅜ 결국 굴복해버리고만,,
 * 조건은 최대한 간단하게 나눠보자 ^^,,
 */
import java.util.*;

class 디펜스게임 {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int min = 1000001;
        PriorityQueue <Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // 무적권은 가장 큰 수에 박으면 좋음
        // k가 0일때까지 무적을 계속 주고 더 큰 숫자가 나오면 무적 넘겨주고 n은 무적이었던걸 더해주기
        // 종료 조건은 n이 enemy[i]보다 작거나 k가0일때
        // 무적 최솟값 저장 + index 저장
        for (int i = 0 ; i < enemy.length ; i++){
            if (n < enemy[i] && k==0) break; //병사가 부족하고 무적권도 없을때

            pq.offer(enemy[i]); // 적군 수 우선순위 큐에 추가
            if (n<enemy[i]){ // 병사가 부족해서 무적권을 써야할때
                n+=pq.poll(); // 지금까지 가장 많았던 적군 수 채우기 (현재 라운드 포함)
                k--;//무적권 사용
            }

            n-=enemy[i]; //병사 사용
            answer++; // 라운드 추가
        }


        return answer;
    }
}