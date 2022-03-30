#DP
# 반복적으로 계산되는 것들의 계산 횟수를 줄이기 위해 이전에 계산했던 값들을 저장해두었다가
# 나중에 재사용하는 방법! 분할정복 기법을 사용하는 경우가 많음, 큼문제를 한번에 해결하기 힘들때 작은 여러개의 문제로 나누어서 푸는 기법!
# start: 22.03.27 20:12
# end: 22.03.27 21:45
# 아이디어 : 조건이 있으니까 뒤에서부터 푼다는 생각을 해줘야함 못하는 것들을 제외하고 그때부터
# dp로 푸는 생각하기


n = int(input())
t = []
p = []

result = [0] * (n+1)


for i in range(n):
    a, b = map(int, input().split())
    t.append(a)
    p.append(b)

for i in range(n-1, -1, -1):# 6부터 0까지 -1만큼
    if t[i]+i > n: # 퇴사날짜를 넘어가면
        result[i] = result[i+1] # 맡지않음 그전꺼랑 똑같은 값 넣어줌
    else:
        result[i] = max(result[i+1], p[i]+result[i+t[i]])

print(result[0])

