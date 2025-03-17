#4주차 2번

def longest(arr):
    dp = [1] * n  

    for i in range(1, n):
        for j in range(i):
            if arr[i] > arr[j]:  
                dp[i] = max(dp[i], dp[j] + 1)

    return max(dp)

#입력
n = int(input())
arr = list(map(int, input().split()))

#결과
print(longest(arr))