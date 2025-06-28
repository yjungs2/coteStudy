n= int(input())
m=int(input())

graph = {i: [] for i in range(1, n + 1)}

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
    
from collections import deque
visited = set()
queue = deque()
start = 1
for value in graph[1] :
  queue.append((1,value))
  queue.append((1, value))
  visited.add(value) 
answer = 0
visited.add(1)
while queue :
  start,next = queue.popleft()
  for value in graph[next] : 
    if value not in visited :
      queue.append((next,value))
      visited.add(value)
answer = len(visited) -1
print(answer)