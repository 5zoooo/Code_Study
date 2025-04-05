s = input()
n = len(s)

def istag(s,st_idx) :
    end_idx = s.find('>')
    print(s[st_idx:end_idx+1], end='')
    s = s.replace('>','-',1)
    
    return s, end_idx+1

tmp = ''
idx = 0
#i = 0

while idx != n :
    
    if s[idx] == '<' :
        print(tmp[::-1], end='')
        tmp = ''
        s, idx = istag(s,idx)
        
    elif s[idx] == ' ' :
        print(tmp[::-1], end=' ')
        tmp = ''
        idx += 1
    else :
        tmp += s[idx]
        idx += 1
    
    if idx == n :
        print(tmp[::-1], end='')
