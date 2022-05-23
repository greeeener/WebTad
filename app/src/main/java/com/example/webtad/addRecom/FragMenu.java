package com.example.webtad.addRecom;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webtad.MainActivity;
import com.example.webtad.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FragMenu extends Fragment implements View.OnClickListener{

    public static FragMenu newInstance() {
        return new FragMenu();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View v = inflater.inflate(R.layout.frag_menu, container, false);

        Fragment fg;
        fg = muFragAdd.newInstance();
        setChildFragment(fg);

        ImageButton muAddBtn = v.findViewById(R.id.muAddBtn);
        muAddBtn.setOnClickListener(this);
        ImageButton muListBtn = v.findViewById(R.id.muListBtn);
        muListBtn.setOnClickListener(this);


        return v;
    }


    @Override
    public void onClick(View v) {
        Fragment fg;
        switch(v.getId())
        {
            case R.id.muAddBtn:
                fg = muFragAdd.newInstance();
                setChildFragment(fg);
                break;
            case R.id.muListBtn:
                fg = muFragList.newInstance();
                setChildFragment(fg);
                break;


        }
    }

    private void setChildFragment(Fragment child) {
        FragmentTransaction childFt = getChildFragmentManager().beginTransaction();

        if (!child.isAdded()) {
            childFt.replace(R.id.child_fragment, child);
            childFt.addToBackStack(null);
            childFt.commit();
        }
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
