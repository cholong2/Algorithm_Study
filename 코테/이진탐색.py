arr = [5, 10, 15, 19, 23, 30, 47, 56, 78, 80]

n = len(arr)
left = 0
right = n-1
target = int(input())

while left <= right:
    mid = (left+right)//2
    if arr[mid] == target:
        print(mid)
        break
    elif arr[mid] > target:
        right = mid-1
    else:
        left = mid + 1


if left>right:
 print(-1)
