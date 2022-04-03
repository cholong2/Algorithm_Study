# 볼링공고르기
# n개의 볼링공이 있고 m까지의 무게를 각각 가짐
# 두명은 볼링공을 서로 다른 무게로 골라야됨
# 계수 정렬을 쓰리고 했는데 계수정렬이 뭐냐
# 특정한 조건이 부합할 떄만 사용할 수 있지만 매우 빠르게 동작하는 정렬 알고리즘
# - 계수 정렬은 데이터의 크기 범위가 제한되어 정수 형태로 표현할 수 있을 때 사용 가능
# 리스트를 하나 만들어서 인덱스별로 카운팅을 해주는거임

n, m = map (int, input().split())
data = list(map(int, input().split()))
arr = [0]*(m+1)


# 계수정렬
for x in data:
    arr[x] +=1

result = 0

for i in range(1, m+1):
    # 고른 무게의 볼링공은 제외
    temp = n - arr[i]
    result += temp*arr[i]

print(result)