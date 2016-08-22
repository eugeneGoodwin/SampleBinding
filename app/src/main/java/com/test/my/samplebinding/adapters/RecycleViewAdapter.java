package com.test.my.samplebinding.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.test.my.samplebinding.R;
import com.test.my.samplebinding.databinding.RecyclerItemBinding;
import com.test.my.samplebinding.model.Post;
import com.test.my.samplebinding.viewmodel.RecyclerViewModel;

import java.util.List;

/**
 * Created by Android-dev on 10.08.2016.
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.RecycleViewHolder>{

    private List<Post> posts;

    public RecycleViewAdapter(List<Post> posts) {
        this.posts = posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.recycler_item,
                parent,
                false);
        return new RecycleViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecycleViewHolder holder, int position) {
        holder.bindPost(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return (this.posts != null)? this.posts.size() : 0;
    }

    public static class RecycleViewHolder extends RecyclerView.ViewHolder {
        final RecyclerItemBinding binding;

        public RecycleViewHolder(RecyclerItemBinding binding) {
            super(binding.linearRecycler);
            this.binding = binding;
        }

        void bindPost(Post post) {
            if (binding.getRecyclerModel() == null) {
                binding.setRecyclerModel(new RecyclerViewModel(post));
            } else {
                binding.getRecyclerModel().setPost(post);
            }
        }
    }

}
