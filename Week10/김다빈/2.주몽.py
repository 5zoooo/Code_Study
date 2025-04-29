n = int(input())
m = int(input())
arr = sorted(map(int, input().split()))
start = 0
last = len(arr) - 1
answer = 0

while start < last:
    if arr[start] + arr[last] == m:
        answer += 1
        start += 1
    elif arr[start] + arr[last] < m:
        start += 1
    else:
        last -= 1

print(answer)
