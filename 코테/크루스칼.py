# 1. 간선 데이터를 비용에 따라 오름차순으로 정렬
# 2. 비용이 가장 작은 간선 선택
# 3. 간선을 하나씩 확인하며 현재의 간선이 사이클을 발생시키는지 확인
# 3-1) 사이클 X -> 트리에 포함
# 3-2) 사이클 O -> 트리에 포함하지 않음
# 사이클을 확인하는 방법
# 각 간선을 확인하며 두 노드의 루트 노드를 확인한다
#   -> 루트 노드가 서로 다르다면 두 노드에 대하여 union 연산을 수행
#   -> 루트 노드가 서로 같다면 사이클이 발생
# 4. 모든 간선에 대하여 3번 반복


#사이클이 없을 때 간선처리
def union(parent, n, m):
    n = find_parent(parent, n)
    m = find_parent(parent, m)
    if n < m:
        parent[m] = n
    else:
        parent[n] = m

# 부모 노드 찾기
def find_parent(parent, n):
    if parent[n] != n:
        return find_parent(parent, parent[n])
    return n


# 부모노드 테이블 생성
parent = [0]*7

# 부모노드를 자신으로 초기화
for i in range (7):
    parent[i] = i

tree = [(5, 0, 1),
        (4, 0, 2),
        (2, 1, 2),
        (7, 1, 3),
        (6, 2, 3),
        (11, 2, 4),
        (3, 3, 4),
        (8, 3, 5),
        (8, 4, 5)
        ]

# cost가 가장 적은 노드부터 시작하기 위해 cost기준으로 정렬
tree.sort()

result = 0

# 모든 간선에 대해서 사이클 확인후 사이클이 생기지 않는 노드 선택해서 union
for edge in tree:
    cost, n, m = edge
    if find_parent(parent, n) != find_parent(parent, m):
        union(parent, n, m)
        result+=cost


print(result)










