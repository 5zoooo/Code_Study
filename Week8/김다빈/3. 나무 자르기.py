n, m = map(int, input().split())

arr = sorted(map(int, input().split()))
start = 1
last = arr[-1]
middle = (start + last) // 2


def countTree(length):
    cnt = 0
    for i in arr:
        if length < i:
            cnt += i - length

    return cnt


while start <= last:
    tmp = countTree(middle)

    if tmp < m:
        last = middle - 1
        middle = (start + last) // 2
    else:
        start = middle + 1
        middle = (start + last) // 2


print(middle)



