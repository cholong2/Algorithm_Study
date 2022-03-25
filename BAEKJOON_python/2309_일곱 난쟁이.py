# 브루트 포스 : 무식하게 푼다 가능한 방법을 전부 만들어보는 알고리즘 == 완전 탐색이라고도 함
# 입력값 9개중에 합이 100이 되는 7개 오름차순으로 출력
# 개똑똑해 걍 (9명난쟁이 키 합)-(특정 두명)=100으로 풀기
# 두번째 for문 조건만 걸고 첫번째 for문에 종료 조건 안걸어줘서 계속 돌았음 바부바부
# 그리고 출력 결과 제대로 보고 출력하기 !!!!! 문제 잘 확인해라!!!!

n = 9

arr =[]

for i in range(n):
    arr.append(int(input()))

arr.sort()
total = sum(arr)

for i in range(9):
    for j in range(i+1, 9):
        if 100 == total-(arr[i] + arr[j]):
            arr.remove(arr[i])
            arr.remove(arr[j-1])
            break

    if len(arr) < 9:
        break

for i in arr:
    print(i)
