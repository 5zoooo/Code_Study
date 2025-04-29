# 9주차 5번

N = int(input())
M = list(map(int, input().split()))
Q = int(input())

decrease = [0] * N
for i in range(N - 1):
    if M[i + 1] < M[i]:
        decrease[i] = 1

prefix = [0] * N
prefix[0] = decrease[0]
for i in range(1, N - 1):
    prefix[i] = prefix[i - 1] + decrease[i]

for _ in range(Q):
    start, end = map(int, input().split())
    if start == end:
        print(0)
    elif start == 1:
        print(prefix[end - 2])
    else:
        print(prefix[end - 2] - prefix[start - 2])
