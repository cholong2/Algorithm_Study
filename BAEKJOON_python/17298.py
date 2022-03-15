#백준 17298번 오큰수
import sys

# 방법1 이중 for문을 사용한다면? => 근데 시간초과 될 거 같음
# 방법2 stack을 이용한다면? =>

num = int(input())
a = list(map(int, input().split()))
big_num = [-1] * num
stack = []


for i in range(num):
    while stack and a[stack[-1]] < a[i]:
        big_num[stack.pop()] = a[i]
    stack.append(i)

for i in range(num):
    print(big_num[i], end = " ")