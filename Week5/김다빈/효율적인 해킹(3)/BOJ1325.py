from collections import deque

n, m = map(int, input().split())
graph = [[] for _ in range(n + 1)]
answer = []
maxCnt = 0

for _ in range(m):
    a, b = map(int, input().split())
    graph[b].append(a)


def bfs(num):
    global answer
    global maxCnt
    queue = deque([num])
    visited = [False] * (n + 1)
    cnt = 0
    visited[num] = True
    while queue:
        tmp = queue.popleft()

        for i in graph[tmp]:
            if not visited[i]:
                queue.append(i)
                visited[i] += 1
                cnt += 1

    if cnt > maxCnt:
        maxCnt = cnt
        answer = [num]
    elif cnt == maxCnt:
        answer.append(num)

    return


for i in range(1, n + 1):
    bfs(i)

answer.sort()
print(*answer)
