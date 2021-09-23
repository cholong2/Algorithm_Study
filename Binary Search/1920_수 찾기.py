#이진탐색

n = input()
sort_n = list(map(int, input().split()))
sort_n = sorted(sort_n)

m = input()
arrm = list(map(int, input().split()))

result = []

def binary (low, high, i,sort_n):
    if low > high:
        return 0

    mid = (high + low) // 2
    if sort_n[mid] == i:
        return 1
    elif sort_n[mid] > i:
        return binary(low,mid -1, i, sort_n)
    else:
        return binary(mid+1,high, i, sort_n)


for i in arrm:
    low = 0
    high = len(sort_n) - 1
    print(binary(low, high, i, sort_n))


