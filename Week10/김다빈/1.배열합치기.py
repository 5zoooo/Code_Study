n, m = map(int, input().split())
a_list = list(map(int, input().split()))
b_list = a_list + list(map(int, input().split()))
b_list.sort()

print(*b_list)