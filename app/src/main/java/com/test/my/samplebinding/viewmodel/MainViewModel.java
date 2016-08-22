package com.test.my.samplebinding.viewmodel;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;


import com.test.my.samplebinding.adapters.RecycleViewAdapter;
import com.test.my.samplebinding.interfaces.Callback;
import com.test.my.samplebinding.model.NetModel;
import com.test.my.samplebinding.model.Post;
import com.test.my.samplebinding.retrofit.entries.JsonPost;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android-dev on 09.08.2016.
 */
public class MainViewModel extends BaseProgressViewModel<MainViewModel.View> {
    private RecycleViewAdapter adapter;
    private NetModel netModel = NetModel.instance();

    public MainViewModel(){

    }

    public void init(){
        RecyclerView recyclerView = view.getRecyclerView();
        adapter = new RecycleViewAdapter(null);

        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);
        getPosts();
    }

    public void getPosts(){
        final TextView status = view.getStatus();
        showProgress();
        netModel.getPosts(new Callback<List<JsonPost>>() {
            @Override
            public void T(List<JsonPost> jsonPosts) {
                hideProgress();
                ArrayList<Post> list = new ArrayList<Post>();
                for (JsonPost post : jsonPosts) {
                    list.add(new Post(post.getUserId(), post.getId(), post.getTitle(), post.getBody()));
                }
                adapter.setPosts(list);
                adapter.notifyDataSetChanged();
                status.setText(view.getContext().getString(android.R.string.ok));
            }
        }, new Callback<String>() {
            @Override
            public void T(String s) {
                status.setText(s);
            }
        });
    }

    public interface View extends BaseViewModelInterface {
        RecyclerView getRecyclerView();
        TextView getStatus();
    }
}
