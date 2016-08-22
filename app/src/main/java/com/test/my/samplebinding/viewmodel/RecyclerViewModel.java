package com.test.my.samplebinding.viewmodel;

import android.databinding.BaseObservable;

import com.test.my.samplebinding.model.Post;


/**
 * Created by Android-dev on 10.08.2016.
 */
public class RecyclerViewModel extends BaseObservable {
    private Post post;

    public RecyclerViewModel(Post post) {
        this.post = post;
    }

    public int getUserID(){
        return post.getId();
    }

    public String getTitle(){
        return post.getTitle();
    }

    public String getDescription(){
        return post.getBody();
    }

    public void setPost(Post post){
        this.post = post;
        notifyChange();
    }
}
