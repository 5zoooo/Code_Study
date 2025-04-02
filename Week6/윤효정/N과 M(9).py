from itertools import permutations

n,m = map(int,input().split())
nums = list(map(int,input().split()))

res = sorted(set(permutations(nums, m)))

for i in res :
    for j in i :
        print(j, end=" ")
    print()