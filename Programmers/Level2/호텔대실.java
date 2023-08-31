package Level2;

/**
 * start : 2023-08-29 17:05
 * end : 2023-08-29 17:05
 * 알고리즘 : 누적합, PriorityQueue
 */

import java.util.*;

class 호텔대실 {
    public int solution(String[][] book_time) {
        int answer = 0;
        int n = book_time.length;
        ArrayList <int[]> arr = new ArrayList<>();

        for (int i = 0 ; i < n ; i++){
            int[] conv = new int[2];

            conv[0] = Integer.parseInt(book_time[i][0].replace(":", ""));
            conv[1] = Integer.parseInt(book_time[i][1].replace(":", ""));
            conv[1] +=10;

            if (conv[1]%100 >=60)
                conv[1]+=40;

            arr.add(conv);
        }
        Collections.sort(arr, (o1, o2)->o1[0]-o2[0]);


        int idx = 0;
        PriorityQueue<Integer> room = new PriorityQueue<>();

        for (int[] time : arr){
            if (room.size()==0){
                room.add(time[1]);
                continue;
            }
            if (room.peek() <= time[0]){
                room.poll();
                room.add(time[1]);
            }
            else {
                room.add(time[1]);
            }
        }
        return room.size();
    }
}
