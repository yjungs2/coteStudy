N = int(input())
sum = 0
num = 0
for i in range(1,N+1) :
    sum += i
    if sum > N :     
       break;
    else :
      num+=1
        
print(num)   