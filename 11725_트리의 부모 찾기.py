#트리를 순회 하는 방법에는 2가지가 있는데
# 1. BFS(Breath First Search) 너비우선 탐색 => 루트부터 레벨순으로
# 2. DFS(Depth First Search) 깊이 우선 탐색이 있음 => 한노드의 자식을 타고 끝까지 순회하고 그담에 다른형제 도는거

import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

def find(x):
    if node[x]:
        for data in node[x]:
            result[data] = x
            node[data].remove(x)
            find(data)


n = int(input())
#[]리스트가 n+1개 있는 리스트
node = [[] for _ in range(n+1)]
result = [0 for _ in range(n+1)]

for _ in range(n-1):
    a, b = map(int, input().split())
    node[a].append(b)
    node[b].append(a)


find(1)
for i in range(2, n+1):
    print(result[i])

