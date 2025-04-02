from itertools import permutations

n,m = map(int,input().split())
nums = list(map(int,input().split()))

comb = permutations(nums, m)

for i in sorted(comb) :
    for j in i :
        print(j, end=' ')
    print()