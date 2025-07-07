import sys
sys.setrecursionlimit(10**6)
n= int(input())

graph = {i: [] for i in range(1, n + 1)}

for _ in range(n-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
    
answer = [0] * (n+1)
visited = set()
visited.add(1)
def vvip(k) : 
  for value in graph[k] :
    if value not in visited :
      answer[value] = k
      visited.add(value)
      vvip(value)
vvip(1)
for i in range(2, n + 1):
  print(answer[i])