from itertools import product

n, m = map(int, input().split())

comb = list(product([x for x in range(1,n+1)], repeat = m))

for i in sorted(comb) :
    for j in i :
        print(j, end=' ')
    print()