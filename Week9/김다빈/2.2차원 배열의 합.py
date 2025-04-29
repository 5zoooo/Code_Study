"""
연습장
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 1

1 2 3 4
2 4 6 8
3 6 9 12
4 8 12 16
"""

n, m = map(int, input().split())
arr = list()


for _ in range(n):
    arr.append(list(map(int, input().split())))

prefixArr = [[0] * len(arr[0]) for _ in range(len(arr))]

for i in range(len(arr[0])):
    if i == 0:
        prefixArr[0][i] = arr[0][i]
    else:
        prefixArr[0][i] = prefixArr[0][i - 1] + arr[0][i]

for j in range(1, len(arr)):
    prefixArr[j][0] = prefixArr[j - 1][0] + arr[j][0]


for i in range(1, len(arr)):
    for j in range(1, len(arr[0])):
        prefixArr[i][j] = prefixArr[i][j - 1] + prefixArr[i - 1][j] - prefixArr[i - 1][j - 1] + arr[i][j]


k = int(input())

def solution(lst):
    i, j, x, y = lst[0] - 1, lst[1] - 1, lst[2] - 1, lst[3] - 1
    total = prefixArr[x][y]
    if i > 0:
        total -= prefixArr[i - 1][y]
    if j > 0:
        total -= prefixArr[x][j - 1]
    if i > 0 and j > 0:
        total += prefixArr[i - 1][j - 1]
    print(total)

for _ in range(k):
    lst = list(map(int, input().split()))
    solution(lst)
