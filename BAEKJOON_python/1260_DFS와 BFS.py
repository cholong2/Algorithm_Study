# DFS와 BFS
# 1. BFS(Breath First Search) 너비우선 탐색 => 루트부터 레벨순으로
# 2. DFS(Depth First Search) 깊이 우선 탐색이 있음 => 한노드의 자식을 타고 끝까지 순회하고 그담에 다른형제 도는거
# DFS는 함수안에서 재귀를 해 찾아가는 경우가 많고
# BFS는 큐나 데크에 저장하고 반복을 돌며 찾아가는 경우가 많음
# 아이디어 : 난 밥이다 일단 다른 사람들 코드를 보면서 익히자 ㅠ
# start : 22.03.29 22:22
# end : 22. 03.31 11:02

from collections import deque
#리스트를 사용해서 팝하면 O(N)이됨
#deque는 O(1)
#bfs 이해완료
def bfs(v):
    q = deque()
    q.append(v)
    visit_list[v] = 1
    # q가 빌때까지 반복
    while q:
        v = q.popleft()
        print(v, end= " ")
        for i in range(1, n+1):
            if visit_list[i] == 0 and graph[v][i] == 1:
                q.append(i)
                visit_list[i] = 1

#dfs이해완료
def dfs(v):
    visit_list2[v] = 1
    print(v, end= " ")
    # 탐색한 애(=v)랑 연결된 애를 모두 찾아보기
    for i in range(1, n+1):
        #v와 연결됐는데 아직 탐색하지 않았다면 바로 탐색ㄱ
        if visit_list2[i]==0 and graph[v][i] == 1:
            dfs(i)

n, m, v = map(int, input().split())

graph = [[0] * (n + 1) for _ in range(n + 1)]
visit_list = [0] * (n + 1)
visit_list2 = [0] * (n + 1)

for i in range(m):
    a, b = map(int, input().split())
    # 노드 연결 하기 입력받는 두 값에 대해 영행렬에 1삽입
    graph[a][b] = graph[b][a] = 1


dfs(v)
print()
bfs(v)










