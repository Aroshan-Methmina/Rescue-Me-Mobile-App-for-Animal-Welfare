package com.example.rescueme1.Opening;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rescueme1.R;

public class Welcome extends AppCompatActivity {

    private Button btnSingup;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome);

        btnSingup = findViewById(R.id.btnSingup);
        btnLogin = findViewById(R.id.btnLogin);


        btnSingup.setOnClickListener(v -> {
            Intent intent = new Intent(Welcome.this, Singup.class);
            startActivity(intent);



        });
        btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(Welcome.this, Login.class);
            startActivity(intent);



        });

    }
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
            );
        }
    }
}