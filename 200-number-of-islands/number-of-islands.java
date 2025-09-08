class Solution {
    
    class Pair {  // to store cell coordinates
        int row, col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public void bfs(char[][] grid, boolean[][] isVisited, Queue<Pair> q) {
        // 4-directional movement: up, right, down, left
        int[] directionX = {-1, 0, 1, 0};
        int[] directionY = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Pair p = q.remove();
            for (int i = 0; i < 4; i++) {  // Explore all 4 directions
                int row = p.row + directionX[i];
                int col = p.col + directionY[i];
                if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length 
                    && grid[row][col] == '1' && !isVisited[row][col]) {
                    // Check bounds + must be land (1) + not visited before
                    isVisited[row][col] = true;
                    q.add(new Pair(row, col));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int componentCount = 0;
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];   // to track already explored land cells
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    // Found a new land cell that is not visited
                    Queue<Pair> q = new LinkedList<>();
                    q.add(new Pair(i, j));  // Add it to queue
                    isVisited[i][j] = true; // mark this position as visited
                    bfs(grid, isVisited, q);
                    componentCount++;
                }
            }
        }
        return componentCount;  // total islands
    }
}