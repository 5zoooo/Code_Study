try:
    while True:
        s, t = input().split()
        flag = 0

        for ch in s :

            if ch not in t :
                print('No')
                flag = 1
                break ;
            else :
                idx = t.find(ch)
                t = t[idx+1:]


        if flag != 1 :
            print('Yes')
except:pass
