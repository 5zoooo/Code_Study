n, k = map(int, input().split())
arr = list(map(int, input().split()))

start = 0
answer = 0
numDict = dict()

for i in range(len(arr)):
    numDict[arr[i]] = numDict.get(arr[i], 0) + 1
    if numDict[arr[i]] > k:
        while numDict[arr[i]] > k:
            numDict[arr[start]] -= 1
            if numDict[arr[start]] == 0:
                del numDict[arr[start]]
            start += 1
    answer = max(answer, i - (start - 1))

print(answer)