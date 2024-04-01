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

import com.example.polymath.R;
import com.example.polymath.RecyclerView.ShapeAdapter;
import com.example.polymath.RecyclerView.ShapeModel;
import com.example.polymath.Solid.ConeActivity;
import com.example.polymath.Solid.CubeActivity;
import com.example.polymath.Solid.CylinderActivity;
import com.example.polymath.Solid.SphereActivity;

import java.util.ArrayList;

public class SolidFragment extends Fragment implements ShapeAdapter.ShapeAdapterListener {
    RecyclerView rvShape;
    ArrayList<ShapeModel> shapeList;
    private ShapeAdapter adapterShapeList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_shape, container, false);

        shapeList = new ArrayList<>();
        rvShape = view.findViewById(R.id.rvShape);

        shapeList.add(new ShapeModel("Cube", R.drawable.cube_black_icon));
        shapeList.add(new ShapeModel("Cone", R.drawable.cone_black_icon));
        shapeList.add(new ShapeModel("Cylinder", R.drawable.cylinder_black_icon));
        shapeList.add(new ShapeModel("Sphere", R.drawable.sphere_black_icon));

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
            case "Cube":
                shapeIntent = new Intent(getActivity(), CubeActivity.class);
                startActivity(shapeIntent);
                break;

            case "Cone":
                shapeIntent = new Intent(getActivity(), ConeActivity.class);
                startActivity(shapeIntent);
                break;

            case "Cylinder":
                shapeIntent = new Intent(getActivity(), CylinderActivity.class);
                startActivity(shapeIntent);
                break;

            case "Sphere":
                shapeIntent = new Intent(getActivity(), SphereActivity.class);
                startActivity(shapeIntent);
                break;

            default:
                break;
        }

    }
}

