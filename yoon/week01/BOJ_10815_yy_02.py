import sys

N = int(sys.stdin.readline())
A = set(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())
B = list(map(int, sys.stdin.readline().split()))

answer = []
for v in B:
    if v in A:
        answer.append(1)
    else:
        answer.append(0)

# 정보 : print(*list) 는 리스트 안의 값들을 각각 꺼내서 공백을 두고 출력합니다.
print(*answer) 

