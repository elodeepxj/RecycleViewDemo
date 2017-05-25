package com.jokerpeng.demo.recycleviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> mList;
    private MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initAction();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.rv);
    }

    private void initData() {
        mList = new ArrayList<>();
        for(int i =0;i<20;i++){
            mList.add("数据"+i);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        myAdapter = new MyAdapter(mList);
        recyclerView.setAdapter(myAdapter);
    }

    private void initAction() {
        myAdapter.setRecyclerViewItemClickListerner(new MyAdapter.onRecyclerViewItemClickListerner() {

            @Override
            public void onItemClick(View view, int position) {
                myAdapter.addItem(position);
            }
        });
    }

}
