class SoHang:
    def __init__(self,n,a):
        self.n=n
        self.a=a
        self.next=None
        self.pre=None
    def setNext(self,next):
        self.next=next
    def setPre(self,pre):
        self.pre=pre
class DaThuc:
    def __init__(self):
        self.head=None
        self.tail=None
        self.listnode=[]
    def addHead(self,node):
        if(self.head==None):
            self.head=node
            self.tail=node
        else:
            node.next=self.head.next
            self.head.next.pre=node
            self.head.next=node
            node.setPre(self.head)
    def addTail(self,node):
        if(self.tail==None):
            self.tail=node
            self.head=node
        else:
            self.tail.next=node
            node.setPre(self.tail)
            self.tail=node
    def printDathuc(self):
        pNode=self.head
        while(pNode!=None):
            print("{0}.x^{1}".format(pNode.a,pNode.n),end=" " )
            pNode=pNode.next
    def rutGon(self):
        pNode=self.head
        mydict={}
        while(pNode!=None):
            if pNode.n in mydict.keys():
                mydict[pNode.n]+=pNode.a
            else:
                mydict[pNode.n]=pNode.a
            pNode=pNode.next
        self.head=None
        self.tail=None
        for key in mydict.keys():
            temp=SoHang(key,mydict[key])
            self.addTail(temp)
            self.listnode.append( (key,mydict[key]) ) # n, a
    def CongDaThuc(self,dt2):
        res=DaThuc()
        pNode=self.head
        pNode2=dt2.head
        while(pNode!=None and pNode2!=None):
            res.addTail(SoHang(pNode.n,pNode.a+pNode2.a))
            pNode2=pNode2.next
            pNode=pNode.next
        if(pNode!=None):
            while(pNode!=None):
                res.addTail(SoHang(pNode.n,pNode.a))
                pNode=pNode.next
        elif(pNode2!=None):
            while(pNode2!=None):
                res.addTail(SoHang(pNode2.n,pNode.a))
                pNode2=pNode2.next
        return res
    def NhanDaThuc(self,dt2):
        self.rutGon()
        dt2.rutGon()
        mydict={}
        for i in range(len(self.listnode)):
            for j in range(len(dt2.listnode)):
                sumn=(self.listnode[i])[0]+(dt2.listnode[j])[0]
                if sumn in mydict.keys():
                   mydict[sumn]+=(self.listnode[i])[1]+(dt2.listnode[j])[1]
                else:
                    mydict[sumn]=(self.listnode[i])[1]+(dt2.listnode[j])[1]
        for key in mydict.keys():
            print(" {0}.x^{1} ".format(mydict[key],key),end="+")
if __name__=='__main__':
    myfunc=DaThuc()
    myfunc.addHead(SoHang(0,2))
    myfunc.addTail(SoHang(1,3))
    myfunc.addTail(SoHang(2,6))
    myfunc.addTail(SoHang(1,4))

    dt2=DaThuc()
    dt2.addTail(SoHang(0,4))
    dt2.addTail(SoHang(1,7))
    dt2.addTail(SoHang(4,6))
    myfunc.rutGon()

    myfunc.NhanDaThuc(dt2)
    
            

            