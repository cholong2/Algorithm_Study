#쇠막대기
import sys

#( 스택에 푸시
#) 스택 팝 (
#()면 스택사이즈만큼 추가
# 걍 )면 +1 막대기가 끝나서 마지막 막대기 하나 더 나옴

input = list(sys.stdin.readline())
stack = []
result = 0

for i in range(len(input)):
    if input[i] == "(":
        stack.append("(")

    elif input[i] == ")":
        stack.pop()
        if input[i-1] == "(":
            result += len(stack)
        else:
           result += 1

print(result)