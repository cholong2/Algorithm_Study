# 경쟁적 전염
# BFS
# 그리고 원소 갯수가 너무 크면 dfs는 못돌림 막 200*200 이건 안됨
# 일반 q에 바이러스의 위치를 넣고
# 정렬은 맨처음에 q에 넣을 때만 하면 됨
# 실행 안된 이유 : 리스트에 리스트같은걸 추가할 때 (())일케 한번더 감싸야함
# 바부바부~


from collections import deque

graph = []
q = deque()

# n*n의 매트릭스에 k개의 바이러스 종류가 있다
n, k = map(int, input().split())

l1 = [] # 바이러스정보 (바이러스번호, x, y)

# row별로 매트릭스 채우기
for row in range(n):
    graph.append(list(map(int, input().split())))
    # col에
    for col in range(n):
        if graph[row][col]!=0:
            l1.append((graph[row][col], row, col))


s, x, y = map(int, input().split())
# 바이러스 순서대로 소팅
l1.sort()

for i in l1:
    q.append(i)


# row, col 인덱스 같이 보면 (0, -1) -> row는 그대로 col은 -1한값 하면
# 상하좌우중에서 좌값이 되죠?
dr = [0, 0, -1, 1]
dc = [-1, 1, 0, 0]


for i in range(s):
    # q는 바이러스가 있는 곳의 정보를 모두 담고 있잖아
    # 서로 계속 퍼뜨리면 걔네들이 또 다 퍼뜨려야하니까 cnt만큼 계속 돌려줘야해
    cnt = len(q)
    for j in range(cnt):
        virus, row, col = q.popleft()
        for d in range(4): # 사방으로 퍼뜨리기
            nr = row + dr[d]
            nc = col + dc[d]
            if nr < 0 or nr >= n or nc < 0 or nc>=n:
                continue
            elif graph[nr][nc] == 0:
                graph[nr][nc] = virus
                q.append((virus, nr, nc))
    if graph[x-1][y-1] != 0:
        break

print(graph[x-1][y-1])
