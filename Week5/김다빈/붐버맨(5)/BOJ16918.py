from collections import deque

# 입력 처리
r, c, n = map(int, input().split())
board = [list(input()) for _ in range(r)]

# 폭탄 터지는 로직
def detonate(board):
    r, c = len(board), len(board[0])
    new_board = [['O'] * c for _ in range(r)]

    for i in range(r):
        for j in range(c):
            if board[i][j] == 'O':  # 폭탄이 있는 칸
                new_board[i][j] = '.'
                for di, dj in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                    ni, nj = i + di, j + dj
                    if 0 <= ni < r and 0 <= nj < c:
                        new_board[ni][nj] = '.'

    return new_board

if n == 1:
    for row in board:
        print(''.join(row))

elif n % 2 == 0:
    for _ in range(r):
        print('O' * c)

else:
    first_detonation = detonate(board)
    second_detonation = detonate(first_detonation)

    if n % 4 == 3:
        for row in first_detonation:
            print(''.join(row))
    elif n % 4 == 1:
        for row in second_detonation:
            print(''.join(row))