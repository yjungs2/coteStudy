N = int(input())
for _ in range(N) :
  M,K = map(int,input().split())
  A = list(map(int,input().split()))
  A_col = A.copy()
  A_index = [i for i in range(len(A))]
  B = list()
  B_index = list()
  while len(B) != len(A_col) :
    max_A = max(A)
    minx=-1
    for i in range(len(A)) :
      if max_A == A[i] :
        minx = i
        break
    A = A[minx:] + A[:minx]
    A_index = A_index[minx:] + A_index[:minx]
    B.append(A.pop(0))
    B_index.append(A_index.pop(0))
  print(B_index.index(K) + 1)
