package com.example.sumankhatiwada.firstapp.day3.ui.dashboard.electronics;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sumankhatiwada.firstapp.R;
import com.example.sumankhatiwada.firstapp.day3.model.ElectronicItem;

import java.util.List;

/**
 * Created by sumankhatiwada on 4/7/18.
 */

public class ElectronicsListAdapter  extends RecyclerView.Adapter<ElectronicsListAdapter.ElectronicsViewHolder> {

    List<ElectronicItem> electronicItemsList;

    public interface OnItemClickListener {
        void onItemClick(ElectronicItem item);
    }

    private OnItemClickListener listener;


    Context context;
    public ElectronicsListAdapter(List<ElectronicItem> foods, Context context, OnItemClickListener listener) {
        this.electronicItemsList = foods;
        Log.e("FoodList",electronicItemsList.size()+"");
        this.context  = context;
       this.listener = listener;

    }

    @Override
    public ElectronicsListAdapter.ElectronicsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_item, parent, false);
        ElectronicsListAdapter.ElectronicsViewHolder pvh = new ElectronicsListAdapter.ElectronicsViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ElectronicsListAdapter.ElectronicsViewHolder holder, int position) {
        final ElectronicItem electronicItem = electronicItemsList.get(position);
        holder.foodName.setText(electronicItem.getElectronicItemName());
//        Log.e("FOODNAME",foodList.get(position).getFoodName());
        holder.foodDescription.setText(electronicItem.getElectronicItemDetails());
        holder.foodPhoto.setImageResource(electronicItem.getElectronicItemPhoto());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(electronicItem);
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return electronicItemsList.size();
    }

    public static class ElectronicsViewHolder extends RecyclerView.ViewHolder {

        //        @BindView(R.id.cv)
        CardView cv;
        //        @BindView(R.id.food_name)
        TextView foodName;
        //        @BindView(R.id.food_description)
        TextView foodDescription;
        //        @BindView(R.id.food_photo)
        ImageView foodPhoto;

        public ElectronicsViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            foodName= itemView.findViewById(R.id.name);
            foodDescription = itemView.findViewById(R.id.description);
            foodPhoto = itemView.findViewById(R.id.photo);

        }
    }
}
