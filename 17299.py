#백준 17299번: 오등큰수

# 문제 이해 : 나보다 등장 횟수가 많은 수 중 가장 왼쪽에 있는 수 출력, 없으면 -1

# 어케 풀까 ? : 1초니까 얘도 stack을 사용해야겠지
# 1. 받은 숫자들 카운트 해주고
# 2. stack에다가 넣으면서 다음 숫자랑 F(a) 비교
# 3. 내가 더 크면 push 아니면 pop하고 result에 결과값 넣기
from collections import Counter

num = int(input())
a = list(map(int, input().split()))
result = [-1]*num
stack = []

# 개신기 Counter()하면 안에 있는 문자열이나 리스트 각 개수 알아서 세줌;;
# 1. 리스트로 받은 숫자들 카운트
F = Counter(a)

for i in range(num):
    while stack and F[a[stack[-1]]] < F[a[i]]:
        result[stack.pop()] = a[i]
    stack.append(i)

for i in range(num):
    print(result[i], end = " ")