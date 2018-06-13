package com.ha.knowing.fragment;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ha.knowing.Adapter.FoodAdapter;
import com.ha.knowing.R;
import com.ha.knowing.network.HomePresenter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.bezierlayout.BezierLayout;

/**
 * Created by Administrator on 2018/6/12.
 */
public class HomeFragment extends BaseFragment {

    HomePresenter mHomePresenter;

    private FoodAdapter foodAdapter;

    private final int REFRESH = 0;

    private HomePresenter homePresenter;



    //初始化Fragment的布局文件
    @Override
    public int getLayoutId() {

        return R.layout.homefragment_layout;
    }



    @Override
    protected void initView(View view) {

        homePresenter = new HomePresenter(getContext(), foodAdapter);
        setupRecyclerView((RecyclerView) view.findViewById(R.id.recyclerview), view);

        //可以在这里做网络请求

    }



    private void setupRecyclerView(RecyclerView rv, View view) {

        rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));
        foodAdapter = new FoodAdapter();
        rv.setAdapter(foodAdapter);

        final TwinklingRefreshLayout refreshLayout = (TwinklingRefreshLayout) view.findViewById(R.id.refresh);
//        ProgressLayout headerView = new ProgressLayout(getContext());
        BezierLayout headerView = new BezierLayout(getContext());
        refreshLayout.setHeaderView(headerView);
//        refreshLayout.setFloatRefresh(false);
        refreshLayout.setPureScrollModeOn();
//        refreshLayout.setEnableOverlayRefreshView(false);
//        refreshLayout.setAutoLoadMore(true);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                homePresenter .getLoadData(REFRESH);
            }
        }, 1000);

//        refreshCard();

    }



//    private void refreshCard() {
//        List<Food> foods = new ArrayList<>();
//        new HomePresenter(getContext(), foodAdapter);
//        foods.add(new Food("Preparing Salmon Steak Close Up", "BY VIKTOR HANACEK", R.drawable.food1, R.drawable.avatar0));
//        foods.add(new Food("Fresh & Healthy Fitness Broccoli Pie with Basil", "BY VIKTOR HANACEK", R.drawable.food2, R.drawable.avatar1));
//        foods.add(new Food("Enjoying a Tasty Burger", "BY VIKTOR HANACEK", R.drawable.food3, R.drawable.avatar2));
//        foods.add(new Food("Fresh Strawberries and Blackberries in Little Bowl", "BY VIKTOR HANACEK", R.drawable.food4, R.drawable.avatar3));
//        foods.add(new Food("Baked Healthy Fitness Broccoli Pie with Basil", "BY VIKTOR HANACEK", R.drawable.food5, R.drawable.avatar4));
//        foodAdapter.setDataList(foods);

//    }



    @Override
    public String getName() {

        return "Phone";
    }
}
