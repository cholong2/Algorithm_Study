# DFS
# start : 22.04.14. 11:11
# end : 22.04.14 12:39
# 아이디어 : 노드가 나왔으니까 dfs나 bfs로 풀면 되지 않을까? 근데 뭔가 친구가 모두 연결되어야 한다는거 같으니까
# DFS로 풀어보자
# -> 모든 노드를 탐색해서 4이상이 나오는지 봐야함

n, m = map(int, input().split())

arr = [[] for _ in range(n)]
visit_list = [False] * 2001

for i in range(m):
    a, b = map(int, input().split())
    arr[a].append(b)
    arr[b].append(a)

result = False

def find(index, depth):
    global result
    visit_list[index] = True
    if depth >= 4:
        result = True
        return
    if result:
        return

    for i in arr[index]:
        if not visit_list[i]:
            find(i, depth+1)
            visit_list[i] = False


for i in range(n):
    find(i, 0)
    visit_list[i] = False
    if result:
        break

if result:
    print(1)
else:
    print(0)