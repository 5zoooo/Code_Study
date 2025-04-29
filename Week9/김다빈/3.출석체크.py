"""
풀이계획
3 4 5 6 7 8 9 10 11 12

3 5 7
3 12
"""

n, k, q, m = map(int, input().split())
kLst = list(map(int, input().split()))
qLst = list(map(int, input().split()))
tests = []

for _ in range(m):
    s, e = map(int, input().split())
    tests.append((s, e))

attendMent = [1] * (n + 3)
prefixSum = [0] * (n + 3)
attendMent[0] = 0
attendMent[1] = 0
attendMent[2] = 0


for i in qLst:
    if i not in kLst:
        for j in range(i, n + 3, i):
            if j in kLst:
                continue
            attendMent[j] = 0

for i in range(1, len(attendMent)):
    prefixSum[i] = attendMent[i] + prefixSum[i - 1]



def solution(i, j):
    print(prefixSum[j] - prefixSum[i - 1])


for (i, j) in tests:
    solution(i, j)









