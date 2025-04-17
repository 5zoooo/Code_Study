# 8주차 5번

import sys
input = sys.stdin.readline

N, M = map(int, input().split())

times = [int(input()) for _ in range(N)]

start = 1
end = max(times) * M
answer = end


while start <= end:
    mid = (start + end) // 2  

    people = 0
    for time in times:
        people += mid // time 

    if people >= M:
        answer = mid          
        end = mid - 1       
    else:
        start = mid + 1     

print(answer)
