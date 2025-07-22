from collections import deque 
import sys
input = sys.stdin.readline

n = int(input())

A = [[0] * n for _ in range(n)]

# 입력 받아서 A 구성
for i in range(n):
    grid = list(input().strip())
    for j in range(n):
        A[i][j] = int(grid[j])
        
    

def bfs(x, y) :
    queue = deque()
    queue.append((x, y))
    A[x][y] = 0
    count = 1
    while queue :
        x, y = queue.popleft()
        for i in range(4) :
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and A[nx][ny] == 1 :
                A[nx][ny] = 0
                queue.append((nx, ny))
                count += 1
    return count

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

result = []
for i in range(n) :
    for j in range(n) :
        if A[i][j] == 1 :
            result.append(bfs(i, j))

result.sort()
print(len(result))
for i in result :
    print(i)