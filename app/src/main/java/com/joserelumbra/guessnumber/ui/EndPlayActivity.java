package com.joserelumbra.guessnumber.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.joserelumbra.guessnumber.R;
import com.joserelumbra.guessnumber.data.model.User;

import java.util.Random;

public class EndPlayActivity extends AppCompatActivity {
    private static final String TAG = "EndPlayActivity";
    private static final Integer fromEndPlayToConfig = 003;
    private static TextView tvEndUser, tvEndGuessNumber, tvEndIntents;
    private Bundle bundle;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_play);
        bundle = getIntent().getExtras();
        user = (User) getIntent().getExtras().getSerializable("user");

        tvEndUser = findViewById(R.id.tvEndUser);
        tvEndGuessNumber = findViewById(R.id.tvEndGuessNumber);
        tvEndIntents = findViewById(R.id.tvEndIntents);

        if (user.getIntentos() == 0){
            tvEndUser.setText("Has Perdido, "+"  "+user.getNombre());
            tvEndGuessNumber.setText(tvEndGuessNumber.getText().toString()+"   "+user.getGuess().toString());
            tvEndIntents.setText(tvEndIntents.getText().toString()+"   "+user.getIntentos().toString());
        }else {
            tvEndUser.setText(tvEndUser.getText() + user.getNombre());
            tvEndGuessNumber.setText(tvEndGuessNumber.getText().toString()+"   "+user.getGuess().toString());
            tvEndIntents.setText(tvEndIntents.getText().toString()+"   "+user.getIntentos().toString());
        }

    }

    //region Ciclo de vida completo de EndPlayActivity
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "EndPlayActivity -> onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "EndPlayActivity -> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "EndPlayActivity -> onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "EndPlayActivity -> onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "EndPlayActivity -> onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "EndPlayActivity -> onDestroy()");
    }
    //endregion

    /**
     * Este método permite que no se pueda volver atrás.
     */
    @Override public void onBackPressed() { moveTaskToBack(false); }

}