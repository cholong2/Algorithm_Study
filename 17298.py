#백준 17298번 오큰수
import sys

# 방법1 이중 for문을 사용한다면? => 근데 시간초과 될 거 같음
# 방법2 stack을 이용한다면? =>

num = int(input())
a = list(map(int, input().split(" ")))
result = ["-1" for _ in range(num)]
stack = []
stack.append(0)
i = 1
for i in range(num):
    while stack and a[stack[-1]] < a[i]:
        result[stack[-1]] = str(a[i])
        stack.pop()

    stack.append(i)
    i += 1

print(" ".join(result))