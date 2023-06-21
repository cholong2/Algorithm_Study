package Level1;
import java.io.*;
import java.util.*;

/*
프로그래머스-코딩테스트 고득점 Kit : 폰켓몬
알고리즘 : 해시
입출력 예시
nums	result
[3,1,2,3]	2
[3,3,3,2,2,4]	3
[3,3,3,2,2,2]	2
 */

//내가 푼 것
public class 폰켓몬 {
    public int solution(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);
        int cnt = 1;

        for (int i = 0 ; i < nums.length-1 ; i++){
            if (nums[i]!=nums[i+1])
                cnt++;
        }

        if (cnt >= (nums.length)/2){
            answer = (nums.length)/2;
        }
        else
            answer = cnt;

        return answer;
    }
}

// 다른 사람이 푼 것
// hashset은 추가할때 알아서 중복 제거하고 추가해줌
//class Solution {
//    public int solution(int[] nums) {
//
//        HashSet<Integer> hs = new HashSet<>();
//
//        for(int i =0; i<nums.length;i++) {
//            hs.add(nums[i]);
//        }
//
//        if(hs.size()>nums.length/2)
//            return nums.length/2;
// 여기는 삼항연산문 써도 조을듯
//        return hs.size();
//    }
//}