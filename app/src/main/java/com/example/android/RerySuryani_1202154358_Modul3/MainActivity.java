package com.example.android.RerySuryani_1202154358_Modul3;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Main> mMainData;
    private MainAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mMainData = new ArrayList<>();

        mAdapter = new MainAdapter (this, mMainData);
        mRecyclerView.setAdapter(mAdapter);

        initializeData();
    }
    private void initializeData (){
        String[] mainList = getResources().getStringArray(R.array.main_titles);
        String[] mainInfo = getResources().getStringArray(R.array.main_info);
        TypedArray mainImageResource = getResources().obtainTypedArray(R.array.main_images);

        mMainData.clear();

        for(int i=0; i<mainList.length; i++){
            mMainData.add(new Main(mainList[i], mainInfo[i],
                    mainImageResource.getResourceId(i,0)));
        }

        //Recycle the typed array
        mainImageResource.recycle();

        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
    }
}
