"""
(x1 * x2) + (x1 * x3) + (x1 * x4) + (x1 * x5) + (x2 * x3) + (x2 * x4) + (x2 * x5) + (x3 * x4) + (x3 * x5) + (x4 * x5)
-> x1(x2 + x3 + x4 + x5) + x2(x3 + x4 + x5) + x3(x4 + x5) + x4(x5)
-> 각각의 누적합을 구한 후에 자신 이후에 누적합 * 자기 자신의 값을 곱하면 다음과 같이 정리된다.
"""

n = int(input())
arr = list(map(int, input().split()))
prefixArr = [0] * len(arr)

for i in range(len(arr)):
    if i == 0:
        prefixArr[0] = arr[0]
    else:
        prefixArr[i] = prefixArr[i - 1] + arr[i]

answer = 0

for i in range(len(arr) - 1):
    answer += arr[i] * (prefixArr[(len(arr) - 1)] - prefixArr[i])

print(answer)








