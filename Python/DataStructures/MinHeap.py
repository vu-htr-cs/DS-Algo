class PriorityQueue:
    def __init__(self):
        self.__arr=[]
        self.__n=-1
    def heapify(self,n,i):
        smallest=i
        left=2*i+1
        right=2*i+2
        if(left<=n and self.__arr[left] < self.__arr[smallest] ):# left <= n-1
            smallest=left
        if(right<=n and self.__arr[right] < self.__arr[smallest] ):
            smallest=right
        if(smallest!=i):
            self.swap(i,smallest)
            self.heapify(n,smallest) 
    def runMinHeap(self):
        i=(self.__n-1)>>1 
        while(i>=0):
            self.heapify(self.__n,i)
            i-=1
    def minHeapSort(self):
        self.runMinHeap()
        i=self.__n
        while(i>0):
            self.swap(0,i) 
            i-=1
            self.heapify(i,0)
    def swap(self,a,b):
        self.__arr[a],self.__arr[b]=self.__arr[b],self.__arr[a]
    def addMin(self,e):
        if(len(self.__arr)==0):
            self.__arr.append(e)
            self.__n=0
        else:
            self.__n+=1
            self.__arr.append(e)
            k=self.__n
            while(k>0 and self.__arr[k] < self.__arr[(k-1)>>1]):
                #Node cha lon hon Node k -> doi lai cho cha be hon con
                self.swap((k-1)>>1,k)
                k=(k-1)>>1
    def deleteOne(self,v):
        self.__arr.remove(v)
        self.__n-=1
    def showMinimum(self):
        self.minHeapSort()
        return self.__arr[self.__n]    
    def getArr(self):
        return self.__arr
if __name__=="__main__":
    n=int(input().strip())
    queries=[]
    for _ in range(n):
        queries.append(list(map(int, input().strip().split() )))
    pq=PriorityQueue()
    for item in queries:
        if(len(item)==1):
            print(pq.showMinimum())
        elif item[0]==2:
            pq.deleteOne(item[1])
        else:
            pq.addMin(item[1])
            
            
