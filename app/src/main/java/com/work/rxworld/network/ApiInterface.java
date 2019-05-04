package com.work.rxworld.network;

import com.work.rxworld.model.Item;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("posts")
    Observable<List<Item>> getPosts();

}
