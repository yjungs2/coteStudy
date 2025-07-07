import sys
input = sys.stdin.readline

n, m, a = map(int, input().split())

second = [['O'] * m for _ in range(n)]
A = [row[:] for row in second]  

# 입력 받아서 A 구성
stack = []
for i in range(n):
    grid = list(input().strip())
    for j in range(m):
        A[i][j] = grid[j]
        if A[i][j] == 'O' : 
            stack.append((i,j))
        
        
# 1단계: 초기 상태 복사
first = [row[:] for row in A]

A = [['O'] * m for _ in range(n)]

for i, j in stack:
    A[i][j] = '.'
    if i > 0:
        A[i-1][j] = '.'
    if i < n - 1:
        A[i+1][j] = '.'
    if j > 0:
        A[i][j-1] = '.'
    if j < m - 1:
        A[i][j+1] = '.'

third = [row[:] for row in A]

if a == 1:
    answer = first
elif a % 2 == 0 :
    answer = second
elif a % 4 == 3 :
    answer = third
else:  
    answer = first

for row in answer:
    print(''.join(row))