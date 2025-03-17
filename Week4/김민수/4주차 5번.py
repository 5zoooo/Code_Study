#4주차 5번

def knapsack(n, k, items):
    dp = [0] * (k + 1)

    #각 물건을 하나씩 확인
    for W, V in items:
        #뒤에서부터 탐색
        for current_W in range(k, W - 1, -1):
            dp[current_W] = max(dp[current_W], dp[current_W - W] + V)

    return dp[k]

#입력
n, k = map(int, input().split())
items = []
for _ in range(n):
    W, V = map(int, input().split())
    items.append((W, V))

#출력
print(knapsack(n, k, items))
