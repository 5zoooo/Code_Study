from itertools import combinations

n, m = map(int, input().split())
nums = sorted(list(map(int,input().split())))

res = sorted(set(combinations(nums, m)))

for i in res :
    for j in i :
        print(j, end=' ')
    print()