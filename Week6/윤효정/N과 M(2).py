from itertools import combinations

n, m = map(int, input().split())

comb = list(combinations([x for x in range(1,n+1)], m))

for i in sorted(comb) :
    for j in i :
        print(j, end=' ')
    print()