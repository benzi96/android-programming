package com.assignment.minhlk.clevelandtour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rc;
    RcAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rc = (RecyclerView)findViewById(R.id.rc);
        ArrayList<Location> arr = new ArrayList<>();
        arr.add(new Location("SGU","10.760135","106.682289","https://sgu.edu.vn/"));
        arr.add(new Location("Ben Thanh Market","10.772258","106.698279","http://www.chobenthanh.org.vn/"));
        arr.add(new Location("Dam Sen Park","10.766149","106.639483","http://www.damsenpark.com.vn/"));
        arr.add(new Location("Tan San Nhat airport","10.818358","106.658451","http://tansonnhatairport.vn/"));
        arr.add(new Location("Independence Hall","10.777465","106.695475","http://ditich.dinhdoclap.gov.vn/vi-vn/trang-chu.aspx"));
        adapter = new RcAdapter(arr,this);
        rc.setLayoutManager(new LinearLayoutManager(this));
        rc.setAdapter(adapter);


    }
}
