package com.example.android.merifasal.ui.home;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.android.merifasal.CustomAdapter;
import com.example.android.merifasal.ModelClass;
import com.example.android.merifasal.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    View v;
    RecyclerView recyclerView;
    List<ModelClass> mList;
    CustomAdapter customAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView=v.findViewById(R.id.recyclerViewId);
        customAdapter=new CustomAdapter(mList, getContext());
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mList=new ArrayList<>();
        mList.add(new ModelClass(R.drawable.wheat,"Wheat/गेहूं"));
        mList.add(new ModelClass(R.drawable.makka, "Makka/मक्का"));
        mList.add(new ModelClass(R.drawable.channa, "Channa/चन्ना"));
        mList.add(new ModelClass(R.drawable.jav, "Jav/जौ"));
        mList.add(new ModelClass(R.drawable.bajara, "Baajra/बाजरा"));
        mList.add(new ModelClass(R.drawable.soya_bean, "SoyaBean/सोया बीन"));
    }
}