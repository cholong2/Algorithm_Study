# BFS
# 아이디어 : 큐 그거 어떻게 하는건데 진차 처음에 이걸 어케 bfs로 풀어 ㅡㅡ 하나하나 다하라는것도 아니고
# 해서 내맘대로 풀려고 발악해서 풀었는데 조건을 너무 많이 세워야해서 아 이건 아니다로 돌아가고
# 큐로 어찌저찌해보려는데 내머리로는 포기 결국 돌고돌아 구글링- 내가 못푼이유는
# 레벨이 초가 될 수 있다는걸 생각 못했고 그걸 따로 저장해줄 리스트도 생각못했음
# 응용력 제로라고 할 수 있겠다
# start : 22.03.31 13:22
# end : 22.03.31 18:30
from collections import deque

n, k = map(int, input().split())


max = int(100000)
result = [0] * (max+1)

q = deque()
q.append(n)

while q:
    x = q.popleft()
    if x == k:
        print(result[x])
        break

    for i in (x-1, x+1, x*2):
        if 0 <= i <=max and not result[i]:
            result[i] = result[x] +1
            q.append(i)

# 2배를 돌렸을 때랑
# +1, -1 했을때랑 비교해야함
# while n != k:
#     if k == 2*n and k == n+1 and k == n-1:
#         cnt+=1
#         break
#     elif 2*n > k:
#         if abs(2*n-k) >= abs(2*(n-1)-k):
#             cnt += abs(2*n-k)
#         elif abs(2*n-k) < abs(2*(n-1)-k):
#             cnt += abs(2*(n-1)-k)
#         break
#     elif 2*n < k:
#         cnt+=1
#         n = 2*n







