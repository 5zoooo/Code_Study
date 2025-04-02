from itertools import product

n,m = map(int,input().split())
nums = sorted(set(map(int,input().split())))

res = sorted(set(product(nums, repeat = m)))

for i in res :
    for j in i :
        print(j, end=" ")
    print()

#다른 방법
#다른 방법
n, m = map(int, input().split())
cand = sorted(list(map(int,input().split())))
result = []
tmp = []

def bt():
    if len(tmp) == m:
        result.append(tuple(tmp[:]))  # 복사본 저장
        return
    for i in cand:
        tmp.append(i)
        bt()
        tmp.pop()  

bt()

for a in sorted(list(set(result))):
    print(' '.join(map(str, a)))