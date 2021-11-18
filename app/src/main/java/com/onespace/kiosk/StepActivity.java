package com.onespace.kiosk;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.onespace.kiosk.common.BaseActivity;
import com.onespace.kiosk.fragments.ChooseUnitFragment;
import com.onespace.kiosk.fragments.FaceVerifyFragment;
import com.onespace.kiosk.fragments.FindUnitFragment;
import com.onespace.kiosk.fragments.IdVerifyFragment;
import com.onespace.kiosk.fragments.OTPFragment;
import com.onespace.kiosk.fragments.SignContractFragment;

public class StepActivity extends BaseActivity {
    ImageView ivStepProgress;
    Button btnPrev, btnForward;

    int stageFlag = 0;
    boolean isBtnPrevShow = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);

        ivStepProgress = findViewById(R.id.ivStepProgress);
        btnPrev = findViewById(R.id.btnPrev);
        btnForward = findViewById(R.id.btnForward);
        btnPrev.setVisibility(View.GONE);
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(stageFlag > 1){
                    stageFlag--;
                    getSupportFragmentManager().popBackStack();
                    processStage(false);
                }else{
                    stageFlag = 0;
                    btnPrev.setVisibility(View.GONE);
                    btnForward.setEnabled(false);
                    ivStepProgress.setImageResource(R.drawable.progress1);
                    getSupportFragmentManager().popBackStack();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction().addToBackStack(null);
                    ft.replace(R.id.fragmentContainer, new OTPFragment());
                    ft.commit();
                }
            }
        });

        btnForward.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(stageFlag < 5){
                    stageFlag++;
                    processStage(true);
                }else {
                    finish();
                    startActivity(new Intent(StepActivity.this, FinalActivity.class));
                }
            }
        });

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction().addToBackStack(null);
        ft.replace(R.id.fragmentContainer, new OTPFragment());
        ft.commit();

    }

    public void setBtnForwardEnable(boolean isEnable){
        btnForward.setEnabled(true);
    }

    public void showBtnPrev(boolean isShow){
        btnPrev.setVisibility(View.VISIBLE);
    }

    public void setBtnPrevText(String str){
        btnPrev.setText(str);
    }

    void setBtnForwardText(String str){
        btnForward.setText(str);
    }


    void processStage(boolean isNext){
        Fragment fragment = null;
        boolean isFaceID = false;
        if(stageFlag == 1){
            fragment = new FaceVerifyFragment();
            setBtnPrevText(getString(R.string.cancel));
            showBtnPrev(true);
            ivStepProgress.setImageResource(R.drawable.progress2);


        }else if(stageFlag == 2){
            isFaceID = true;
            verifyUseFaceID();

        }else if(stageFlag == 3){

            fragment = new ChooseUnitFragment();
            setBtnPrevText(getString(R.string.previous));
            showBtnPrev(true);
            ivStepProgress.setImageResource(R.drawable.progress4);
        }else if(stageFlag == 4){

            fragment = new SignContractFragment();
            setBtnPrevText(getString(R.string.previous));
            setBtnForwardText(getString(R.string.next));
            showBtnPrev(true);
            ivStepProgress.setImageResource(R.drawable.progress5);
        }else{

            fragment = new FindUnitFragment();
            btnForward.setText(getString(R.string.finish));
        }
        if(isNext && !isFaceID){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction().addToBackStack(null);
            ft.replace(R.id.fragmentContainer, fragment);
            ft.commit();
        }
    }


    void verifyUseFaceID(){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.face_verify_custom_dialog);
        dialog.getWindow().setLayout(((getWidth(this) / 100) * 90), ConstraintLayout.LayoutParams.WRAP_CONTENT);
        Button cancelBtn =  dialog.findViewById(R.id.btnCancel);
        // if button is clicked, close the custom dialog
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stageFlag = 1;
                dialog.dismiss();
            }
        });

        Button continueBtn = dialog.findViewById(R.id.btnContinue);
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Fragment fragment = new IdVerifyFragment();
                setBtnPrevText(getString(R.string.cancel));
                showBtnPrev(true);
                ivStepProgress.setImageResource(R.drawable.progress3);
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction().addToBackStack(null);
                ft.replace(R.id.fragmentContainer, fragment);
                ft.commit();
            }
        });
        dialog.show();
    }

    public static int getWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowmanager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        windowmanager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

}