# DP
# n개의 물품갯수와 k만큼 버틸 수 있음
# w = 무게, v = 가치
# 최대가치합 구하기
# 아이디어 : 1. 물건을 배낭에 담을 때 넣을 수 있는 것보다 무게가 더 크면 넣지 않는다 2. 그렇지 않으면 둘 중에 가치 선택
# 2-1) 현재 넣을 물건의 무게만큼 배낭에서 빼고 그리고 현재 물건을 넣기
# 2-2) 현재 물건을 넣지 않고 이전 배낭 그대로 가지고 가기
# 디피로 접근해서 표로 풀어야 된다는 것까지는 접근했는데 가치선택하는 거에서 좌절ㅠ
# 넣을 물건의 무게와 똑같이 뺄수 없는데 그걸 어케 빼요?
# -> 1부터 시작해서 그 값어치 테이블의 인덱스를 무게라고 생각하고 넣으면 됨! 난 일단 이렇게 이해했어.
# start : 22.03.27 20:30
# end : 22.03.28

n, k = map(int, input().split())
thing = [[0,0]]

for i in range(n):
    thing.append(list(map(int, input().split())))


result = [[0]*(k+1)for _ in range(n+1)]

for i in range(1, n+1):
    for j in range(1, k+1):
        w = thing[i][0]
        v = thing[i][1]
        if j < w:
            result[i][j] = result[i-1][j]
        else:
            result[i][j] = max(result[i-1][j-w]+v, result[i-1][j])

print(result[n][k])