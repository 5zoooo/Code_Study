from itertools import combinations_with_replacement

n, m = map(int,input().split())
nums = sorted(list(map(int,input().split())))

comb = combinations_with_replacement(nums, m)

for i in sorted(comb) :
    for j in i :
        print(j, end=" ")
    print()