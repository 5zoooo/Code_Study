n, m = map(int, input().split())
arr = sorted(map(int, input().split()))
answerSet = set()


def backtracking(lst):
    if len(lst) == m:
        tupledLst = tuple(lst)
        if tupledLst not in answerSet:
            answerSet.add(tupledLst)
        return

    if len(lst) > m:
        return


    for i in range(n):
        backtracking(lst + [arr[i]])


backtracking([])
answer = sorted(answerSet)
for i in answer:
    print(*i)
