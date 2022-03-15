#3120 : 리모컨

a, b = input().split()
a = int(a)
b = int(b)

cnt = 0


def cal10(a,b):
    if a<=b:
        return a+10
    else:
        return a-10

def cal5(a,b):
    if a<=b:
        return a+5
    else:
        return a-5

def cal1(a,b):
    if a<=b:
        return a+1
    else:
        return a-1

while True:
    c = abs(a - b)

    if a==b:
        break
    elif c >= 10:
        a = cal10(a, b)
        cnt+=1
    elif c >= 5:
        if c>=8:
            a = cal10(a, b)
        else:
            a = cal5(a, b)
        cnt+=1
    else:
        if c >=3:
            a= cal5(a, b)
        else:
            a = cal1(a,b)
        cnt += 1



print (cnt)
