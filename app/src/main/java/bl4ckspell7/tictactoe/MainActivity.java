package bl4ckspell7.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private GameLogic gameLogic;
    private static final String PLAYER_1_NAME = "Player 1";
    private static final String PLAYER_2_NAME = "Player 2";
    private static final String PLAYER_1_SYMBOL = "X";
    private static final String PLAYER_2_SYMBOL = "O";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Player player1 = new Player(PLAYER_1_NAME, PLAYER_1_SYMBOL);
        Player player2 = new Player(PLAYER_2_NAME, PLAYER_2_SYMBOL);

        Button[][] cells = new Button[3][3];
        cells[0][0] = findViewById(R.id.button1);
        cells[0][1] = findViewById(R.id.button2);
        cells[0][2] = findViewById(R.id.button3);
        cells[1][0] = findViewById(R.id.button4);
        cells[1][1] = findViewById(R.id.button5);
        cells[1][2] = findViewById(R.id.button6);
        cells[2][0] = findViewById(R.id.button7);
        cells[2][1] = findViewById(R.id.button8);
        cells[2][2] = findViewById(R.id.button9);

        GameView gameView = new GameView(cells, findViewById(R.id.textViewTitle), findViewById(R.id.buttonReset));
        gameView.setCellClickListener(this);
        gameView.setResetButtonClickListener(this);
        gameView.setResetButtonClickListener(this);

        gameLogic = new GameLogic(new GameBoard(cells), gameView, player1, player2);
    }

    @Override
    public void onClick(View v) {
        if (v instanceof Button) {
            if (v.getId() == R.id.buttonReset) {
                gameLogic.resetGame();
            } else {
                Button clickedButton = (Button) v;
                int row = getRowFromButtonId(clickedButton.getId());
                int column = getColumnFromButtonId(clickedButton.getId());
                gameLogic.cellClicked(row, column);
            }
        }
    }

    private int getRowFromButtonId(int buttonId) {
        if (buttonId == R.id.button1 || buttonId == R.id.button2 || buttonId == R.id.button3) {
            return 0;
        } else if (buttonId == R.id.button4 || buttonId == R.id.button5 || buttonId == R.id.button6) {
            return 1;
        } else if (buttonId == R.id.button7 || buttonId == R.id.button8 || buttonId == R.id.button9) {
            return 2;
        } else {
            return -1;
        }
    }

    private int getColumnFromButtonId(int buttonId) {
        if (buttonId == R.id.button1 || buttonId == R.id.button4 || buttonId == R.id.button7) {
            return 0;
        } else if (buttonId == R.id.button2 || buttonId == R.id.button5 || buttonId == R.id.button8) {
            return 1;
        } else if (buttonId == R.id.button3 || buttonId == R.id.button6 || buttonId == R.id.button9) {
            return 2;
        } else {
            return -1;
        }
    }
}
