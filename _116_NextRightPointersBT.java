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
        connectNext(root);
        return root;
    }
    
    public void connectNext(Node root){
        Node prev = null, levelHead = null, current = root;
        while(current != null){
            //traverse current level
            while(current != null){
                //traverse the left 
                if(current.left != null){
                    if(prev != null){
                        prev.next = current.left;
                    }else{
                        levelHead = current.left;
                    }
                    prev = current.left;
                }
                
                //traverse the right
                if(current.right != null){
                    if(prev != null){
                        prev.next = current.right;
                    }else{
                        levelHead = current.right;
                    }
                    prev = current.right;
                }
                
                //update current to next position
                current = current.next;
            }
            
            //go to the next level
            current = levelHead;
            prev = null;
            levelHead = null;
        }
    }
}
