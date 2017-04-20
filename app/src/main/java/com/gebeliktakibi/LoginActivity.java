package com.gebeliktakibi;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private ProgressDialog progressDialog;
    private Button butonSignIn;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextPasswordAgain;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()!=null){
            //profile activity here
        }

        editTextEmail = (EditText) findViewById(R.id.editTextMail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        butonSignIn = (Button) findViewById(R.id.buttonSingin);
        editTextPasswordAgain=(EditText)findViewById(R.id.editTextPasswordAgain);


        butonSignIn.setOnClickListener(this);
    }

    private void userLogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String passwordAgain=editTextPasswordAgain.getText().toString().trim();


        if (TextUtils.isEmpty(email)) {
            //email is empty
            Toast.makeText(this, "Lütfen email adresinizi giriniz", Toast.LENGTH_SHORT).show();
            //stopping the function execution further
            return;
        }
        if (TextUtils.isEmpty(password)) {
            //password is empty
            Toast.makeText(this, "Lütfen şifrenizi giriniz", Toast.LENGTH_SHORT).show();
            //stopping the function execution further
            return;
        }
        if(TextUtils.isEmpty(passwordAgain)){
            Toast.makeText(this, "Lütfen şifrenizi giriniz", Toast.LENGTH_SHORT).show();
        }

        progressDialog.setMessage("Bebek yükleniyor... :)");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (task.isSuccessful()){
                    //start the profile activity
                }

            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v == butonSignIn) {
            userLogin();
        }
    }
}
