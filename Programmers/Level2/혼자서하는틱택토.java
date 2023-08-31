package Level2;

/**
 * start : 2023-08-31 16:00
 * end : 2023-08-31 17:00
 * 알고리즘 : 구현
 */
import java.util.*;

class 혼자서하는틱택토 {
    char[][] b;
    public int solution(String[] board) {
        //board가 규칙을 지켰을때 나올수 있는 상황인가 알아보자~
        //선공은 o 후공은 x
        //누군가 이겼는데 계임 계소 ㄱ했을때

        int answer = -1;
        b = new char[3][3];
        boolean winO = false;
        boolean winX = false;
        int cntO = 0;
        int cntX = 0;

        for (int i = 0 ; i < 3 ; i++){
            for (int j = 0 ; j < 3; j++){
                b[i][j] = board[i].charAt(j);
            }
        }

        for (int i = 0 ; i < 3 ; i++){
            for (int j = 0 ; j < 3 ; j++){
                if (b[i][j]=='O'){
                    cntO++;
                }
                else if (b[i][j] == 'X'){
                    cntX++;
                }
            }
        }

        //x가 o보다 많으면 위반
        if (cntX > cntO)
            return 0;
        //o가 x보다 2개이상 많으면 위반
        if (cntO > cntX+1)
            return 0;
        //o가 이겼을때 같으면 위반
        if (check('O')){
            if (cntO == cntX)
                return 0;
        }
        //X가 이겼을때 o가 1개 더 많으면 위반
        if (check('X')){
            if (cntO > cntX)
                return 0;
        }

        return 1;
    }

    //이길수 잇는지 확인
    public boolean check (char ch){
        for (int i = 0 ; i < 3 ; i++){
            //가로 검사
            if (b[i][0] == ch && b[i][1] == ch && b[i][2] == ch)
                return true;
        }
        for (int i = 0 ; i < 3 ; i++){
            //세로 검사
            if (b[0][i] == ch && b[1][i] == ch && b[2][i] == ch)
                return true;
        }

        if (b[0][0] == ch && b[1][1] == ch && b[2][2] == ch)
            return true;

        if (b[0][2] == ch && b[1][1] == ch && b[2][0] == ch)
            return true;

        return false;
    }
}