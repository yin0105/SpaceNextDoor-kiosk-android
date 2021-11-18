package com.onespace.kiosk.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.onespace.kiosk.R;
import com.onespace.kiosk.models.dummymodels.UnitModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UnitAdapter extends RecyclerView.Adapter<UnitAdapter.UnitViewHolder> {
    private List<UnitModel> unitList;


    private UnitAdapter.OnItemClickListener listener;
    public UnitAdapter(List<UnitModel> unitList) {
        this.unitList = unitList;

    }

    @Override
    public UnitAdapter.UnitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.unit_item_layout, parent, false);

        return new UnitAdapter.UnitViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UnitAdapter.UnitViewHolder holder, final int position) {

        UnitModel unit = unitList.get(position);

        holder.tvUnitArea.setText(unit.getUnitArea());
        holder.tvUnitName.setText(unit.getUnitName());
        holder.tvUnitFloor.setText(unit.getUnitFloor());
        holder.tvUnitAttribute.setText(unit.getUnitAttribute());
        if(unit.isSelected()){
            holder.ivSelected.setVisibility(View.VISIBLE);
            holder.unitContainer.setBackgroundResource(R.color.colorSelectedGreen);
            holder.tvLine.setBackgroundResource(R.color.white);
        }else {
            holder.ivSelected.setVisibility(View.GONE);
            holder.unitContainer.setBackgroundResource(R.color.white);
            holder.tvLine.setBackgroundResource(R.color.colorHint);
        }

    }

    @Override
    public int getItemCount() {


        return unitList.size();
    }

    public class UnitViewHolder extends RecyclerView.ViewHolder {

        public TextView tvUnitName, tvUnitFloor, tvUnitArea, tvUnitAttribute, tvLine;
        ImageView ivSelected;
        ConstraintLayout unitContainer;
        public UnitViewHolder(View view) {
            super(view);
            tvUnitName =  view.findViewById(R.id.tvBuildNo);
            tvUnitFloor = view.findViewById(R.id.tvUnitFloor);
            tvUnitArea = view.findViewById(R.id.tvUnitArea);
            tvUnitAttribute = view.findViewById(R.id.tvUnitAttribute);
            ivSelected = view.findViewById(R.id.ivSelected);
            unitContainer = view.findViewById(R.id.clUnit);
            tvLine = view.findViewById(R.id.tvUnitLine);
        }
    }
    public void setListener(UnitAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }
    public interface OnItemClickListener{

        void OnSelect(int position, boolean type);
    }
}
