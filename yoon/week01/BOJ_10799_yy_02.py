datas = list(input())

from collections import deque
stack = deque()
answer = 0 
for i in range(len(datas)) : 
  if datas[i] == '(' :
    stack.append('(')
  else :
    stack.pop()
    if datas[i-1] == '(' :
      answer += len(stack)
    else :
      answer += 1
print(answer) 