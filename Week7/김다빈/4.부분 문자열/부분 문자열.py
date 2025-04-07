while True:
    try:
        n, m = str(input()).split()
        tmpStr = ""
        nIdx = 0
        mIdx = 0

        while True:
            if tmpStr == n:
                print("Yes")
                break
            if nIdx >= len(n) or mIdx >= len(m):
                print("No")
                break

            if n[nIdx] == m[mIdx]:
                tmpStr += m[mIdx]
                nIdx += 1
                mIdx += 1
            else:
                mIdx += 1

    except:
        break
