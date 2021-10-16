package com.joserelumbra.guessnumber.ui;

import android.content.Intent;
import android.graphics.Color;
import android.sax.StartElementListener;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.joserelumbra.guessnumber.R;
import com.joserelumbra.guessnumber.data.model.User;
import com.joserelumbra.guessnumber.databinding.ActivityConfigBinding;

/**
 * Esta Actividad será la encargada de gestionar que se adivine o no el nº generado
 * de manera correta, teniendo en cuenta el nº de intentos introducidos por el usuario
 * en ConfigActivity.
 */
public class PlayActivity extends AppCompatActivity {
    private static final String TAG = "PlayActivity";
    private static final int fromPlayToEndPlay_rq=002;
    private Button btnTryAgain, btnCheck;
    private TextView tvTotalTry;
    private EditText edPlay;
    private User user;
    private Bundle bundle;
    boolean boolBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //Obtengo los datos del bundle
        bundle = getIntent().getExtras();
        user = (User) getIntent().getExtras().getSerializable("user");

        btnTryAgain = findViewById(R.id.btnTryAgain);
        //botón inhabilitado por defecto
        btnTryAgain.setEnabled(false);
        btnCheck = findViewById(R.id.btnCheck);
        edPlay = findViewById(R.id.edPlay);
        tvTotalTry = findViewById(R.id.tvTotalTry);
        //Se le añaden los intentos restantes a este TextView
        tvTotalTry.setText(user.getIntentos().toString());

    }

    //region Ciclo de vida completo de PlayActivity
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "PlayActivity -> onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "PlayActivity -> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "PlayActivity -> onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "PlayActivity -> onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "PlayActivity -> onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "PlayActivity -> onDestroy()");
    }
    //endregion

    /**
     * Este método permite que no se pueda volver atrás.
     */
    @Override public void onBackPressed() { moveTaskToBack(false); }

    //region Mensaje de error
    private void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
    //endregion

    //region Metodos onClick de btnCheck y btnTryAgain

    /**
     * Método asociado a btnCheck, el cual comprueba que el número
     * introducido sea el mismo que el número secreto.
     * @param view Componente de la vista que recibirá este método.
     */
    public void Check(View view){
        if (!TextUtils.isEmpty(edPlay.getText())){
            if (TextUtils.isDigitsOnly(edPlay.getText())){
                if (Integer.parseInt(edPlay.getText().toString()) == user.getGuess() || user.getIntentos() == 0){
                    bundle.putSerializable("user", user);
                    Intent intent = new Intent(PlayActivity.this, EndPlayActivity.class);
                    intent.putExtras(bundle);
                    startActivityForResult(intent, fromPlayToEndPlay_rq);

                }else {
                    if (Integer.parseInt(edPlay.getText().toString()) < user.getGuess()){
                        showMessage(getString(R.string.errGuessMore));
                        user.setIntentos(user.getIntentos() - 1);
                        tvTotalTry.setText(user.getIntentos().toString());
                        edPlay.setEnabled(false);
                        btnTryAgain.setEnabled(true);
                        btnCheck.setEnabled(false);
                    }
                    else if(Integer.parseInt(edPlay.getText().toString()) > user.getGuess()){
                        showMessage(getString(R.string.errGuessLess));
                        user.setIntentos(user.getIntentos() - 1);
                        tvTotalTry.setText(user.getIntentos().toString());
                        edPlay.setEnabled(false);
                        btnTryAgain.setEnabled(true);
                        btnCheck.setEnabled(false);
                    }
                }
            }else {
                showMessage(getString(R.string.errOnlyDigit));
            }
        }else {
            showMessage(getString(R.string.errNotNullValues));
        }
    }

    /**
     * Método asociado a btnTryAgain, el cual permitirá volver a introducir
     * otro intento, habilitando los componentes necesarios para continuar
     * de manera adecuada.
     * @param view Componente de la vista que recibirá este método.
     */
    public void TryAgain(View view){
        edPlay.setText("");
        edPlay.setEnabled(true);
        btnCheck.setEnabled(true);
        btnTryAgain.setEnabled(false);
    }
    //endregion


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (btnCheck.isEnabled() == true && btnTryAgain.isEnabled() == false && edPlay.isEnabled() == true){
            boolBtn = true;
            outState.putBoolean("Comprobar", boolBtn);
        }else {
            boolBtn = false;
            outState.putBoolean("Comprobar", boolBtn);
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.getBoolean("Comprobar") == true){
            btnCheck.setEnabled(true);
            btnTryAgain.setEnabled(false);
            edPlay.setEnabled(true);
        }else {
            btnCheck.setEnabled(false);
            btnTryAgain.setEnabled(true);
            edPlay.setEnabled(false);
        }
    }
}