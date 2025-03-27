n, m = map(int, input().split())
arr = sorted(map(int, input().split()))
answerSet = set()


def backtracking(lst, idx):
    if len(lst) == m:
        tupledlst = tuple(lst)
        if tupledlst not in answerSet:
            answerSet.add(tupledlst)

        return

    if len(lst) > m:
        return

    for i in range(idx, len(arr)):
        backtracking(lst + [arr[i]] , i)


backtracking([], 0)
answer = sorted(answerSet)
for i in answer:
    print(*i)