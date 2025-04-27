n, m = map(int, input().split())
arr = list(map(int, input().split()))
answer = 0
cnt = 0
start = 0
last = start + m


for i in range(m):
    answer += arr[i]

tmp = answer

if answer != 0:
    cnt += 1

for i in range(last, len(arr)):
    tmp -= arr[start]
    tmp += arr[i]

    start += 1
    if tmp > answer:
        answer = tmp
        cnt = 1
    elif tmp == answer:
        cnt += 1


if answer == 0:
    print("SAD")
else:
    print(answer)
    print(cnt)
