package com.test.my.samplebinding.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.test.my.samplebinding.R;
import com.test.my.samplebinding.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity implements MainViewModel.View{

    private MainViewModel mainViewModel;
    RecyclerView recyclerView;
    TextView statusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        statusView = (TextView) findViewById(R.id.status);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        mainViewModel = new MainViewModel();
        mainViewModel.attachView(this);
        mainViewModel.init();
    }

    public void onUpdatePosts(View view){
        mainViewModel.getPosts();
    }

    @Override
    public RecyclerView getRecyclerView(){
        return recyclerView;
    }

    @Override
    public TextView getStatus(){
        return statusView;
    }

    @Override
    public Context getContext() {
        return this;
    }
}
