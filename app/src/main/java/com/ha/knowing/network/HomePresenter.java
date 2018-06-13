package com.ha.knowing.network;

import android.content.Context;

import com.ha.knowing.Adapter.FoodAdapter;
import com.ha.knowing.beans.MeizhiBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/6/13.
 */
public class HomePresenter extends BasePresenter {

    private final int REFRESH = 0;

    private FoodAdapter foodAdapter;

    Context context;

    private int page;



    public HomePresenter(Context context, FoodAdapter foodAdapter) {

        this.context = context;
        this.foodAdapter = foodAdapter;
    }



    public void getLoadData(final int loadWay) {

        if (loadWay == REFRESH) {
            page = 1;
        }
        System.out.println("=========1====");
        page = 1;
        Call<MeizhiBean> meiZhi = homeApi.getMeiZhi(page++);
        meiZhi.enqueue(new Callback<MeizhiBean>() {






            @Override
            public void onResponse(Call<MeizhiBean> call, Response<MeizhiBean> response) {

                List<MeizhiBean.ResultsBean> results = response.body().getResults();
                foodAdapter = new FoodAdapter();
                HomePresenter.this.foodAdapter.setDataList(results);
            }



            @Override
            public void onFailure(Call<MeizhiBean> call, Throwable t) {

            }
        });
    }
}
