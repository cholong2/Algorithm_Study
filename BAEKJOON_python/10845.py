import sys

q = []
num = int(sys.stdin.readline().strip())

for i in range(num):
    com = sys.stdin.readline().strip()
    if com[0] == "push":
        q.insert(0, com[1])

    elif com[0] == "pop":
        print(q.pop())

    elif com[0] == "size":
        print(len(q))

    elif com[0] == "empty":
        if len(q)==0:
            print(1)
        else:
            print(0)

    elif com[0] == "front":
        if len(q):
            print (-1)
        else:
            print (q[0])
    elif com[0] == "back":
        if len(q):
            print(-1)
        else:
            print(q[-1])