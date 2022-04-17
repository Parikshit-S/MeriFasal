package com.example.android.merifasal.ui.Shop;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.airbnb.lottie.L;
import com.example.android.merifasal.R;
import com.example.android.merifasal.ui.Categories.ProfileActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ShopFragment extends Fragment {

    View v;
    RecyclerView recyclerView;
    List<ModelClass> mList;
    CustomAdapter customAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_shop, container, false);
        recyclerView=v.findViewById(R.id.recyclerviewId);
        customAdapter= new CustomAdapter(mList, getContext());
        recyclerView.setAdapter(customAdapter);
      //  recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //LinearLayoutManager layoutManager=new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
       // recyclerView.setLayoutManager(layoutManager);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);


        final ImageView btnCart = v.findViewById(R.id.cart);
        final ImageView userProfile = v.findViewById(R.id.btn_userprofile);

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CartActivity.class);
                startActivity(intent);
            }
        });


        userProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });


        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mList=new ArrayList<>();
        mList.add(new ModelClass(R.drawable.channa, "Channa"));
        mList.add(new ModelClass(R.drawable.wheat, "Wheat"));
        mList.add(new ModelClass(R.drawable.makka, "Makka"));
        mList.add(new ModelClass(R.drawable.jav, "Jav"));
        mList.add(new ModelClass(R.drawable.bajara, "Baajra"));
        mList.add(new ModelClass(R.drawable.soya_bean, "Soyabean"));

    }
}