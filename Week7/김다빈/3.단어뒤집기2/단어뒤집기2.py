n = input()
answer = ""

flag = False
idx = 0
tmp = ""
while idx < len(n):
    if n[idx] == "<":
        if tmp != "":
            tmp = tmp[::-1]
            answer += tmp
            tmp = ""
        tmp += n[idx]
        flag = True
    elif n[idx] == ">":
        flag = False
        tmp += n[idx]
        answer += tmp
        tmp = ""
    elif not flag and n[idx] == " ":
        tmp = tmp[::-1]
        tmp += " "
        answer += tmp
        tmp = ""
    else:
        tmp += n[idx]

    idx += 1
    if idx == len(n):
        tmp = tmp[::-1]
        tmp += " "
        answer += tmp

print(answer)





