from collections import deque

n = int(input())
nums = int(input())
graph = [[] for _ in range(n + 1)]

for _ in range(nums):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)


def bfs():
    cnt = 0
    queue = deque([1])
    visited = [False] * (n + 1)
    visited[1] = True

    while queue:
        tmp = queue.popleft()

        for i in graph[tmp]:
            if not visited[i]:
                cnt += 1
                queue.append(i)
                visited[i] = True

    print(cnt)
    return


bfs()

