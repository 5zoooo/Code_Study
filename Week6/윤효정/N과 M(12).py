from itertools import combinations_with_replacement

n,m = map(int,input().split())
nums = sorted(set(map(int,input().split())))

res = sorted(set(combinations_with_replacement(nums, m)))

for i in res :
    for j in i :
        print(j, end=" ")
    print()

#다른 방법
n, m = map(int, input().split())
cand = sorted(list(map(int,input().split())))
result = []
tmp = []

def bt():

  if len(tmp) == m:
    result.append(tuple(tmp[:]))  # 복사본 저장
    return
  
  for i in range(n):
    if (len(tmp) ==0 or cand[i] >= tmp[-1]) :
      tmp.append(cand[i])

      bt()
      tmp.pop()

bt()

for a in sorted(list(set(result))):
    print(' '.join(map(str, a)))