package com.joserelumbra.guessnumber.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.joserelumbra.guessnumber.R;
import com.joserelumbra.guessnumber.data.model.User;

import java.util.Random;


/**
 * Esta será la actividad principal del juego GuessNumber que, pedirá meddiante un
 * loggin de acceso al juego, el nombre del usuario que va a jugar y el nº de intentos
 * que tendrá una vez comenzado el juego, teniendo en cuenta que no se podrá comenzar
 * a jugar si no se rellenan correctamente los respectivos campos necesarios para jugar.
 */

public class ConfigActivity extends AppCompatActivity {

    private static final String TAG = "ConfigActivity";
    private EditText edUserName, edUserIntents;
    private static final int fromConfigToPlay_rq=001;
    private Bundle bundle;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        edUserName = findViewById(R.id.edUserName);
        edUserIntents = findViewById(R.id.edUserIntents);
        Log.d(TAG, "ConfigActivity -> onCreate()");
    }

    //region Ciclo de vida completo de ConfigActivity
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "ConfigActivity -> onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ConfigActivity -> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ConfigActivity -> onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ConfigActivity -> onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "ConfigActivity -> onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "ConfigActivity -> onDestroy()");
    }
    //endregion

    //region Mensaje de Error
    private void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
    //endregion

    //region Metodo onClick de btnPlay
    /**
     * Método asociado al evento onclick de btnPlay que se encarga de que se rellenen
     * todos los campos de manera correcta y se la envía a PlayActivity.java.
     */
    public void play(View view) {
        if (!TextUtils.isEmpty(edUserName.getText()) && !TextUtils.isEmpty(edUserIntents.getText())){
            if (TextUtils.isDigitsOnly(edUserIntents.getText())){
                if (Integer.parseInt(edUserIntents.getText().toString()) < 100){

                    /**
                     * Si se introducen los campos correctamente se meten en el bundle para
                     * enviárselos a PlayActivity.
                     */
                    bundle = new Bundle();
                    user = new User(edUserName.getText().toString(), Integer.parseInt(edUserIntents.getText().toString()));
                    Random rnd = new Random();
                    user.setGuess(rnd.nextInt(101));
                    bundle.putSerializable("user", user);
                    Intent intent = new Intent(ConfigActivity.this, PlayActivity.class);
                    intent.putExtras(bundle);
                    startActivityForResult(intent, fromConfigToPlay_rq);

                }else {
                    showMessage(getString(R.string.errTooIntents));
                }
            }else {
                showMessage(getString(R.string.errOnlyDigit));
            }
        }else {
            showMessage(getString(R.string.errNotNullValues));
        }
    }
    //endregion
}