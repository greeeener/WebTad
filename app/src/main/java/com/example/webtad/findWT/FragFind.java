package com.example.webtad.findWT;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.webtad.R;
import com.example.webtad.addRecom.muFragAdd;
import com.example.webtad.addRecom.muFragList;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragFind extends Fragment implements View.OnClickListener {

    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    findData fdt;
    ArrayList<findData> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View v = inflater.inflate(R.layout.frag_find, container, false);

        recyclerView = v.findViewById(R.id.recy_find);

        Button naver= v.findViewById(R.id.naver);
        naver.setOnClickListener(this);
        Button kakao = v.findViewById(R.id.kakao);
        kakao.setOnClickListener(this);
        Button kkopage= v.findViewById(R.id.kkopage);
        kkopage.setOnClickListener(this);
        Button lezhin = v.findViewById(R.id.lezhin);
        lezhin.setOnClickListener(this);


        return v;

    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.naver: {
                //recyclerView.removeAllViewsInLayout();
                data.clear();
                try {
                    parser("naver_keyword.json");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                adapter = new findAdapter(data);
                recyclerView.setAdapter(adapter);
                break;
            }
            case R.id.kakao:{
                //recyclerView.removeAllViewsInLayout();
                data.clear();
                try {
                    parser("kakao_keyword.json");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                adapter = new findAdapter(data);
                recyclerView.setAdapter(adapter);
                break;
            }
            case R.id.kkopage:{
                //recyclerView.removeAllViewsInLayout();
                data.clear();
                try {
                    parser("kkopage_keyword.json");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                adapter = new findAdapter(data);
                recyclerView.setAdapter(adapter);
                break;
            }
            case R.id.lezhin:{
                //recyclerView.removeAllViewsInLayout();
                data.clear();
                try {
                    parser("lezhin_keyword.json");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                adapter = new findAdapter(data);
                recyclerView.setAdapter(adapter);
                break;
            }

        }
    }

    private void parser(String file) throws IOException {
        InputStream is = getActivity().getAssets().open(file);
        InputStreamReader inputStreamReader = new InputStreamReader(is);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuffer stringBuffer = new StringBuffer();
        String line = null;

        try {
            while ((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line);
            }
            Log.v("TAG", "StringBuffer : "+ stringBuffer.toString()) ;
            JSONObject jsonObject = new JSONObject(stringBuffer.toString());
            JSONArray jsonArray = new JSONArray(jsonObject.getString("Webtoon"));
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
                String thumbnail = jsonObject1.getString("thumbnail");
                String title = jsonObject1.getString("title");
                String author = jsonObject1.getString("author");
                String platform = jsonObject1.getString("platform");
                fdt = new findData(thumbnail, title, author, platform);
                data.add(fdt);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(is != null) is.close();
                if(inputStreamReader !=null) inputStreamReader.close();
                if(bufferedReader != null) bufferedReader.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}