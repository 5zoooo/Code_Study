from itertools import product

n, m = map(int, input().split())
nums = sorted(list(map(int, input().split())))

comb = list(product(nums, repeat = m))

for i in sorted(comb) :
    for j in i :
        print(j, end=' ')
    print()