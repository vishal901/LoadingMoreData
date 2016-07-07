package com.android.loadingmoredata;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String URL_ROOT = "http://nearely.com/nearely/index.php/api/";
    private RecyclerView recyclerView;
    private List<ResponseData.OffersBean> datas;
    private DataAdapter adapter;
    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;
    private OnLoadMoreListener mOnLoadMoreListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);


        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl(URL_ROOT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        InterfaceApi interfaceApi = retrofit.create(InterfaceApi.class);
        Call<ResponseData> regDataCall = interfaceApi.reg_method();

        regDataCall.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, final Response<ResponseData> response) {
                Log.e("reaponse", String.valueOf(response.code()));

                if (response.isSuccessful()) {

                    if (response.code() == 200) {


                        ResponseData data = response.body();

                        datas = new ArrayList<ResponseData.OffersBean>(data.getOffers());

                        adapter = new DataAdapter(datas, recyclerView);
                        recyclerView.setAdapter(adapter);

                        adapter.setOnLoadMoreListener(new OnLoadMoreListener() {
                            @Override
                            public void onLoadMore() {

                                Log.e("haint", "Load More");

                                datas.add(null);
                                adapter.notifyItemRemoved(datas.size() - 1);

                                new Handler().postDelayed(new Runnable() {

                                    @Override
                                    public void run() {

                                        datas.remove(datas.size() - 1);
                                        adapter.notifyItemRemoved(datas.size());

                                        int index = datas.size();
                                        int end = index + 10;
                                        int i;
                                        for (i = index; i < end; i++) {

                                            ResponseData data = response.body();

                                            datas = new ArrayList<ResponseData.OffersBean>(data.getOffers());


                                           // datas.add((ResponseData.OffersBean) data.getOffers() + i);
//                                            adapter = new DataAdapter(datas, recyclerView);
//                                            recyclerView.setAdapter(adapter);
                                        }
                                        adapter.notifyDataSetChanged();
                                        adapter.setLoaded();

                                    }
                                }, 5000);
                            }
                        });


                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Log.e("reaponse", t.getMessage());
            }
        });
    }


}
