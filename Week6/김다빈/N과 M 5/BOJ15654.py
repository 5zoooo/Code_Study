n, m = map(int, input().split())
arr = sorted(map(int, input().split()))
visited = [0] * len(arr)
answerSet = set()


def backtracking(lst):
    if len(lst) == m:
        tupledLst = tuple(lst)
        if tupledLst not in answerSet:
            answerSet.add(tupledLst)

        return

    if len(lst) > m:
        return

    for i in range(len(arr)):
        if visited[i] == 0:
            visited[i] = 1
            backtracking(lst + [arr[i]])
            visited[i] = 0


backtracking([])
answer = sorted(answerSet)
for i in answer:
    print(*i)