# 7주차 5번

N, M = map(int, input().split())

def dup(N,M):
    list_N = [input() for _ in range(N)]
    list_M = [input() for _ in range(M)]

    common = list(set(list_N) & set(list_M))
    common.sort()  

    print(len(common))
    for name in common:
       print(name)

dup(N,M)