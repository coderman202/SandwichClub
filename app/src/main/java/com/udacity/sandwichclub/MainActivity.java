package com.udacity.sandwichclub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.udacity.sandwichclub.adapters.SandwichDetailAdapter;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.sandwiches_listview)
    RecyclerView sandwichesRecyclerView;

    SandwichDetailAdapter sandwichDetailAdapter;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_names);
        List<String> sandwichList = Arrays.asList(sandwiches);

        sandwichDetailAdapter = new SandwichDetailAdapter(this, sandwichList);

        layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        sandwichesRecyclerView.setLayoutManager(layoutManager);
        sandwichesRecyclerView.setAdapter(sandwichDetailAdapter);

    }
}
