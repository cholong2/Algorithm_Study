
arr = [15, 80, 19, 56, 78, 23, 5, 30, 10, 47]

n = len(arr)

for i in range(1, n):
    temp = 0
    for j in range(i, 0, -1):
        if arr[j-1] > arr[j]:
            arr[j-1], arr[j] = arr[j], arr[j-1]

print(arr)
