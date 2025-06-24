N = int(input())
A = list(map(int,input().split()))

from collections import deque
queue = deque([(i+1, value) for i, value in enumerate(A)])
answer = []
while queue :
  idx,value = queue.popleft()
  answer.append(idx)
  if not queue :
    break
  if value > 0:
    queue.rotate(-(value-1))
  else :
    queue.rotate(-1 * value)
print(*answer)

# deque() 에서 rotate는 회전하는 함수로써 양수일떄는 -(value) 만큼, 음수일떄는 (-value) 만큼 회전합니다.
# 하지만 주어진 조건은 1은 뺴고 회전하는거기 떄문에 양수 일때 -(value -1) 만큼 이동합니다. 