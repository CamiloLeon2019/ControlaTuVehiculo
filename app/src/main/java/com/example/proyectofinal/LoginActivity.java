package com.example.proyectofinal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/*
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
*/

public class LoginActivity extends AppCompatActivity {

    private ProgressDialog loading;
    private Button botonLogin, botonLoginPhone;
    private EditText emailUsuario, emailPassword;
    private TextView nuevaCuenta, olvidarPassword, loginPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        InitializeFields();

        nuevaCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendUserToRegisterActivity();
            }
        });

        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                permitirLogin();
            }
        });
    }

    private void permitirLogin() {
        String correo = emailUsuario.getText().toString();
        String password = emailPassword.getText().toString();

        if(TextUtils.isEmpty(correo)){
            Toast.makeText(this,"Debe ingresar correo", Toast.LENGTH_SHORT);
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Debe ingresar contraseña", Toast.LENGTH_SHORT);
        }else {
            loading.setTitle("Ingresando");
            loading.setMessage("Por favor espere mientras se ingresa a sistema");
            loading.setCanceledOnTouchOutside(true);
            loading.show();
            /*mAuth.signInWithEmailAndPassword(correo,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        SendUserToMainActivity();
                        Toast.makeText(LoginActivity.this,"Bienvenido",Toast.LENGTH_SHORT).show();
                        loading.dismiss();
                    }else {
                        String message = task.getException().toString();
                        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                        loading.dismiss();
                    }
                }
            });*/

        }

        }

    private void InitializeFields() {
        botonLogin = (Button) findViewById(R.id.login_button);
        emailUsuario = (EditText) findViewById(R.id.login_email);
        emailPassword = (EditText) findViewById(R.id.login_password);
        nuevaCuenta = (TextView) findViewById(R.id.new_account_link);
        olvidarPassword = (TextView) findViewById(R.id.forget_password_link);
        loading = new ProgressDialog(this);
    }


    private void SendUserToRegisterActivity() {
        Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(registerIntent);
    }
/*
    private void SendUserToMainActivity() {
        Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainIntent);
        finish();
    }
    */
}
