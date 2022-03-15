#2001 : 최소대금

arr = []

n = 5

for i in range(n):
    arr.append(int(input()))

p = arr[:3]
j = arr[3:]


p_min = min(p)
j_min = min(j)

result = (p_min+j_min)*1.1

result = round(result, 1)
print (result)
