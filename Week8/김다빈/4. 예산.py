n = int(input())
arr = sorted(map(int, input().split()))
budget = int(input())

start = 1
last = arr[-1]
middle = (start + last) // 2


def getBudget(num):
    tmp = 0
    for i in arr:
        if num <= i:
            tmp += num
        else:
            tmp += i

    return tmp


if sum(arr) <= budget:
    print(arr[-1])
else:
    while start <= last:
        result = getBudget(middle)

        if result > budget:
            last = middle - 1
            middle = (start + last) // 2
        else:
            start = middle + 1
            middle = (start + last) // 2


    print(middle)

