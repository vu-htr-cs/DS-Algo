from collections import deque
mymap={1:{2,3},2:{3,4},4:{6},3:{5},7:{8},5:{},6:{},8:{}}
listedges=[]
listedges.append([])
listedges.append([2,3])
listedges.append([3,4])
listedges.append([5])
listedges.append([6])
listedges.append([])
listedges.append([])
listedges.append([8])
listedges.append([])

tracy=[]
for i in range(0,9):
    tracy.append(0)
tracy[1]=-1

def BFS(start,goal):
    trace=[]
    for node in mymap.keys():
        trace.append((node,None))
    trace=dict(trace)
    q=deque()
    q.append(start)
    while(len(q)!=0):
        u=q.popleft()
        for v in mymap[u]:
            trace[v]=u       
            q.append(v)
    v=goal
    if(trace[v]!=None):
        while(v!=start):
            print(v,end=" <- ")
            v=trace[v]
        print(start)

def DFS(start):
    for v in mymap[start]:
        if(tracy[v]==0):
            tracy[v]=start
            DFS(v)
            
def DFS2(start):
    for v in listedges[start]:
        if(tracy[v]==0):
            tracy[v]=start
            DFS(v)
print('Hello world')