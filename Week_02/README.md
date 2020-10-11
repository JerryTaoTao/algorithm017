本周总结
二叉树前中后续统一代码编写方式
```
         LinkedList<TreeNode> stack = new LinkedList<>();
         List<Integer> result = new ArrayList<>();
         if (root == null) return  result;
         while (stack.size() > 0 || root != null) {
 
             while (root != null) {
                 //前序遍历一直往左走，在走的过程中，将访问的节点作为处理节点加入返回List
                 ${不同点1}
                 stack.add(root);
                 root = root.left;
             }
             //左边走完以后，代表着左边的路线完成了遍历，接着处理stack里面的每个节点的右节点
             TreeNode treeNode = stack.removeLast();
             ${不同点2}
 
         }
         return result;
```
## 不同点1
前序需要将访问的节点加入result list

## 不同点2

前序遍历：直接访问拿出栈的右节点
中序遍历：将从栈拿出的元素加入到result list，并访问其右节点
后续遍历：判断从栈里面拿出的元素，如果没有右节点可以访问
或者上次弹出的元素是其右孩子(表示右孩子上次被处理)，那么直接处理改节点，并将该节点标记为已经处理过
，否则表示当前节点右孩子还没处理，那么当前节点重新入栈，然后处理其右孩子
