package com.onespace.kiosk.fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.onespace.kiosk.R;
import com.onespace.kiosk.common.BaseFragment;



/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OTPFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OTPFragment extends BaseFragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // TODO: Variables for components, Process
    Spinner spinnerPhoneNum;
    EditText etPhoneNum, etVerifyCode;
    Button btnNum1, btnNum2, btnNum3, btnNum4, btnNum5, btnNum6,btnNum7, btnNum8, btnNum9,btnNum0, btnNumRemove, btnSendCode, btnVerify, btnResend;
    TextView tvCodeExpire;
    long starttime = 0;

    private Handler mHandler = new Handler();
    Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            long millis = System.currentTimeMillis() - starttime;
            int seconds = (int) (millis / 1000);

            if (seconds > 60) {
                tvCodeExpire.setVisibility(View.GONE);
                btnResend.setVisibility(View.VISIBLE);
                mHandler.removeCallbacks(timerRunnable);
            } else {
                String preExpire = "Code valid for ";
                String strExpire =  preExpire + (60 - seconds) + "s";
                Spannable spannable = new SpannableString(strExpire);
                spannable.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorCodeResendBtn)), preExpire.length(), (strExpire).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                tvCodeExpire.setText(spannable, TextView.BufferType.SPANNABLE);
                mHandler.postDelayed(timerRunnable, 1000);
            }
        }
    };


    public OTPFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StepOneFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OTPFragment newInstance(String param1, String param2) {
        OTPFragment fragment = new OTPFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_step_one, container, false);

        initializeUI(view);

        return view;
    }

    private void initializeUI(View view) {
        btnNum0 = view.findViewById(R.id.btnNum0);
        btnNum1 = view.findViewById(R.id.btnNum1);
        btnNum2 = view.findViewById(R.id.btnNum2);
        btnNum3 = view.findViewById(R.id.btnNum3);
        btnNum4 = view.findViewById(R.id.btnNum4);
        btnNum5 = view.findViewById(R.id.btnNum5);
        btnNum6 = view.findViewById(R.id.btnNum6);
        btnNum7 = view.findViewById(R.id.btnNum7);
        btnNum8 = view.findViewById(R.id.btnNum8);
        btnNum9 = view.findViewById(R.id.btnNum9);
        btnNumRemove = view.findViewById(R.id.btnNumRemove);
        btnSendCode = view.findViewById(R.id.btnSendCode);
        btnVerify = view.findViewById(R.id.btnCodeVerify);
        btnResend = view.findViewById(R.id.btnResend);

        etPhoneNum = view.findViewById(R.id.etPhoneNum);
        etVerifyCode = view.findViewById(R.id.etVerifyCode);
        tvCodeExpire = view.findViewById(R.id.tvCodeExpire);
        spinnerPhoneNum = view.findViewById(R.id.spinnerPhoneCode);

        btnNum0.setOnClickListener(this);
        btnNum1.setOnClickListener(this);
        btnNum2.setOnClickListener(this);
        btnNum3.setOnClickListener(this);
        btnNum4.setOnClickListener(this);
        btnNum5.setOnClickListener(this);
        btnNum6.setOnClickListener(this);
        btnNum7.setOnClickListener(this);
        btnNum8.setOnClickListener(this);
        btnNum9.setOnClickListener(this);
        btnNumRemove.setOnClickListener(this);

        btnResend.setOnClickListener(this);
        btnSendCode.setOnClickListener(this);
        btnVerify.setOnClickListener(this);

        btnSendCode.setEnabled(true);
        btnVerify.setEnabled(false);
        etPhoneNum.setEnabled(true);
        spinnerPhoneNum.setEnabled(true);
        etVerifyCode.setEnabled(false);
        btnResend.setVisibility(View.GONE);
        tvCodeExpire.setVisibility(View.GONE);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.country_code, R.layout.phone_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerPhoneNum.setAdapter(adapter);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnNum0:
                editPhoneNum("0");
                break;
            case R.id.btnNum1:
                editPhoneNum("1");
                break;
            case R.id.btnNum2:
                editPhoneNum("2");
                break;
            case R.id.btnNum3:
                editPhoneNum("3");
                break;
            case R.id.btnNum4:
                editPhoneNum("4");
                break;
            case R.id.btnNum5:
                editPhoneNum("5");
                break;
            case R.id.btnNum6:
                editPhoneNum("6");
                break;
            case R.id.btnNum7:
                editPhoneNum("7");
                break;
            case R.id.btnNum8:
                editPhoneNum("8");
                break;
            case R.id.btnNum9:
                editPhoneNum("9");
                break;
            case R.id.btnNumRemove:
                editPhoneNum("");
                break;
            case R.id.btnSendCode:
                sendCode();
                break;
            case R.id.btnCodeVerify:
                verifyCode();
                break;
            case R.id.btnResend:
                resendCode();
                break;
        }
    }

    private void resendCode() {
        starttime = System.currentTimeMillis();
        mHandler.postDelayed(timerRunnable, 0);
    }

    private void verifyCode() {
        mActivity.setBtnForwardEnable(true);
        mHandler.removeCallbacks(timerRunnable);
        tvCodeExpire.setVisibility(View.GONE);
    }

    private void sendCode() {

        //Send a phone code -- OTP

        btnNum0.setEnabled(false);
        btnNum1.setEnabled(false);
        btnNum2.setEnabled(false);
        btnNum3.setEnabled(false);
        btnNum4.setEnabled(false);
        btnNum5.setEnabled(false);
        btnNum6.setEnabled(false);
        btnNum7.setEnabled(false);
        btnNum8.setEnabled(false);
        btnNum9.setEnabled(false);
        btnNumRemove.setEnabled(false);
        btnSendCode.setEnabled(false);
        btnSendCode.setText("");
        btnSendCode.setCompoundDrawablesWithIntrinsicBounds(R.drawable.numpad_send_code_ic, 0,  0, 0);
        btnSendCode.setPadding(64, 0, 0, 0);

        spinnerPhoneNum.setEnabled(false);
        etPhoneNum.setEnabled(false);
        btnVerify.setEnabled(true);
        etVerifyCode.setEnabled(true);

        tvCodeExpire.setVisibility(View.VISIBLE);
        btnResend.setVisibility(View.GONE);

        starttime = System.currentTimeMillis();
        mHandler.postDelayed(timerRunnable, 0);

    }

    void editPhoneNum(String numVal){
        if(numVal.equals("")){
            if(etPhoneNum.getText().toString().length() > 0){
                etPhoneNum.setText(etPhoneNum.getText().toString().substring(0, etPhoneNum.getText().toString().length() - 1));
            }
        }else {
            etPhoneNum.setText(etPhoneNum.getText().toString().concat(numVal));
        }
    }
}