class Node:
    def __init__(self, item):
        self.item = item
        self.left = None
        self.right = None

n1 = Node(1)
n2 = Node(2)
n3 = Node(3)
n4 = Node(4)
n5 = Node(5)
n6 = Node(6)
n7 = Node(7)
n8 = Node(8)
n9 = Node(9)
n10 = Node(10)

class binaryTree():
    def __init__(self):
        self.root = None

def inorder(n):
    if n != Node:
        if n.left:
            inorder(n.left)
        print(n.item,' ', end='')
        if n.right:
            inorder(n.right)


tree = binaryTree()

tree.root = n1
n1.left = n2
n1.right = n3
n2.left = n4
n4.left = n7
n4.right = n8
n8.left = n10
n3.left = n5
n3.right = n6
n6.left = n9

inorder(n1)