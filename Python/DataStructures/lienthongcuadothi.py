Matrix1=[[True,True,True,True,True,False,False,False,False,False,False,False],
        [True,True,False,False,False,False,False,False,False,False,False,False],
        [True,False,True,False,False,False,False,False,False,False,False,False],
        [True,False,False,True,False,False,False,False,False,False,False,False],
        [True,False,False,False,True,False,False,False,False,False,False,False],
        [False,False,False,False,False,True,True,True,False,False,False,False],
        [False,False,False,False,False,True,True,False,False,False,False,False],
        [False,False,False,False,False,True,False,True,False,False,False,False],
        [False,False,False,False,False,False,False,False,True,True,True,False],
        [False,False,False,False,False,False,False,False,True,True,False,False],
        [False,False,False,False,False,False,False,False,True,False,True,True],
        [False,False,False,False,False,False,False,False,False,False,True,True]
        ]
Free=[]
count=0
for k in range(0,12):
    Free.append(True)
    for u in range(0,12):
        for v in range(0,12):
            Matrix1[u][v]=Matrix1[u][v] or Matrix1[u][k] and Matrix1[k][v]
for i in range(0,12):
    if Free[i]:
        count=count+1
        print("Connected Component {0} ".format(count))
        for v in range(0,12):
            if Matrix1[i][v]:
                print(v+1,end=" , ")
                Free[v]=False
    print()

