from collections import deque

n, m, v = map(int, input().split())

graph = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

#  여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고라는 조건이 있기 때문에 정렬을 했다.
for i in range(len(graph)):
    graph[i].sort()


def bfs():
    queue = deque([v])
    visited = [False] * (n + 1)
    visited[v] = True
    answer = [v]

    while queue:
        tmp = queue.popleft()

        for i in graph[tmp]:
            if not visited[i]:
                queue.append(i)
                answer.append(i)
                visited[i] = True
    print(*answer)
    return


visited = [False] * (n + 1)


def dfs(node):
    print(node, end=" ")
    visited[node] = True
    for i in graph[node]:
        if not visited[i]:
            dfs(i)



dfs(v)
print()
bfs()

