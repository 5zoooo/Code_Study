from itertools import combinations

n, m = map(int,input().split())
nums = sorted(list(map(int,input().split())))

comb = combinations(nums, m)

for i in sorted(comb) :
    for j in i :
        print(j, end=' ')
    print()