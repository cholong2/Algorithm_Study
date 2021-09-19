#이분탐색
# k개의 랜선을 가지고 있는데, n개의 랜선으로 잘라야함
# 이때 만들 수 있는 최대 랜선의 길이를 구하기
# 어케 풀까 이분탐색이니까 분기점의 길이를 얼마로 설정하고 나누면 될지
# 계속 탐색해보면 되지 않ㅇ르까?

import sys

input = sys.stdin.readline

k, n = map(int, input().split())
root = [ ]

for i in range(k):
    root.append(int(input()))

low, high = 1, max(root)

while low<=high :
    mid = (low+high)//2
    line = 0

    for i in root:
        line += i//mid

    if line >= n:
        low = mid+1
    else:
        high = mid-1

print(high)
