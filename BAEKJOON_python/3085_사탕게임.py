# 브루트포스
# 브루트포스란 모든 경우의 수를 생각해서 값을 도출해내는거 == 완전탐색
# 아이디어
# 일단 인접한 애들을 다 체크하기 -> 오른쪽이랑 아래만하기
# 그리고 가장 긴 열을 찾기 --> 가장 긴 열 찾기 할 때 바뀌는 부분이 3줄이라고 해서 그 부분만 비교해보면 된다고 했는데 애초에 인접한 다른 색상일 경우에만 스왑해서
# 이렇게 되면 바꾸지 않아도 가장 긴 경우는 찾을 수가 없음 ! 블로그 바바보바보~


n = int(input())
board = [list(input()) for _ in range(n)]
# 왜 이렇게 입력 받는거지? -> _는 값을 무시할 때 사용함 인덱스가 필요없을떄
# 그래서그냥 n번을 반복하면서 n개의 list를 받는거임
result = 0

def check():
    max_cnt = 1
    for i in range(n):
        cnt = 1
        for j in range(n-1):
            if board[i][j] == board[i][j+1]:
                cnt+=1
            else:
                cnt = 1
            max_cnt = max(cnt, max_cnt)
    for j in range(n):
        cnt=1
        for i in range (n-1):
            if board[i][j] == board[i+1][j]:
                cnt+=1
            else:
                cnt=1
            max_cnt = max(cnt, max_cnt)
    return max_cnt

for i in range(n):
    for j in range(n):
        if j < n-1:
            if board[i][j] != board[i][j+1]:
                board[i][j], board[i][j+1] = board[i][j+1], board[i][j]
                result = max(check(), result)
                board[i][j], board[i][j + 1] = board[i][j + 1], board[i][j]
        if i < n-1:
            if board[i][j] != board[i+1][j]:
                board[i][j], board[i+1][j] = board[i+1][j], board[i][j]
                result = max(check(), result)
                board[i][j], board[i + 1][j] = board[i + 1][j], board[i][j]

print(result)











