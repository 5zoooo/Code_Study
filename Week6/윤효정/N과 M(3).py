from itertools import product

n, m = map(int, input().split())

comb = list(product([x for x in range(1,n+1)], repeat = m))

for i in sorted(comb) :
    for j in i :
        print(j, end=' ')
    print()

#다른 방법
n, m = map(int, input().split())
cand = list(range(1, n+1))
result = []
tmp = []

def bt():
    if len(tmp) == m:
        result.append(tmp[:])  # 복사본 저장
        return
    for i in cand:
        if True:
            tmp.append(i)
            bt()
            tmp.pop()  

bt()

for a in result:
    print(' '.join(map(str, a)))