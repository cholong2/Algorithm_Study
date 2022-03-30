from collections import deque

def bfs(v):
    q = deque()
    q.append(v)
    visit_list[v] = 1
    while q:
        v = q.popleft()
        print(v, end= " ")
        for i in range(n+1):
            if visit_list[i] == 0 and graph[v][i] == 1:
                q.append(i)
                visit_list[i] = 1

def dfs(v):
    visit_list2[v] = 1
    print(v, end= " ")
    for i in range(n):
        if visit_list2[i]==0 and graph[v][i] == 1:
            dfs(i)

n = 7
v = 3

graph = [[0] * (n + 1) for _ in range(n + 1)]
visit_list = [0] * (n + 1)
visit_list2 = [0] * (n + 1)


graph[0][1] = graph[1][0] = 1
graph[0][2] = graph[2][0] = 1
graph[0][3] = graph[3][0] = 1
graph[1][4] = graph[4][1] = 1
graph[2][4] = graph[4][2] = 1
graph[2][5] = graph[5][2] = 1
graph[2][6] = graph[6][2] = 1
graph[3][5] = graph[5][3] = 1
graph[4][6] = graph[6][4] = 1
graph[5][6] = graph[6][5] = 1


dfs(v)
print()
bfs(v)
