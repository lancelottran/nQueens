int[][] nQueens(int n) {
    boolean[][] board = new boolean[n][n];
    slove(board, 0);
    
    return ans.toArray(new int[0][]);
}

List<int[]> ans = new ArrayList<int[]>();

boolean slove(boolean[][] board, int col){
    if(col == board.length)
    {
        int[] a = new int[board.length];
        
        for(int c = 0; c < board.length; c++)
            for(int r = 0; r < board.length; r++)
                if(board[r][c])
                    a[c] = r+1;
        
        ans.add(a);
        
        return true;
    }
    
    boolean res = false;
    
    for(int i = 0; i < board.length; i++){
        if(is_safe(board, i, col)){
            board[i][col] = true;
            
            res = slove(board, col + 1) || res;
            
            board[i][col] = false;
        }
    }
    
    return res;
}

boolean is_safe(boolean[][] board, int row, int col){  
    
    //check curr row to left
    for(int i = 0; i < col; i++){
        if(board[row][i])
            return false;
    }
    
    //upper left diagonal
    for(int i = row, j = col; i >= 0 && j >= 0; i--, j--)
        if(board[i][j])
            return false;
    
    //down left diagonal
    for(int i = row, j = col; i < board.length && j >= 0; i++, j--)
        if(board[i][j])
            return false;
    
    return true;
}
