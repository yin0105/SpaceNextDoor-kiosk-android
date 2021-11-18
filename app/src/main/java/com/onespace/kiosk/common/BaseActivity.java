package com.onespace.kiosk.common;

import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    protected void navigateScreen(Intent intent){
        startActivity(intent);
    }

    protected void showToast(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
