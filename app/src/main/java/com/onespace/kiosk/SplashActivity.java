package com.onespace.kiosk;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.onespace.kiosk.common.BaseActivity;



public class SplashActivity extends BaseActivity implements View.OnClickListener {

    Button btnCheckIn;
    ImageView ivAppStore, ivGooglePlay, ivAppleQr, ivGoogleQr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        loadUI();
    }

    private void loadUI() {
        btnCheckIn = findViewById(R.id.btnCheckIn);
        ivAppStore = findViewById(R.id.ivAppStore);
        ivGooglePlay = findViewById(R.id.ivGooglePlay);
        ivGoogleQr = findViewById(R.id.ivGoogleQr);
        ivAppleQr = findViewById(R.id.ivAppleQr);

        btnCheckIn.setOnClickListener(this);
        ivAppStore.setOnClickListener(this);
        ivGooglePlay.setOnClickListener(this);
        ivGoogleQr.setOnClickListener(this);
        ivAppleQr.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCheckIn:
                navigateScreen(new Intent(SplashActivity.this, StepActivity.class));
                break;
            case R.id.ivAppStore:
                break;
            case R.id.ivGooglePlay:
                break;
            case R.id.ivGoogleQr:
                break;
            case R.id.ivAppleQr:
                break;
        }
    }
}