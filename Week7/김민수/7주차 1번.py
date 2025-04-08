# 7주차 1번

text1 = input()
text2 = str(input())

def find_str():
    only_str = ''.join([char for char in text1 if char.isalpha()])
    
    print(1 if text2 in only_str else 0)

find_str()