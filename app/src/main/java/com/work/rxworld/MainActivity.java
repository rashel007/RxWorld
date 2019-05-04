package com.work.rxworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.work.rxworld.adapter.ItemAdapter;
import com.work.rxworld.model.Item;
import com.work.rxworld.network.ApiInterface;
import com.work.rxworld.network.NetworkClient;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerview;

    ApiInterface apiInterface;
    CompositeDisposable compositeDisposable = new CompositeDisposable();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init api
        Retrofit retrofit = NetworkClient.getInstance();

        apiInterface = retrofit.create(ApiInterface.class);

        // view
        recyclerview = findViewById(R.id.recyclerview);

        recyclerview.setHasFixedSize(true);

        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        fetchData();
    }

    private void fetchData() {

        compositeDisposable.add(apiInterface.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Item>>() {
                    @Override
                    public void accept(List<Item> itemList) throws Exception {
                        displayData(itemList);
                    }
                })
        );
    }

    private void displayData(List<Item> itemList) {

        ItemAdapter adapter = new ItemAdapter(this, itemList);
        recyclerview.setAdapter(adapter);
    }

    @Override
    protected void onStop() {
        compositeDisposable.dispose();
        super.onStop();
    }
}
