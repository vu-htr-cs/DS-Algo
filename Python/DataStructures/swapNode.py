from collections import deque
class Node:
    def __init__(self,data):
        self.data=data
def buildTree(indexes):
    f= lambda x:None if x==-1 else Node(x)
    children=[list(map(f,x)) for x in indexes] #input data is two-dimension (iterable)
    nodes={n.data: n for n in filter(None,sum(children,[]) )} # sum() = concatenate list -> flatten the Node
    nodes[1]=Node(1)
    #nodes is a dictionary to store node
    for index,child_pair in enumerate(children):
        nodes[index+1].left=child_pair[0]
        nodes[index+1].right=child_pair[1]
    return nodes[1]
def inOrder(root):
    stack=[]
    cur=root 
    while stack or cur:
        if cur:
            stack.append(cur)
            cur=cur.left
        elif stack:
            cur=stack.pop()
            yield cur.data
            cur=cur.right
def swapNodes(indexes,queries):
    root=buildTree(indexes)
    for k in queries:
        h=1
        q=deque([root])
        while q:
            for _ in range(len(q)):
                node=q.popleft()
                if h%k==0 :
                    node.left,node.right=node.right,node.left
                q+=filter(None,[node.left,node.right])
            h+=1
        yield inOrder(root)