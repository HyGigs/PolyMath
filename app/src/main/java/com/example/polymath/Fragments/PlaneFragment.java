package com.example.polymath.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.polymath.Plane.CircleActivity;
import com.example.polymath.Plane.ParallelogramActivity;
import com.example.polymath.Plane.SquareActivity;
import com.example.polymath.Plane.TriangleActivity;
import com.example.polymath.R;
import com.example.polymath.RecyclerView.ShapeAdapter;
import com.example.polymath.RecyclerView.ShapeModel;

import java.util.ArrayList;

public class PlaneFragment extends Fragment implements ShapeAdapter.ShapeAdapterListener {
    RecyclerView rvShape;
    ArrayList<ShapeModel> shapeList;
    private ShapeAdapter adapterShapeList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_shape, container, false);

        shapeList = new ArrayList<>();
        rvShape = view.findViewById(R.id.rvShape);

        shapeList.add(new ShapeModel("Square", R.drawable.square_black_icon));
        shapeList.add(new ShapeModel("Triangle", R.drawable.triangle_black_icon));
        shapeList.add(new ShapeModel("Circle", R.drawable.circle_black_icon));
        shapeList.add(new ShapeModel("Parallelogram", R.drawable.parallelogram_black_icon));

        adapterShapeList = new ShapeAdapter(shapeList, this);
        rvShape.setAdapter(adapterShapeList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        rvShape.setLayoutManager(mLayoutManager);

        return view;
    }

    @Override
    public void onShapeSelected(ShapeModel shapeSelect) {
        String shapeName = shapeSelect.getName();
        Intent shapeIntent;

        switch (shapeName) {
            case "Square":
                shapeIntent = new Intent(getActivity(), SquareActivity.class);
                startActivity(shapeIntent);
                break;

            case "Triangle":
                shapeIntent = new Intent(getActivity(), TriangleActivity.class);
                startActivity(shapeIntent);
                break;

            case "Circle":
                shapeIntent = new Intent(getActivity(), CircleActivity.class);
                startActivity(shapeIntent);
                break;

            case "Parallelogram":
                shapeIntent = new Intent(getActivity(), ParallelogramActivity.class);
                startActivity(shapeIntent);
                break;

            default:
                break;
        }

    }
}

