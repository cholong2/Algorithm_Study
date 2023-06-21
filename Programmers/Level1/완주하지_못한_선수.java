package Level1;

/*
프로그래머스-코딩테스트 고득점 Kit : 완주하지 못한 선수
알고리즘 : 해시
한줄평 : 난 해시도 모르는 바보 ㅠ

입출력 예시
participant	completion	return
["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"
 */
import java.util.*;
public class 완주하지_못한_선수 {

        public String solution(String[] participant, String[] completion) {
            String answer = "";

            Map <String, Integer> check = new HashMap <>();

            for (String key : participant){
                if (check.containsKey(key)){
                    int val = check.get(key);
                    check.put(key, ++val);
                }
                else
                    check.put(key, 1);
            }

            for (String key : completion){
                check.put(key, check.get(key)-1);
            }

            for (String key : check.keySet()){
                if (check.get(key) != 0){
                    answer = key;
                }
            }

            return answer;
        }
}
