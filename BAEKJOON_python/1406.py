import sys

stack1 = list(sys.stdin.readline().strip())
stack2 = []

n = int(input())

for i in range(n):
    cmd = sys.stdin.readline()
    if cmd[0] == 'L':
        if stack1:
            stack2.append(stack1.pop())
    elif cmd[0] == 'D':
        if stack2:
            stack1.append(stack2.pop())
    elif cmd[0] == 'B':
        if stack1:
            stack1.pop()
    else:
        stack1.append(cmd[2])

print(''.join(stack1 + stack2[::-1]))