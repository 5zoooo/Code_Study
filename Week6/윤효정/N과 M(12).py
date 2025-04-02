from itertools import combinations_with_replacement

n,m = map(int,input().split())
nums = sorted(set(map(int,input().split())))

res = sorted(set(combinations_with_replacement(nums, m)))

for i in res :
    for j in i :
        print(j, end=" ")
    print()