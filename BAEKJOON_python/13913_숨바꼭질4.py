# BFS
# 아이디어 : 부모노드를 저장해주면서 탐색하자 -> 그럼 하나하나 다 해줘야됨 밑에서부터 올라오자
# 부모 노드를 새로은 array에 저장해주면서 탐색하고 나중에 역으로 순회하기 굳~
# start : 22.04.14 15:00
# end : 22.04.14 17:08
from collections import deque

n, k = map(int, input().split())


max = int(100000)
result = [0] * (max+1)
check = [0] * (max+1)

q = deque()
q.append(n)

def path(x):
    arr = []
    now = x
    for i in range(result[x]+1):
        arr.append(now)
        now = check[now]
    print(' '.join(map(str, arr[::-1])))


while q:
    x = q.popleft()
    if x == k:
        print(result[x])
        path(x)
        break

    for i in (x-1, x+1, x*2):
        if 0 <= i <= max and not result[i]:
            result[i] = result[x] +1
            q.append(i)
            check[i] = x





