import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
A = [list(input()) for _ in range(n)]
visited = [[0]*n for _ in range(n)]
answer = [0, 0]

def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    visited[x][y] = 1

    while queue:
        x, y = queue.popleft()
        dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if 0 <= nx < n and 0 <= ny < n and A[x][y] == A[nx][ny] and not visited[nx][ny]:
                visited[nx][ny] = 1  
                queue.append((nx, ny))

for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            bfs(i, j)
            answer[0] += 1

for i in range(n):
    for j in range(n):
        if A[i][j] == 'G':
            A[i][j] = 'R'


visited = [[0]*n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            bfs(i, j)
            answer[1] += 1

print(*answer)