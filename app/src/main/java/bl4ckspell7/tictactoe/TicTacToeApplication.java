package bl4ckspell7.tictactoe;

import android.app.Application;

import com.google.android.material.color.DynamicColors;

public class TicTacToeApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DynamicColors.applyToActivitiesIfAvailable(this);
    }
}
