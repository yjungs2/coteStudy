from collections import deque
def solution(order):
    answer = 0
    current = 1
    stack = deque()
    for value in order :
        while current <= value :
            stack.append(current)
            current += 1
        if value == stack[-1] :
            stack.pop()
            answer += 1
        else :
            break      
    return answer

print(solution[4,3,1,2,5])