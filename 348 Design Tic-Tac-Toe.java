class TicTacToe {

    /** Initialize your data structure here. */
    int[][] count;
    int n;
    public TicTacToe(int n) {
        count = new int[2][2 * n + 2];
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (++count[player - 1][row] == n) {
            return player;
        }
        if (++count[player - 1][col + n] == n) {
            return player;
        } 
        if (row == col && ++count[player - 1][2 * n] == n) {
            return player;
        }
        if (row + col == n - 1 && ++count[player - 1][2 * n + 1] == n) {
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */