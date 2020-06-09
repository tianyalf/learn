package binarySortTree;

/**
 * @date:2020-02-17 8:45
 * @author:天涯沦落人
 * @Description:二叉排序树
 */
public class BinarySortTree01 {
    public static void main(String args[]) {
        int[] arr = {7, 3, 10, 12, 11, 13, 14, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        binarySortTree.infixOrder();
//        binarySortTree.delNode(2);
//        binarySortTree.delNode(1);
        System.out.println();
        binarySortTree.delNode(10);
        binarySortTree.infixOrder();
    }

}

class BinarySortTree {
    Node root;

    //查找要删除的结点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    //查找父结点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     * 1.返回以node为根结点的二叉排序树的最小结点的值
     * 2.删除以node为根结点的二叉排序树的最小结点
     *
     * @param node 传入的结点（当做二叉排序树的根结点）
     * @return 返回的是以node为根结点的二叉排序树的最小结点的值
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        //循环查找左结点，就会找到最小值
        while (target.left != null) {
            target = target.left;
        }
        //这时，target就指向了最小结点

        //删除最小结点
        delNode(target.value);
        return target.value;
    }

    //删除结点
    public void delNode(int value) {
        Node targetNode = null;//要删除的结点
        Node parent = null;//要删除的结点的父结点
        if (root == null) {
            return;
        } else {
            //1.需要先去找到要删除的结点，targetNode
            targetNode = search(value);
            //如果没有找到要删除的点
            if (targetNode == null) {
                return;
            }
            //如果我们发现当前这棵二叉树只有一个结点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }

            //查找targetNode的父结点
            parent = searchParent(value);
            //1.如果要删除的结点是叶子结点
            if (targetNode.left == null && targetNode.right == null) {
                //如果targetNode是parent的左子结点
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;
                    //如果targetNode是parent的右子结点
                } else if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
                //2.如果要删除的结点有两个子结点
            } else if (targetNode.left != null & targetNode.right != null) {
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;

                //3.如果要删除的结点有一个子结点
            } else {
                //3.1如果targetNode有左子结点
                if (targetNode.left != null) {
                    //如果targetNode是parent的左子结点
                    if (parent.left.value == value) {
                        parent.left = targetNode.left;
                        //如果targetNode是parent的右子结点
                    } else if (parent.right.value == value) {
                        parent.right = targetNode.left;
                    }
                } else {
                    //3.2如果targetNode有右子结点
                    //如果targetNode是parent的左子结点
                    if (parent.left.value == value) {
                        parent.left = targetNode.right;
                        //如果targetNode是parent的右子结点
                    } else if (parent.right.value == value) {
                        parent.right = targetNode.right;
                    }
                }
            }
        }
    }

    //添加结点
    public void add(Node root) {
        if (this.root == null) {
            this.root = root;
        } else {
            this.root.add(root);
        }
    }

    //中序遍历二分排序树
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二分排序树为空，不能遍历。。。");
        }
    }
}

class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 查找要删除的结点
     *
     * @param value 希望删除的结点的值
     * @return 如果找到则返回该结点，否则返回null
     */
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     * 查找要删除结点的父结点
     *
     * @param value 要找到的结点的值
     * @return 返回的是要删除的结点的父结点，如果没有就返回null
     */
    public Node searchParent(int value) {
        //如果当前结点就是要删除的结点的父结点，就返回
        if ((this.left != null && this.left.value == value) ||
                this.right != null && this.right.value == value) {
            return this;
        } else {
            //如果查找的值小于当前结点的值，并且当前结点的左子结点不为空
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);//向左子树递归查询
                //如果要查找的值大于当前结点的值，并且当前结点的右子结点不为空
            } else if (value > this.value && this.right != null) {
                return this.right.searchParent(value);//向右子树递归查询
            } else {
                return null;//没有找到父结点
            }
        }
    }

    @Override
    public String toString() {
        return "[" + this.value + "]";
    }

    //添加结点
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.print(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}
