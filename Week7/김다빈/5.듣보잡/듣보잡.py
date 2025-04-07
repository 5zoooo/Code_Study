n, m = map(int, input().split())

People = set()
answer = []

for _ in range(n + m):
    name = input()
    if name not in People:
        People.add(name)
    else:
        answer.append(name)


answer.sort()

print(len(answer))
for i in answer:
    print(i)

