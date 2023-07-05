package bl4ckspell7.tictactoe;

import android.widget.Button;

public class GameBoard {
    private final Button[][] cells;

    public GameBoard(Button[][] cells) {
        this.cells = cells;
    }

    public void clearBoard() {
        for (Button[] cell : cells) {
            for (Button button : cell) {
                button.setText("");
            }
        }
    }

    public void setCellText(int row, int column, String text) {
        cells[row][column].setText(text);
    }

    public String getCellText(int row, int column) {
        return cells[row][column].getText().toString();
    }

    public int getSize() {
        return cells.length;
    }
}
