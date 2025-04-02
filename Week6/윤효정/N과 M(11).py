from itertools import product

n,m = map(int,input().split())
nums = sorted(set(map(int,input().split())))

res = sorted(set(product(nums, repeat = m)))

for i in res :
    for j in i :
        print(j, end=" ")
    print()