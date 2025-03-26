from collections import deque

n = int(input())
arr = [list(map(int, input())) for _ in range(n)]
apartCnt = 0
answer = []


visited = [[False] * n for _ in range(n)]


def bfs(locate):
    global answer
    global apartCnt
    queue = deque([locate])
    tmpx, tmpy = locate[0], locate[1]
    cnt = 0
    visited[tmpx][tmpy] = True
    if arr[tmpx][tmpy] == 1:
        cnt += 1
    else:
        return

    di = [1, -1, 0, 0]
    dj = [0, 0, 1, -1]

    while queue:
        tmp = queue.popleft()
        curx, cury = tmp[0], tmp[1]

        for k in range(4):
            nx = curx + di[k]
            ny = cury + dj[k]

            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue

            if not visited[nx][ny]:
                if arr[nx][ny] == 1:
                    cnt += 1
                    queue.append([nx, ny])
                visited[nx][ny] = True

    if cnt > 0:
        apartCnt += 1
        answer.append(cnt)
    return


for i in range(len(arr)):
    for j in range(len(arr)):
        if not visited[i][j]:
            bfs([i, j])


print(apartCnt)
answer.sort()
for i in answer:
    print(i)