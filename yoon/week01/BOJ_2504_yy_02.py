
from collections import deque
inputs = input()
datas = list(inputs)
answer = 0
cnt = 1
stack = deque()
for i in range(len(datas)) :

  if datas[i] == '(' :
    cnt *= 2
    stack.append('(')
  if datas[i] == '[' :
    cnt *= 3
    stack.append('[')
  if datas[i] == ')' :
    if not stack or stack[-1] == '[':
      answer = 0
      break
    if datas[i-1] == '(' :
      answer += cnt

    stack.pop()
    cnt //= 2
    
  if datas[i] == ']' :
    if not stack or stack[-1] == '(' :
      answer = 0
      break
    if datas[i-1] == '[' :
      answer += cnt
    stack.pop()
    cnt //= 3
 
if not stack:
    print(answer)
else:
    print(0)


# BOJ 2504 문제
# 여기서 핵심은 ']' 나 ')' 일때 아닌 경우를 찾아주는 경우라고 본다.
# 그리고 i-1이 '(' 이고, i가 ')' 인 경우 이후에 나오는 ] 나 ) 를 한들 다른 계산이 들어가지는
# 않지만 기본적으로 위에서 append 한 만큼의 pop이 들어가줘야한다. 
# 그리고 이 문제에 핵심은 cnt 라는 중간에 연산을 해주는 매개체를 사용하는 것 생각이 든다.
# 중간에서 연산을 해주고 () 가 일어났을떄 answer += cnt 를 해주어서 더해주고 하는 방식이다.