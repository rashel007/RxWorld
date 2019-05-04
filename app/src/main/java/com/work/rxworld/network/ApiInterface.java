package com.work.rxworld.network;

import com.work.rxworld.model.Item;

import java.util.List;

import io.reactivex.Observer;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("posts")
    Observer<List<Item>> getPosts();

}
