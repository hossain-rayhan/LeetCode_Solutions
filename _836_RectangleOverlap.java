//consider the value as (left, bottom, right, top)
//l1,b1,r1,t1 = rec1
//l2,b2,r2,t2 = rec2
//check if overlaping width and height are positive
//width = min(r1,r2) - max(l1,l2)
//height = min(t1,t2) - max(b1,b2)
//return width > 0 and height > 0

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int width = Math.min(rec1[2], rec2[2]) - Math.max(rec1[0], rec2[0]);
        int height = Math.min(rec1[3], rec2[3]) - Math.max(rec1[1], rec2[1]);
        
        return width > 0 && height > 0;
    }
}
