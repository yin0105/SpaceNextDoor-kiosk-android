package com.onespace.kiosk.common;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.onespace.kiosk.StepActivity;

public class BaseFragment extends Fragment {
    protected StepActivity mActivity;

    public BaseFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = ((StepActivity)getActivity());
    }


    protected boolean validateForm(EditText editText, String validMsg, int validateLength){

        if(editText.getText().toString().length() < validateLength){
            Toast.makeText(mActivity,validMsg, Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
