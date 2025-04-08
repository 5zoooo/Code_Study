# 7주차 4번
import sys

def substring():
    for line in sys.stdin:
      s, t = line.strip().split()
      t_iter = iter(t)
      result = all(char in t_iter for char in s)
      print("Yes" if result else "No")

substring()

