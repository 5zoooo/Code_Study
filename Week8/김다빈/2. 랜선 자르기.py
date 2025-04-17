n, m = map(int, input().split())
arr = list()

for i in range(n):
    arr.append(int(input()))


def countLan(length):
    cnt = 0
    for i in arr:
        cnt += (i // length)

    return cnt


last = max(arr)
start = 1
middle = (start + last) // 2

answer = 0
while start <= last:
    tmp = countLan(middle)

    if tmp < m:
        last = middle - 1
        middle = (start + last) // 2
    else:
        start = middle + 1
        middle = (start + last) // 2
        answer = tmp

print(middle)


