n, m = map(int, input().split())
arr = list(range(1, (n + 1)))
answerSet = set()
visitied = [0] * (n + 1)


def backtracking(lst, idx):

    if len(lst) == m:
        lst.sort()
        if tuple(lst) not in answerSet:
            answerSet.add(tuple(lst))
        return

    if len(lst) > m:
        return

    if idx > len(arr):
        return

    for i in range(idx, len(arr)):
        if visitied[i] == 0:
            visitied[i] = 1
            backtracking(lst + [arr[i]], idx + 1)
            visitied[i] = 0


backtracking([], 0)
answer = sorted(answerSet)

for i in answer:
    print(*i)

