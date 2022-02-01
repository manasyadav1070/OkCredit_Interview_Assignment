package com.example.okcredit.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.okcredit.IngereidentsActivity;
import com.example.okcredit.R;
import com.example.okcredit.model.Meal;
import com.example.okcredit.response.response;

import java.util.List;
import java.util.ResourceBundle;

public class foodadapter extends RecyclerView.Adapter<foodadapter.ViewHolder> {

    private Context context;
    List<Meal> mealList;

    public foodadapter(Context context, List<Meal> mealList)
    {
        this.context = context;
        this.mealList = mealList;
    }

    @NonNull
    @Override
    public foodadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull foodadapter.ViewHolder holder, int position) {
        Meal meal = mealList.get(position);
        holder.textView.setText(meal.getStrMeal());
        Glide.with(context).load(meal.getStrMealThumb()).into(holder.imageView);
        holder.cardView.setOnClickListener(view -> {
            //todo
            Intent myIntent = new Intent(context, IngereidentsActivity.class);
            myIntent.putExtra("key", meal.getIdMeal()); //Optional parameters
            context.startActivity(myIntent);
        });
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        final ImageView imageView;
        final TextView textView;
        final CardView cardView;
        //private final String ID;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            cardView = itemView.findViewById(R.id.card);
        }
    }
}
