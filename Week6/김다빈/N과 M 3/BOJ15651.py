n, m = map(int, input().split())
arr = list(range(1, (n + 1)))
answerSet = set()


def backtracking(lst):
    if len(lst) == m:
        if tuple(lst) not in answerSet:
            answerSet.add(tuple(lst))

        return

    if len(lst) > m:
        return

    for i in range(len(arr)):
        backtracking(lst + [arr[i]])


backtracking([])
answer = sorted(answerSet)

for i in answer:
    print(*i)