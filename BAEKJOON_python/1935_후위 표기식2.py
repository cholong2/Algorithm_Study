#백준 1925번: 후위 표기식2
# 일단 abcde요거에다가 숫자 넣어줘야하고
# 그다음엔 스택으로 넣어서 풀기

# 근데 어케 넣지..?

# 놀라운 깨달음 스택에는 숫자를 넣는게 아니라 인덱스를 넣는거임
# 이때까지 스택문제 이렇게 풀었으면서 생각없이 풀다가 이제서야 뭔가 광명찾은 기분이네

import sys

cnt = int(input())
a = list(input())
number = [0]* cnt
stack = []

for i in range(cnt):
    number[i] = int(input())

for i in range(len(a)):
    if a[i].isalpha():
        stack.append(number[ord(a[i])-ord('A')])
    else:
        n2 = stack.pop()
        n1 = stack.pop()

        if a[i] == '+':
            stack.append(n1+n2)
        elif a[i] == '-':
            stack.append(n1-n2)
        elif a[i] == '*':
            stack.append(n1*n2)
        elif a[i] == '/':
            stack.append(n1/n2)

print('%.2f' %stack[0])
