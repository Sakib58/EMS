package com.example.emsdriver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    TextView newDriver,login;
    EditText mail,pass;
    FirebaseAuth firebaseAuth;
    public static String userMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        newDriver=findViewById(R.id.tvReg);
        mail=findViewById(R.id.etMail);
        pass=findViewById(R.id.etPass);
        login=findViewById(R.id.tvLogin);
        firebaseAuth=FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userMail=mail.getText().toString();
                firebaseAuth.signInWithEmailAndPassword(mail.getText().toString(),pass.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    if(firebaseAuth.getCurrentUser().isEmailVerified()){
                                        Toast.makeText(getApplicationContext(),"Login successful",Toast.LENGTH_LONG).show();
                                        Intent intent=new Intent(getApplicationContext(), MapsActivity.class);
                                        startActivity(intent);
                                    }else {
                                        Toast.makeText(getApplicationContext(),"Please verify your email.",Toast.LENGTH_LONG).show();
                                    }

                                }else {
                                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });


        newDriver.setPaintFlags(newDriver.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        newDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),RegistrationActivity.class);
                startActivity(intent);
            }
        });

    }
}
