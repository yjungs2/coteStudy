import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())
graph = {i: [] for i in range(1, n + 1)}

for _ in range(m):
    a, b = map(int, input().split())
    graph[b].append(a)
    
from collections import deque
def bfs(start) :
  visited = [False] * (n+1)
  queue = deque()
  visited[start] = True
  queue.append(start)
  count = 0
  while queue : 
    current = queue.popleft()
    for node in graph[current] :
      if not visited[node] :
        visited[node] = True
        queue.append(node)
        count += 1
  return count

answer = [0] * (n+1) 
max_count = 0
for i in range(1,n+1) :
  answer[i] = bfs(i)
  max_count = max(max_count,answer[i])

ans = []
for i in range(1,n+1) :
  if max_count == answer[i] :
    ans.append(i)
ans.sort()
print(*ans)
