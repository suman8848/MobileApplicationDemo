package com.example.sumankhatiwada.firstapp.day3.ui.dashboard.food;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sumankhatiwada.firstapp.R;
import com.example.sumankhatiwada.firstapp.day3.model.Food;

import java.util.List;

/**
 * Created by sumankhatiwada on 4/6/18.
 */

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.FoodViewHolder> {

    List<Food> foodList;
    Context context;
    OnItemClickListener onItemClickListener;

    public interface OnItemClickListener{
       void onClick(Food foodItem);
    }

    public FoodListAdapter(List<Food> foods, Context context, OnItemClickListener onItemClickListener) {
        this.foodList = foods;
        Log.e("FoodList",foodList.size()+"");
        this.context  = context;
        this.onItemClickListener=onItemClickListener;
    }

    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_item, parent, false);
        FoodViewHolder pvh = new FoodViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(FoodViewHolder holder, int position) {
       final Food food = foodList.get(position);
        holder.foodName.setText(food.getFoodName());
        Log.e("FOODNAME",food.getFoodName());
        holder.foodDescription.setText(food.getFoodDescription());
        holder.foodPhoto.setImageResource(food.getFoodPhoto());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onClick(food);
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder {

//        @BindView(R.id.cv)
        CardView cv;
//        @BindView(R.id.food_name)
        TextView foodName;
//        @BindView(R.id.food_description)
        TextView foodDescription;
//        @BindView(R.id.food_photo)
        ImageView foodPhoto;

        public FoodViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            foodName= itemView.findViewById(R.id.name);
            foodDescription = itemView.findViewById(R.id.description);
            foodPhoto = itemView.findViewById(R.id.photo);

        }
    }
}
