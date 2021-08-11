#단어 뒤집기2
import sys


input = list(sys.stdin.readline().rstrip())

tag = True #뒤집기를 해야할 때
result  = ""
temp = ""

for i in input:
    if tag:
        if i == "<":
            tag = False
            result = result + temp + i
            temp = ""
        elif i == " ":
            temp += i
            result += temp
            temp = ""
        else:
            temp = i + temp
    else:
        temp += i
        if i == ">":
            tag = True
            result = result + temp
            temp = ""

print(result+temp)