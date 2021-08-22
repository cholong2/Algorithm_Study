#백준 10808번: 알파벳 개수
# count 함수 사용 .count(self, x, _start, _end)
# 대소문자를 구분하고 찾을 x에 문자를 한개 넣어도 가넝
# start와 end에 아무것도 넣지 않으면 문자열 처음부터 끝까지 탐색
# start <= < end 범위

s = input()
result = [0]*26

for i in range(len(s)):
    result[ord(s[i])-97] = s.count(s[i])

for i in result:
    print(i, end=" ")