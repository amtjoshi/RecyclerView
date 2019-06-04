package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int[] image={R.drawable.flower1,R.drawable.flower2,R.drawable.flower3,R.drawable.flower4,R.drawable.flower5,R.drawable.flower6,R.drawable.flower7,R.drawable.flower8,R.drawable.flower9,R.drawable.flower10,R.drawable.flower11,R.drawable.flower12,R.drawable.flower13,R.drawable.flower14,R.drawable.flower15};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] title= getResources().getStringArray(R.array.tittle);
        ArrayList<DataModel> arrayList=new ArrayList<DataModel>();
        for(int i=0;i<title.length;i++)
        {


            arrayList.add(new DataModel(image[i],title[i]));
        }
        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setAdapter(new MyAdapter(arrayList));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
