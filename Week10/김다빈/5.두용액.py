n = int(input())
arr = sorted(map(int, input().split()))
start = 0
last = len(arr) - 1
tmp = 2000000001
answer = []

while start < last:
    if abs(arr[start] + arr[last]) < abs(tmp):
        tmp = arr[start] + arr[last]
        answer = [arr[start], arr[last]]

    if arr[start] + arr[last] > 0:
        last -= 1
    elif arr[start] + arr[last] < 0:
        start += 1
    else:
        break


print(*answer)