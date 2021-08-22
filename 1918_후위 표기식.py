#백준 1918번: 후위 표기식
# 중위 표기식을 후위 표기식으로 바꾸는 거
# 이것도 스택 쓰면 되겠지!
# 우선순위 1 (), 2 */, 3 +- 로 조건문 나누기

a = list(input())
temp = []
result = ''


for i in a:
    #문자면 바로 출력
    if i.isalpha():
        result += i
    else:
        if i == '(':
            temp.append(i)

        elif i == ')':
            while temp and temp[-1] != '(':
                result+=temp.pop()
            temp.pop()

        elif i == '*' or i == '/':
            while temp and (temp[-1] == '*' or temp[-1] == '/'):
                result+=temp.pop()
            temp.append(i)

        elif i == '+' or i == '-':
            while temp and temp[-1] != '(':
                result +=temp.pop()
            temp.append(i)

while temp:
    result += temp.pop()

print(result)


