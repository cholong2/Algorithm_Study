# 브루트포스
# 모든 경우의 수를 탐색해서 최적의 결과를 찾는 방법 == 완전탐색
# 절대 어렵게 생각하지말고 있는 그대로 하나하나 다 해본다는 생각을 먼저 하자!!

e, s, m = map(int, input().split())
# map은 입력받는 동시에 형변환이 가능! map(function, iterable)

cnt = 1
a = 1
b = 1
c = 1

while True:
    if a==e and b==s and c == m:
        break
    else:
        a +=1
        b +=1
        c +=1

        if a >15:
            a = 1
        if b> 28:
            b = 1
        if c > 19:
            c = 1

        cnt+=1

print(cnt)


#조민영 코드 념념긋
# # E: 1-15 / S: 1-28 / M: 1-19
#
# # 입력받기
# E, S, M = map(int, input().split())
# year = 1
#
# while True:
#     if ((year-E) % 15 == 0) and ((year-S) % 28 == 0) and ((year-M) % 19 == 0):
#         break
#     year += 1
#
# # 연도 출력
# print(year)