n, m = map(int,input().split())

d_set = set()
b_set = set()

for _ in range(n) :
    d_set.add(input())

for _ in range(m) :
    b_set.add(input())
    
res = d_set.intersection(b_set)

print(len(res))
for x in sorted(res) :
    print(x)
