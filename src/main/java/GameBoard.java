public class GameBoard {
    private GameButton[][] board;
    private int currPlayer;

    public GameBoard() {
        board = new GameButton[6][7];
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                board[row][col] = new GameButton(row, col);
            }
        }
    }

    public GameButton getGameButton(int row, int col) {
        return board[row][col];
    }

    public void setGameButton(GameButton button) {
        board[button.getRow()][button.getCol()] = button;
    }

    public GameButton[][] getBoard() {
        return board;
    }

    public void setBoard(GameButton[][] board) {
        this.board = board;
    }
}
