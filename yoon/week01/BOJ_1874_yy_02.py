n = int(input())
sequence = [int(input()) for _ in range(n)]

stack = []
operations = []
current = 1
possible = True

for num in sequence:
    while current <= num:
        stack.append(current)
        operations.append('+')
        current += 1
    if stack[-1] == num:
        stack.pop()
        operations.append('-')
    else:
        possible = False
        break

if possible:
    for op in operations:
        print(op)
else:
    print("NO")