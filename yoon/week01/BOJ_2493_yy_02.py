from collections import deque
N = int(input())
datas = list(map(int,input().split()))

answer = [0] * len(datas)
stack = deque()

for i in range(len(datas)-1,-1,-1) :
  while stack and datas[i] >= datas[stack[-1]] :
    idx = stack.pop()
    answer[idx] = i + 1
  stack.append(i)

print(*answer)

# stack 을 아직 해결하지 못한 index로 보고 풀었다.
# deque는 pop() popleft() 가 모두 O(1) 이므로 적절하다고 보았다.
# print(*answer)은 리스트를 공백을 기준으로 한 칸 띄워서 출력한다.
# ex) print(*answer) ==> 출력 : 0 0 2 2 4