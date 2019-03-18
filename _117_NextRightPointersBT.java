/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        //return connectNext(root);
        connectNext2(root);
        return root;
    }
    //level order traversal- in-place; Space O(1), Time O(N)
    public void connectNext2(Node root){
        Node prev = null, head = null, current = root;
        while(current != null){
            //traverse current level
            while(current != null){
                //traverse the left child
                if(current.left != null){
                    if(prev != null){
                        prev.next = current.left;
                    }else{
                        head = current.left;
                    }
                    prev = current.left;
                }
                
                //traverse the right child
                if(current.right != null){
                    if(prev != null){
                        prev.next = current.right;
                    }else{
                        head = current.right;
                    }
                    prev = current.right;
                }
                //update the current on this level
                current = current.next;
            }
            
            //go to the next level
            current = head;
            prev = null;
            head = null;
        }
    }
    
    //level order traversal- Space: O(2^level)
    public Node connectNext(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size-1; i++){
                Node n = queue.remove();
                
                n.next = queue.peek();
                if(n.left != null) queue.add(n.left);
                if(n.right != null) queue.add(n.right);
            }
            Node last = queue.remove();
            if(last.left != null) queue.add(last.left);
            if(last.right != null) queue.add(last.right);
        }
        return root;
    }
}
