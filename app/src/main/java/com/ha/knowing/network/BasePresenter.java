package com.ha.knowing.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/6/13.
 * 创建网络请求基类
 */
public abstract class BasePresenter {

    private final String GANK_BASE_URL = "http://gank.io/api/";

    protected final com.ha.knowing.network.homeApi homeApi;



    public BasePresenter() {

        Retrofit homeRetrofit = new Retrofit.Builder()
                .baseUrl(GANK_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //创建API接口
        homeApi = homeRetrofit.create(homeApi.class);

        //这里先不写下拉加载更多的逻辑
    }
    protected DataLoadStateListener dataLoadStateListener;

    public void setDataLoadStateListener(DataLoadStateListener dataLoadStateListener) {
        this.dataLoadStateListener = dataLoadStateListener;
    }

    public interface DataLoadStateListener {
        void dataIsLoaded();
    }

}
