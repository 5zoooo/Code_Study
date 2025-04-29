n = int(input())
arr = list(map(int, input().split()))
cnt = int(input())
prefixArr = [0] * len(arr)


def prefixSum():
    prefix = 0
    for i in range(1, len(arr)):
        if arr[i] < arr[i - 1]:
            prefix += 1
        prefixArr[i] = prefix


def solution(x, y):
    if x == 0:
        print(prefixArr[y])
    elif x == y:
        print(0)
    else:
        print(prefixArr[y] - prefixArr[x])
    return


prefixSum()
for _ in range(cnt):
    x, y = map(int, input().split())
    solution(x - 1, y - 1)
