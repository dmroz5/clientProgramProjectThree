import java.io.Serializable;

public class CFourInfo implements Serializable {
    String p1Plays;
    String p2Plays;
    Boolean twoPlayers;

    public Boolean validMove(GameBoard board, GameButton button)  {
        int row = button.getRow();
        if (row == 5) {
            return true;
        }
        else{
            // if button under desired button is not empty
            if (board.getGameButton(row + 1, button.getCol()).getColor() == 'n') {
                return false;
            }
            else {
                return true;
            }
        }
    }

    public Boolean checkVerticalWin(GameBoard board, int rowMax, char color, int buttonRow, int buttonCol) {
        int count = 0;

        for (int i = 1; i < 4; i++) {
            if (buttonRow + i > rowMax) {
                break;
            }
            if ( board.getGameButton(buttonRow + i, buttonCol).getColor() == color ) {
                count++;
            }
            else {
                break;
            }
        }
        if (count == 3) {
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean checkHorizontalWin(GameBoard board, int colMax, char color, int buttonRow) {
        int count = 0;
        for (int c = 0; c < colMax; c++) {
            if (board.getGameButton(buttonRow, c).getColor() == color) {
                count++;
            }
            else {
                count = 0;
            }
            if (count >= 4) {
                return true;
            }
        }
        return false;
    }

    public Boolean checkAscendingWin(GameBoard board, int rowMax, int colMax, char color, int currRow, int currCol) {
        int count = 0;

        // Start from lower left corner
        while ((currRow + 1 <= rowMax) && (currCol - 1 >= 0)) {
            currRow++;
            currCol--;
        }
        count = 0;
        for (int i = 0; i < 6; i++) {
            if ((currRow < 0) || currCol > colMax) {
                break;
            }
            else {
                if (board.getGameButton(currRow, currCol).getColor() == color) {
                    count++;
                }
                else {
                    count = 0;
                }
                if (count >= 4) {
                    return true;
                }
                currRow--;
                currCol++;
            }
        }
        return false;
    }

    public Boolean checkDescendingWin(GameBoard board, int rowMax, int colMax, char color, int currRow, int currCol) {
        int count = 0;

        // Start from top left corner
        while ((currRow - 1 >= 0) && (currCol - 1 >= 0)) {
            currRow--;
            currCol--;
        }
        count = 0;
        for (int i = 0; i < 6; i++) {
            if ((currRow > rowMax) || currCol > colMax) {
                break;
            }
            else {
                if (board.getGameButton(currRow, currCol).getColor() == color) {
                    count++;
                }
                else {
                    count = 0;
                }
                if (count >= 4) {
                    return true;
                }
                currRow++;
                currCol++;
            }
        }
        return false;
    }

    // uses players most recent move to efficiently check for a win
    public Boolean checkWin(GameBoard board, GameButton button) {
        int rowMax = 5;
        int colMax = 6;
        char color = button.getColor();
        int buttonRow = button.getRow();
        int buttonCol = button.getCol();


        if (checkVerticalWin(board, rowMax, color, buttonRow, buttonCol) || checkHorizontalWin(board, colMax, color, buttonRow)
                || checkAscendingWin(board, rowMax, colMax, color, buttonRow, buttonCol) ||
                checkDescendingWin(board, rowMax, colMax, color, buttonRow, buttonCol)) {
            return true;
        }
        else {
            return false;
        }

    }
}
