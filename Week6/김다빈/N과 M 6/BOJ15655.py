n, m = map(int, input().split())
arr = sorted(map(int, input().split()))
answerSet = set()
visited = [0] * (n + 1)


def backtracking(lst, idx):

    if len(lst) == m:
        tupledLst = tuple(lst)
        if tupledLst not in lst:
            answerSet.add(tupledLst)
        return

    if len(lst) > m:
        return


    for i in range(idx, len(arr)):
        if visited[i] == 0:
            visited[i] = 1
            backtracking(lst + [arr[i]], i)
            visited[i] = 0


backtracking([], 0)
answer = sorted(answerSet)

for i in answer:
    print(*i)

