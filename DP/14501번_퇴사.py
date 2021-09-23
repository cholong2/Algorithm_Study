import sys
input = sys.stdin.readline

n = int(input())
t = []
p = []
result = [0 for _ in range(n+1)]

for i in range(n):
    a, b = map(int, input().split())
    t.append(a)
    p.append(b)

#range에서 범위 설정할 때 마지막에 지정한 끝나는 숫자보다 1이 더 큼
#n-1부터 0까지 -1씩 증가하라
#기억해 range 범위 설정 헷갈리지마 박댁아리,,

for i in range(n-1, -1, -1):
    #이미 기한 넘긴거는 못하니까 앞에 까지의 이득을 넣어줘야겠지?
    if t[i]+i > n:
        result[i] = result[i+1]
    #뭐가 더 이득인지 판단해야겠지
    #i의 이득과 그만큼 일하고 난 다음 그 날의 인덱스끼리 더한거랑 vs
    #일 안하고 다음날거의 이득을 비교해 최댓값 취하기
    else:
        result[i] = max(result[i+1], p[i]+result[i+t[i]])


print(result[0])
