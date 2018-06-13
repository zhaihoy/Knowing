package com.ha.knowing.network;

import com.ha.knowing.beans.DailyGankBean;
import com.ha.knowing.beans.MeizhiBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2018/6/13.
 */
public interface homeApi {

    @GET("day/{date}")
    Call<DailyGankBean> getDailyGank(@Path("date") String date);

    @GET("data/福利/15/{page}")
    Call<MeizhiBean> getMeiZhi(@Path("page") int page);
}
