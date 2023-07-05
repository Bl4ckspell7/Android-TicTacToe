package bl4ckspell7.tictactoe;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameView {
    private final Button[][] cells;
    private final TextView textViewTitle;
    private final Button buttonReset;

    public GameView(Button[][] cells, TextView textViewTitle, Button buttonReset) {
        this.cells = cells;
        this.textViewTitle = textViewTitle;
        this.buttonReset = buttonReset;
    }

    public void setCellClickListener(View.OnClickListener listener) {
        for (Button[] cell : cells) {
            for (Button button : cell) {
                button.setOnClickListener(listener);
            }
        }
    }

    public void setResetButtonClickListener(View.OnClickListener listener) {
        buttonReset.setOnClickListener(listener);
    }

    public void setTitleText(String text) {
        textViewTitle.setText(text);
    }
}

