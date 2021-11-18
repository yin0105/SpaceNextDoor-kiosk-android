package com.onespace.kiosk.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.onespace.kiosk.R;
import com.onespace.kiosk.adapters.ReservationAdapter;
import com.onespace.kiosk.adapters.UnitAdapter;
import com.onespace.kiosk.models.dummymodels.ReservationModel;
import com.onespace.kiosk.models.dummymodels.UnitModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChooseUnitFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChooseUnitFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView rvReservation, rvUnit;
    ReservationAdapter reservationAdapter;
    UnitAdapter unitAdapter;

    List<ReservationModel> reservationModelList = new ArrayList<ReservationModel>();
    List<UnitModel> unitModelList = new ArrayList<UnitModel>();
    TextView tvBlur;
    public ChooseUnitFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChooseUnitFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChooseUnitFragment newInstance(String param1, String param2) {
        ChooseUnitFragment fragment = new ChooseUnitFragment();
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
        View view = inflater.inflate(R.layout.fragment_choose_unit, container, false);
        rvReservation = view.findViewById(R.id.rvReservation);
        rvUnit = view.findViewById(R.id.rvUnit);
        tvBlur = view.findViewById(R.id.tvBlur);
        reservationAdapter = new ReservationAdapter(reservationModelList);
        unitAdapter = new UnitAdapter(unitModelList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvReservation.setLayoutManager(mLayoutManager);
        rvReservation.setItemAnimator(new DefaultItemAnimator());
        rvReservation.setAdapter(reservationAdapter);


        rvUnit.setLayoutManager(mLayoutManager);
        rvUnit.setItemAnimator(new DefaultItemAnimator());
        rvUnit.setAdapter(unitAdapter);

        loadReservation();
        loadUnit(true);

        reservationAdapter.setListener(new ReservationAdapter.OnItemClickListener() {
            @Override
            public void OnSelect(int position) {
                reservationModelList.get(position).setSelected(true);
                tvBlur.setVisibility(View.GONE);

                loadUnit(false);
                for(int i = 0 ; i < reservationModelList.size() ; i ++){
                    if(i != position)
                        reservationModelList.get(i).setSelected(false);
                }
                reservationAdapter.notifyDataSetChanged();
            }
        });

        unitAdapter.setListener(new UnitAdapter.OnItemClickListener() {
            @Override
            public void OnSelect(int position, boolean type) {
                unitModelList.get(position).setSelected(true);
                for(int i = 0 ; i < unitModelList.size() ; i ++){
                    if(i != position)
                        unitModelList.get(i).setSelected(false);
                }
                unitAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    private void loadReservation() {
        reservationModelList.add(new ReservationModel("RESERVATION NUMBER: 4453", "Extra Large Unit - CCTV Alarm, Power, Supply, A/c356", "4", "5 sq.ft", "12/01/2021", "12/01/2021"));
        reservationModelList.add(new ReservationModel("RESERVATION NUMBER: 4453", "Extra Large Unit - CCTV Alarm, Power, Supply, A/c356", "4", "5 sq.ft", "12/01/2021", "12/01/2021"));

        reservationAdapter.notifyDataSetChanged();

    }



    private void loadUnit(boolean initial){

        unitModelList.clear();
        if(initial){
            unitModelList.add(new UnitModel("A-XXX", "4", "5 sq.ft", "Attributes: CCTV, Alarm, Power Supply"));
            unitModelList.add(new UnitModel("A-XXX", "4", "5 sq.ft", "Attributes: CCTV, Alarm, Power Supply"));
            unitModelList.add(new UnitModel("A-XXX", "4", "5 sq.ft", "Attributes: CCTV, Alarm, Power Supply"));

        }else{
            unitModelList.add(new UnitModel("A-121", "4", "5 sq.ft", "Attributes: CCTV, Alarm, Power Supply"));
            unitModelList.add(new UnitModel("A-122", "4", "5 sq.ft", "Attributes: CCTV, Alarm, Power Supply"));
            unitModelList.add(new UnitModel("A-123", "4", "5 sq.ft", "Attributes: CCTV, Alarm, Power Supply"));

        }
        unitAdapter.notifyDataSetChanged();
    }
}