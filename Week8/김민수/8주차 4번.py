# 8주차 4번

N = int(input())
money = list(map(int, input().split()))
M = int(input())

start = 0  
end = max(money)
result   = 0  

while start <= end:
    mid = (start + end) // 2  
    total = 0

    for coin in money:
        total += min(coin, mid)
    
    if total <= M:
        result = mid
        start = mid +1
    else:
        end = mid - 1

print(result)