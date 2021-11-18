package com.onespace.kiosk.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.onespace.kiosk.R;
import com.onespace.kiosk.models.dummymodels.ReservationModel;
import com.onespace.kiosk.models.dummymodels.UnitModel;

import java.util.List;

public class ReservationAdapter extends RecyclerView.Adapter<ReservationAdapter.ReservationViewHolder> {
    private List<ReservationModel> reservationList;


    private ReservationAdapter.OnItemClickListener listener;
    public ReservationAdapter(List<ReservationModel> reservationList) {
        this.reservationList = reservationList;

    }

    @Override
    public ReservationAdapter.ReservationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.reservation_item_layout, parent, false);

        return new ReservationAdapter.ReservationViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ReservationAdapter.ReservationViewHolder holder, final int position) {

        ReservationModel reservation = reservationList.get(position);

        holder.tvReservationName.setText(reservation.getReserveNum());
        holder.tvExtraLarge.setText(reservation.getReserveExtraLarge());
        holder.tvFloor.setText(reservation.getReserveFloor());
        holder.tvArea.setText(reservation.getReserveArea());
        holder.tvDate.setText(reservation.getReserveDate());
        holder.tvMoveInDate.setText(reservation.getReserveMoveInDate());

        if(reservation.isSelected()){
            holder.ivSelected.setVisibility(View.VISIBLE);
            holder.tvLine.setBackgroundResource(R.color.white);
            holder.clReservation.setBackgroundResource(R.color.colorSelectedGreen);

        }else {
            holder.ivSelected.setVisibility(View.GONE);
            holder.tvLine.setBackgroundResource(R.color.colorHint);
            holder.clReservation.setBackgroundResource(R.color.white);
        }
    }

    @Override
    public int getItemCount() {


        return reservationList.size();
    }

    public class ReservationViewHolder extends RecyclerView.ViewHolder {

        public TextView tvReservationName, tvExtraLarge, tvFloor, tvArea, tvDate, tvMoveInDate, tvLine;
        ImageView ivSelected;

        ConstraintLayout clReservation;

        public ReservationViewHolder(View view) {
            super(view);
            tvReservationName =  view.findViewById(R.id.tvReservationName);
            tvExtraLarge = view.findViewById(R.id.tvExtraUnit);
            tvFloor = view.findViewById(R.id.tvUnitArea);
            tvArea = view.findViewById(R.id.tvArea);
            tvDate = view.findViewById(R.id.tvReservationDate);
            tvMoveInDate = view.findViewById(R.id.tvMoveInDate);
            ivSelected = view.findViewById(R.id.ivSelected);
            tvLine = view.findViewById(R.id.tvLine);
            clReservation = view.findViewById(R.id.clReservation);
        }
    }
    public void setListener(ReservationAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }
    public interface OnItemClickListener{

        void OnSelect(int position);
    }
}