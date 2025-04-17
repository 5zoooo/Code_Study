"""
풀이 계획
문제를 처음 보고 든 생각 이게 왜 이분탐색?
"""
n, m = map(int, input().split())
arr = []

for _ in range(n):
    arr.append(int(input()))

arr.sort()

first = arr[0]
last = max(arr) * m
answer = last

while first <= last:
    mid = (first + last) // 2
    tmp = 0

    for i in range(n):
        tmp += mid // arr[i]

    if tmp >= m:
        answer = mid
        last = mid - 1
    else:
        first = mid + 1


print(answer)

