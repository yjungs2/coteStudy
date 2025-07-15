n = int(input())

plus = []
minus = []

result = 0
for _ in range(n) :
    num = int(input())
    if num > 1 :
        plus.append(num)
    elif num <= 0 :
        minus.append(num)
    else : 
        result += num

def calculator(arr, reverse=False):
    arr.sort(reverse=reverse)
    temp = 0
    for i in range(0, len(arr), 2):
        if i + 1 >= len(arr):
            temp += arr[i]
        else:
            temp += arr[i] * arr[i+1]
    return temp

result += calculator(plus, reverse=True)
result += calculator(minus)

print(result)