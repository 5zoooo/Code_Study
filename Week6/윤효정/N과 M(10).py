from itertools import combinations

n, m = map(int, input().split())
nums = sorted(list(map(int,input().split())))

res = sorted(set(combinations(nums, m)))

for i in res :
    for j in i :
        print(j, end=' ')
    print()

#다른 방법
n, m = map(int, input().split())
cand = sorted(list(map(int,input().split())))
result = []
tmp = []
visited = [False] * n

def bt():
  global visited

  if len(tmp) == m:
    result.append(tuple(tmp[:]))  # 복사본 저장
    return
  
  for i in range(n):
    if (visited[i] == False) and (len(tmp) ==0 or cand[i] >= tmp[-1]) :
      tmp.append(cand[i])
      visited[i] = True

      bt()
      tmp.pop()
      visited[i] = False

bt()

for a in sorted(list(set(result))):
    print(' '.join(map(str, a)))