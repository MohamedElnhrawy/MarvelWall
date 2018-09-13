package com.example.mohamedelnhrawy.marvelwalltask.ui.main;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.mohamedelnhrawy.marvelwalltask.R;
import com.example.mohamedelnhrawy.marvelwalltask.base.BaseActivity;
import com.example.mohamedelnhrawy.marvelwalltask.network.MarvelAPI;
import com.example.mohamedelnhrawy.marvelwalltask.network.apimodel.Marvel;
import com.example.mohamedelnhrawy.marvelwalltask.network.apimodel.MarvelList;
import com.example.mohamedelnhrawy.marvelwalltask.network.callback.ResponseCallback;
import com.example.mohamedelnhrawy.marvelwalltask.root.App;
import com.example.mohamedelnhrawy.marvelwalltask.ui.main.adapter.MarvelListAdapter;
import com.example.mohamedelnhrawy.marvelwalltask.utils.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainActivityMVP.View, MarvelListAdapter.onCardClicked, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    MainActivityMVP.Presenter presenter;

    private MarvelListAdapter adapter;
    private  List<Marvel> marvelList=new ArrayList<>();

    @BindView(R.id.rv_marvellist)
    RecyclerView rv_marvellist;
    @BindView(R.id.swiperefresh)
    SwipeRefreshLayout swiperefresh;


    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App) getApplication()).getComponent().injectMain(this);
        ButterKnife.bind(this);
        setupSwipeRefresh(swiperefresh);
        setUpRecyclerView(rv_marvellist);
        updateData();

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();

    }


    @Override
    public void updateData() {

        if (isNetworkConnected()){
            showLoading();
            presenter.LoadData(new ResponseCallback() {
                @Override
                public void onsuccess(Object object) {
                    marvelList= (List<Marvel>) object;
                    adapter.updateList(marvelList);

                    hideLoading();
                }

                @Override
                public void onError(String error) {
                    showSnackbar(error);
                    Log.e("error",error);
                    hideLoading();
                }
            });
        }else
        {
            showMessage(getString(R.string.checkconnection));
        }

    }

    @Override
    public void setUpRecyclerView(RecyclerView recyclerView) {
        adapter=new MarvelListAdapter(this,marvelList);
        adapter.setItemClickedCallback(this);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void showSnackbar(String error) {
        showSnackBar(error);
    }

    @Override
    public void setupSwipeRefresh(SwipeRefreshLayout swiperefresh) {
        swiperefresh.setOnRefreshListener(this);
    }

    @Override
    public void onItemClicked(int position, Marvel marvel) {
        showSnackBar(marvel.getTitle());
    }

    @Override
    public void onRefresh() {
        swiperefresh.setRefreshing(false);
        updateData();
    }
}
