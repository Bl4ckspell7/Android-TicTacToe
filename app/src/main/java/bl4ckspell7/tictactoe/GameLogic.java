package bl4ckspell7.tictactoe;

public class GameLogic {
    private static final String WINNER = "Winner: ";
    private static final String DRAW = "Draw!";
    private Player currentPlayer;
    private final GameBoard gameBoard;
    private final GameView gameView;
    private final Player player1;
    private final Player player2;
    private boolean gameEnded;

    public GameLogic(GameBoard gameBoard, GameView gameView, Player player1, Player player2) {
        this.gameBoard = gameBoard;
        this.gameView = gameView;
        this.player1 = player1;
        this.player2 = player2;
        resetGame();
    }

    public void cellClicked(int row, int column) {
        if (!gameEnded && gameBoard.getCellText(row, column).isEmpty()) {
            gameBoard.setCellText(row, column, currentPlayer.getSymbol());
            if (checkWin(row, column)) {
                gameEnded = true;
                gameView.setTitleText(WINNER + currentPlayer.getName());
            } else if (checkDraw()) {
                gameEnded = true;
                gameView.setTitleText(DRAW);
            } else {
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
                setGameViewTitle();
            }
        }
    }

    private boolean checkWin(int row, int column) {
        String symbol = gameBoard.getCellText(row, column);
        int gameBoardSize = gameBoard.getSize();

        // Check the row
        boolean rowWin = true;
        for (int c = 0; c < gameBoardSize; c++) {
            if (!gameBoard.getCellText(row, c).equals(symbol)) {
                rowWin = false;
                break;
            }
        }

        // Check the column
        boolean columnWin = true;
        for (int r = 0; r < gameBoardSize; r++) {
            if (!gameBoard.getCellText(r, column).equals(symbol)) {
                columnWin = false;
                break;
            }
        }

        // Checking the main diagonal
        boolean mainDiagonalWin = true;
        for (int i = 0; i < gameBoardSize; i++) {
            if (!gameBoard.getCellText(i, i).equals(symbol)) {
                mainDiagonalWin = false;
                break;
            }
        }

        // Checking the secondary diagonal
        boolean antiDiagonalWin = true;
        for (int i = 0; i < gameBoardSize; i++) {
            if (!gameBoard.getCellText(i, gameBoard.getSize() - 1 - i).equals(symbol)) {
                antiDiagonalWin = false;
                break;
            }
        }

        // Check whether one of the cases applies to a win
        return rowWin || columnWin || mainDiagonalWin || antiDiagonalWin;
    }


    private boolean checkDraw() {
        // Check if all cells are occupied
        for (int row = 0; row < gameBoard.getSize(); row++) {
            for (int column = 0; column < gameBoard.getSize(); column++) {
                if (gameBoard.getCellText(row, column).isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void resetGame() {
        gameBoard.clearBoard();
        currentPlayer = player1;
        gameEnded = false;
        setGameViewTitle();
    }

    private void setGameViewTitle() {
        gameView.setTitleText(currentPlayer.getName() + " (" + currentPlayer.getSymbol() + ")");
    }
}
