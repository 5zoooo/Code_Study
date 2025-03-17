#4주차 1번

def tiling(n):
    if n == 1: 
        return 1
    elif n == 2:  
        return 2

    a, b = 1, 2 
    for _ in range(3, n + 1):  
        a, b = b, a + b  # 값을 저장해 나가면서 진행

    return b  

#입력
n = int(input())

#결과
print(tiling(n) % 10007)  
