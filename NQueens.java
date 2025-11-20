public class NQueens {

    static int N;  // size of the board

    // Function to print the solution board
    static void printBoard(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Check if a queen can be placed safely
    static boolean isSafe(int board[][], int row, int col) {

        // Check row on the left side
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Check upper diagonal on the left
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check lower diagonal on the left
        for (int i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Recursive function to solve the problem
    static boolean solveNQUtil(int board[][], int col) {

        // Base case: If all queens are placed
        if (col == N) {
            printBoard(board);
            return true;
        }

        boolean res = false;

        // Try placing a queen in each row of this column
        for (int i = 0; i < N; i++) {

            if (isSafe(board, i, col)) {

                board[i][col] = 1; // place queen

                // Recur for next column
                res = solveNQUtil(board, col + 1) || res;

                board[i][col] = 0; // backtrack
            }
        }

        return res;
    }

    // Main function
    public static void solveNQueens(int n) {
        N = n;
        int board[][] = new int[N][N];

        if (!solveNQUtil(board, 0)) {
            System.out.println("No solution exists");
        }
    }

    public static void main(String[] args) {
        int n = 4;  // You can change N here
        solveNQueens(n);
    }
}
