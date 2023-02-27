/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node constructQuadTree(int[][]grid, int rowStart, int rowEnd, int colStart, int colEnd){
        if(rowStart > rowEnd || rowEnd > rowEnd) return null;

        boolean isLeaf = true;
        int val = grid[rowStart][colStart];
        for(int i = rowStart; i <= rowEnd; i++){
            for(int j = colStart; j <= colEnd; j++){
                if(grid[i][j] != val){
                    isLeaf = false;
                    break;
                }
            }
            if(!isLeaf) break;
        }

        if(isLeaf){
            if(val == 1){
                return new Node(true, true);
            }
            return new Node(false, true);
        }

        int rowMid = (rowStart + rowEnd)/2;
        int colMid = (colStart + colEnd)/2;

        Node topLeft = constructQuadTree(grid, rowStart, rowMid, colStart, colMid);
        Node topRight = constructQuadTree(grid, rowStart, rowMid, colMid + 1, colEnd);
        Node bottomLeft = constructQuadTree(grid, rowMid + 1, rowEnd, colStart, colMid);
        Node bottomRight = constructQuadTree(grid, rowMid + 1, rowEnd, colMid + 1, colEnd);
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
    public Node construct(int[][] grid) {
        int n = grid.length;
        return constructQuadTree(grid, 0, n - 1, 0, n - 1);
    }
}