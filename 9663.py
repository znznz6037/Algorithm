import numpy as np

col = np.zeros(15)
N = int(input())
cnt = 0

def dfs(row):
    global cnt, N
    if(row > N):
        cnt += 1
        return
    else:
        for i in range(1, N + 1):
            col[row] = i
            if(isPromising(row)): dfs(row + 1)
            else: col[row] = 0

def isPromising(row):
    for i in range(1, row):
        if(col[i] == col[row]):return False
        if(abs(col[i] - col[row]) == abs(i -row)):return False
    return True

for i in range(1, N + 1):
    col = np.zeros(15)
    col[1] = i
    dfs(2)

print(cnt)

