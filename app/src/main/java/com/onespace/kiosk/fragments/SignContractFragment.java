package com.onespace.kiosk.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.gcacace.signaturepad.views.SignaturePad;
import com.onespace.kiosk.R;
import com.onespace.kiosk.common.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignContractFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignContractFragment extends BaseFragment {

    Button btnSignClear, btnSignRefresh;

    SignaturePad signaturePad;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SignContractFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SignContractFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SignContractFragment newInstance(String param1, String param2) {
        SignContractFragment fragment = new SignContractFragment();
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
        View view = inflater.inflate(R.layout.fragment_sign_contract, container, false);
        initializeUI(view);
        return view;
    }

    private void initializeUI(View view) {
        signaturePad = view.findViewById(R.id.signature_pad);
        btnSignRefresh = view.findViewById(R.id.btnSignRefresh);
        btnSignClear = view.findViewById(R.id.btnClearSign);

        btnSignClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signaturePad.clear();
            }
        });

        btnSignRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signaturePad.clear();
            }
        });
    }
}