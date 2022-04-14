# 구현 시뮬레이션
# start : 22.04.14 18:15
# end : 22.04.14 20:04
# 일단 드래곤 커브가 어떻게 되는지 알아야하고
# 그리고 그 안에 포함된 정사각형의 갯수 알아야됨

# 0: x좌표가 증가하는 방향 (→)
# 1: y좌표가 감소하는 방향 (↑)
# 2: x좌표가 감소하는 방향 (←)
# 3: y좌표가 증가하는 방향 (↓)

n = int(input())
dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

graph = [[0]*101 for _ in range(101)] # 100*100 격자

for _ in range(n):
    x, y, d, g = map(int, input().split())
    graph[x][y] = 1
    move = [d]
    for _ in range(g):
        temp =[]
        for i in range(len(move)):
            temp.append((move[-i-1]+1)%4)
        move.extend(temp)
    for i in move:
        nx = x + dx[i]
        ny = y + dy[i]
        graph[nx][ny] = 1
        x, y = nx, ny

result = 0
for i in range(100):
    for j in range(100):
        if graph[i][j]:
            if graph[i+1][j] and graph[i+1][j+1] and graph[i][j+1]:
                result +=1


print(result)