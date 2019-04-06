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
*/

public class RegisterActivity extends AppCompatActivity {

    private Button botonCrearCuenta;
    private EditText correoUsuario, passwordUsuario;
    private TextView alreadyHaveAccountLink;
    private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        InitializeFields();

        alreadyHaveAccountLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendUserToLoginActivity();
            }
        });

        botonCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CrearCuenta();
            }
        });
    }

    private void CrearCuenta() {
        String correo = correoUsuario.getText().toString();
        String password = passwordUsuario.getText().toString();

        if(TextUtils.isEmpty(correo)){
            Toast.makeText(this,"Debe ingresar correo", Toast.LENGTH_SHORT);
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Debe ingresar contraseña", Toast.LENGTH_SHORT);
        }else {

            loading.setTitle("Creando Cuenta");
            loading.setMessage("Por favor espere mientras la cuenta es creada");
             loading.setCanceledOnTouchOutside(true);
             loading.show();
             /*
                 mAuth.createUserWithEmailAndPassword(correo,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                     @Override
                     public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                SendUserToMainActivity();
                                Toast.makeText(RegisterActivity.this,"Cuenta Creada",Toast.LENGTH_SHORT);
                                loading.dismiss();
                            }else{
                                String message = task.getException().toString();
                                Toast.makeText(RegisterActivity.this, message,Toast.LENGTH_SHORT);
                                loading.dismiss();
                            }
                     }
                 });
                 */

        }
    }
    /*
    private void SendUserToMainActivity() {
        Intent mainIntent = new Intent(RegisterActivity.this, MainActivity.class);
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainIntent);
        finish();
    }
    */

    private void SendUserToLoginActivity() {
        Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(loginIntent);
    }

    private void InitializeFields() {
        botonCrearCuenta = (Button) findViewById(R.id.register_button);
        correoUsuario = (EditText) findViewById(R.id.register_año);
        passwordUsuario = (EditText) findViewById(R.id.register_password);
        alreadyHaveAccountLink = (TextView) findViewById(R.id.already_have_account_link);
        loading = new ProgressDialog(this);
    }
}
