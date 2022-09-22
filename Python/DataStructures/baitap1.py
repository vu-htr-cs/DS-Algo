from turtle import shape
import numpy as np
from collections import deque
mecung=[['O','X','O','O'],
        ['X','O','X','O'],
        ['X','O','E','X'],
        ['X','O','O','X'],
        ['X','O','X','X']]
#Nha tham hiem chi di theo cai co canh chung -> (x,y) =>{ (x-1,y),(x,y+1),(x,y-1),(x+1,y) }
# bieu dien ma tran ke thi phai dung ma tran vuong
# xay dung danh sach ke
# ma tran m x n

# listedges=[] 
# for i in range(0,len(mecung)):
#     temp=[]
#     for j in range(0,len(mecung[0])):
#         if(mecung[i][j]=='O'):
#             temp.append(j)
#         elif mecung[i][j]=='E':
#             x,y=i,j
#     listedges.append(temp)

def DFS(start):
    trace=[[(-1,-1),(-1,-1),(-1,-1),(-1,-1)]
    ,[(-1,-1),(-1,-1),(-1,-1),(-1,-1)]
    ,[(-1,-1),(-1,-1),(-1,-1),(-1,-1)]
    ,[(-1,-1),(-1,-1),(-1,-1),(-1,-1)]
    ,[(-1,-1),(-1,-1),(-1,-1),(-1,-1)]]
    q=deque()
    q.append(start)
    while(len(q)!=0):
        x,y=q.popleft()
        if(x==0 or y==0 or x==len(mecung)-1 or y==len(mecung[0])-1):
            if(mecung[x][y]=='X'):
                continue
            else:
                break
        if(mecung[x-1][y]=='O' and trace[x-1][y]==(-1,-1)):
            q.append((x-1,y))
            trace[x-1][y]=(x,y)
        if(mecung[x][y+1]=='O' and trace[x][y+1]==(-1,-1)):
            q.append((x,y+1))
            trace[x][y+1]=(x,y)
        if(mecung[x][y-1]=='O' and trace[x][y-1]==(-1,-1)):
            q.append((x,y-1))
            trace[x][y-1]=(x,y)
        if(mecung[x+1][y]=='O' and trace[x+1][y]==(-1,-1)):
            q.append((x+1,y))
            trace[x+1][y]=(x,y)
    if x==0 or y==0 or x==len(mecung)-1 or y==len(mecung[0])-1 :
        while((x,y)!=start):
            print("({0},{1})".format(x,y),end=" <- ")
            x,y=trace[x][y]
        print(start)
    else:
        print("Khong tim thay duong ra")
#DFS((2,2))
