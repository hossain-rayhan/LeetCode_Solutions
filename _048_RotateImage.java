//Cracking the Coding Interview- Chapter1- 1.7 Rotate Matrix

class Solution {
    public void rotate(int[][] matrix) {
        int l = matrix.length;
        if(l <= 1)
            return;
        for(int layer = 0; layer < l/2; layer++){
            int start = layer;
            int end = (l-1)-layer;
            for(int i = start; i < end; i++){
                int offset = i - start;
				int top = matrix[start][i];

				//top <- left
				matrix[start][i] = matrix[end-offset][start];

				//left <- bottom
				matrix[end-offset][start] = matrix[end][end-offset];

				//bottom <- right
				matrix[end][end-offset] = matrix[i][end];

				//right <- top
				matrix[i][end] = top;
            }
        }
    }
}
