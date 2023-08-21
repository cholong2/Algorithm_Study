package Level2;
/*
알고리즘 : 수
날 너무 힘들게 했던 알고리즘
한 사분면에서 두 원 안에 있는 정수쌍의 수 구하고
큰원에서 작은 원 빼주기
그리고 선 위에 있는 정수쌍도 더해줘야함~
 */
import java.util.*;
class 두_원_사이의_정수_쌍
{
    public long solution(int r1, int r2) {
        long answer = 0;


        long r1x = (long)Math.pow(r1,2);
        long r2x = (long)Math.pow(r2,2);

        //y^2= r^2-x^2

        long y1sum=0;
        long y2sum=0;
        long side =0;

        for(long i=0;i<=r2;i++){


            long y2 = (long)Math.sqrt(r2x-(long)Math.pow(i,2));

            long y1 = (long)Math.sqrt(r1x-(long)Math.pow(i,2));

            // 이 부분 추가!
            if(Math.sqrt((r1x-Math.pow(i,2)))%1==0){
                side++;
            }

            answer+=(y2-y1)*4;
        }

        answer+=side*4-4;



        return answer;
    }
}