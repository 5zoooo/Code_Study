# 9주차 3번

N, K, Q, M = map(int, input().split())

sleeping = set(map(int, input().split()))

codes = list(map(int, input().split()))

queries = [tuple(map(int, input().split())) for _ in range(M)]

max_id = N + 3
check = [0] * max_id 

for code in codes:
    if code in sleeping:
        continue
    for student in range(code, max_id, code):
        if student not in sleeping:
            check[student] = 1

for s, e in queries:
    count = 0
    for i in range(s, e + 1):
        if check[i] == 0:
            count += 1
    print(count)