package com.application.mydsu.HomeWork;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.mydsu.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    private ArrayList<UserEntity> arrayList = new ArrayList<>();
    private HomeWork homeWork;

    public void setArrayList(ArrayList<UserEntity> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    public RecyclerViewAdapter(ArrayList<UserEntity> arrayList, HomeWork homeWork) {
        this.homeWork = homeWork;
        this.arrayList = arrayList;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView userName;
        TextView surName;
        ImageView imageImpotance;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.userName);
            surName = itemView.findViewById(R.id.surName);
            imageImpotance = itemView.findViewById(R.id.imageImpotance);
        }
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, final int position) {
        final UserEntity userEntity = arrayList.get(position);
        holder.userName.setText(userEntity.getuserName());
        holder.surName.setText(userEntity.getUserSurName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeWork.addUserAlertDialog(true,userEntity,position);
            }
        });
        if(userEntity.getSelectedImpotance() == 1){
            holder.imageImpotance.setBackground(homeWork.getResources().getDrawable(R.drawable.element_of_impotence_green));
        }else if(userEntity.getSelectedImpotance() == 2){
            holder.imageImpotance.setBackground(homeWork.getResources().getDrawable(R.drawable.element_of_impotence_yellow));
        }else if(userEntity.getSelectedImpotance() == 3){
            holder.imageImpotance.setBackground(homeWork.getResources().getDrawable(R.drawable.element_of_impotence_red));
        }
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
