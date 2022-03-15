#3321 : 최고의 핏짜 그리디
# 주어진 조건들을 잘 생각해보기 머리 좀 쓰자

n = int(input()) #토핑종류수
a, b = map(int, input().split()) # a=도우가격, b=토핑가격

dk = int(input()) # 도우 칼로리

tk = [] # 토핑 칼로리

for i in range(n):
    tk.append(int(input()))


tk.sort(reverse=True)

kmax = dk/a
kcal = 0
cost = 0

for i in tk:
    kcal +=i
    cost += b

    r = (dk+kcal)/float(a+cost)
    if kmax>r:
        break
    else:
        kmax = r


print(int(kmax))


