# DP
# 문제를 작은 문제로 쪼개서 푸는거 -> 점화식이나 표로
# 0부터 하다 보면 뭔가 규칙이 보임 !
# start : 22.04.14 17:10
# end : 22.04.14 18:09

n = int(input())
arr = [0] * (n+1)
arr[0] = 1
arr [1] = 3

result = 0

for i in range (2, n+1):
    arr[i] = (2*arr[i-1] + arr[i-2]) % 9901

print(arr[n])
