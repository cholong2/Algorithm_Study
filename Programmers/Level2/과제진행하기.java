package Level2;
import java.util.*;
/**
 * start : 2023-09-06 14:47
 * end : 2023-09-06
 * 알고리즘 : 스케줄링
 새로시작 > 멈춰둔거(최근에 멈춘게 더 먼저)
 */

class Node {
    String name;
    int start;
    int playtime;

    public Node(String n, int s, int pt){
        this.name = n;
        this.start = s;
        this.playtime = pt;
    }
}
class 과제진행하기 {
    public List<String> solution(String[][] plans) {
        int n = plans.length;
        List<String> answer = new ArrayList<>();
        Node[] node = new Node[n];
        int cnt = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (o1, o2) -> (o1.start - o2.start)
        );

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < n ; i++){
            String name = plans[i][0];

            String[] str = plans[i][1].split(":");
            int h = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            int start = (h * 60) + m;

            int time = Integer.parseInt(plans[i][2]);

            pq.add(new Node(name, start, time));
        }

        Stack<Node> q  = new Stack<>();

        while (!pq.isEmpty()){
            //지금 시간이 탐색할 다음 과제 시작보다 빠르다면
            //중단했던 과제 진행 없으면 걍 넘어가기
            Node nowTask = pq.poll();
            int curTime = nowTask.start;

            //새로운 과제가 있다면
            if (!pq.isEmpty()){
                Node next = pq.peek();

                //지금 과제 끝나고도 다음 과제 시작까지 시간이 남았다면
                if (caltime(curTime, nowTask.playtime) <= next.start){
                    curTime = caltime(curTime, nowTask.playtime);
                    answer.add(nowTask.name);

                    //잠시 멈춘 과제가 있다면, 남는 시간동안 멈췄던 과제 진행
                    while (!q.isEmpty()){
                        Node rem = q.pop();

                        //다음 새로운 과제 시작 전까지 다 끝낼 수 있다면
                        if (caltime(curTime, rem.playtime) < next.start){
                            curTime = caltime(curTime, rem.playtime);
                            answer.add(rem.name);
                            continue;
                        }
                        //다음 새로운 과제 시작전까지 못 끝낸다면
                        else {
                            int temp = rem.playtime - (next.start-curTime);
                            q.push(new Node(rem.name, rem.start, temp));
                            break;
                        }
                    }
                }
                //지금 과제 끝나면 새로우 ㄴ과제 시작할 시간일때
                else if (caltime (nowTask.start, nowTask.playtime) == next.start){
                    answer.add(nowTask.name);
                    continue;
                }
                else {
                    int t = (next.start - nowTask.start);
                    q.push(new Node(nowTask.name, nowTask.start, nowTask.playtime-t));
                }

            }
            //새로운 과제가 없는 경우
            else {
                if (q.isEmpty()){
                    curTime = caltime(curTime, nowTask.playtime);
                    answer.add(nowTask.name);
                }
                else {
                    answer.add(nowTask.name);
                    while (!q.isEmpty()){
                        Node rem = q.pop();
                        answer.add(rem.name);
                    }
                }
            }

        }

        //마지막거 하고도 남았을때

        return answer;
    }
    public int caltime(int start, int plustime){
        int endtime = start + plustime;
        if(start%100 + plustime>=60)
            endtime += 40;

        if (endtime%100 >= 60)
            endtime +=40;

        return endtime;
    }
}