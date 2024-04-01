package com.example.polymath.RecyclerView;

import android.content.Context;
import android.graphics.drawable.shapes.Shape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.polymath.R;

import java.util.List;

public class ShapeAdapter extends RecyclerView.Adapter<ShapeAdapter.ViewHolder>{

    private List<ShapeModel> shapeList;
    private ShapeAdapterListener listener;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public ImageView ivImg;

        public ViewHolder(View view){
            super(view);
            tvName = view.findViewById(R.id.tvName);
            ivImg = itemView.findViewById(R.id.ivImg);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onShapeSelected(shapeList.get(getAdapterPosition()));
                }
            });

        }
    }

    public ShapeAdapter(List<ShapeModel> shapeList, ShapeAdapterListener listener){
        this.shapeList = shapeList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ShapeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ShapeAdapter.ViewHolder holder, int position) {
        final ShapeModel model = this.shapeList.get(position);
        holder.tvName.setText(model.getName());
        holder.ivImg.setImageResource(model.getImg());
    }

    @Override
    public int getItemCount() {
        return this.shapeList.size();
    }

    public interface ShapeAdapterListener {
        void onShapeSelected(ShapeModel shapeSelect);
    }
}


