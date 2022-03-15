#3301 : 거스름돈

n = int(input())
money = [50000, 10000, 5000, 1000, 500, 100, 50, 10]
r = 0

for i in range (8):
    r =r + n//money[i]
    n =n % money[i]

print (r)