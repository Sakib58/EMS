package com.example.emsdriver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button loginBtn,regBtn;
    public long pressTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginBtn=findViewById(R.id.btnLogin);
        regBtn=findViewById(R.id.btnReg);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onBackPressed() {

        if(pressTime+2000>System.currentTimeMillis()){
            //super.onBackPressed();
            moveTaskToBack(true);
            //android.os.Process.killProcess(android.os.Process.myPid());
            //System.exit(1);
        }
        else {
            Toast.makeText(getApplicationContext(),"Press again to exit",Toast.LENGTH_SHORT).show();
        }
        pressTime=System.currentTimeMillis();
    }
}
