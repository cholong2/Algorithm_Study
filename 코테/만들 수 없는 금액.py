# 만들 수 없는 금액
# 그리디
# 입력 받은 동전으로 만들수 없는 최솟값 찾기
# 있는 그대로 하나하나 하면 되지 하면 안됨
# 너무 많아짐 !
# 내가 받은 숫자보다 작은 수까지는 만들 수 있다라는 생각을 해야된대
# 도대체 왜 그렇게 되는거야 아직 이해가 안됨
# 일단 핵심은 target 이하의 값은 모두 만들수 있다고 정의
# 화폐 단위가 작은 동전부터 하나씩 확인하면서 target을 증가시키고
# 가장 작은 target 값을 찾아간다는 건 greedy 라는 뜻
# target에
# 일단 소팅

# 동전의 개수
n = int(input())
arr = list(map (int, input().split()))
arr.sort()

target = 1

for i in arr:
    if target < i:
        break

    target += i


print (target)