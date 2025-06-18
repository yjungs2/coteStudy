N = int(input())
S = input()
op = {'*','/','-','+'}
str_S = [ch for ch in S if ch not in op]
dict_nop = dict()
for i in sorted(set(str_S)) :
    dict_nop[i] = int(input())

from collections import deque
def cal(b,op,a) :
    if op == '+' :
        return b+a
    elif op == '-' :
        return b-a
    elif op == '*' :
        return b*a
    elif op == '/' :
        return b/a

queue = deque()
answer = 0
list_s = list(S)
for ins in list_s :
    if ins not in op :
        queue.append(dict_nop[ins])
    else :
        a = queue.pop()
        b = queue.pop()
        queue.append(cal(b,ins,a)) 

answer = queue.pop()

print("%.2f" % answer) 