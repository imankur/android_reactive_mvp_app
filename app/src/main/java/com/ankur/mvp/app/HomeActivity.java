package com.ankur.mvp.app;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;

import com.ankur.mvp.app.data.DaggerQuestionRepositoryComponent;
import com.ankur.mvp.app.model.Question;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements HomeContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.listview)
    RecyclerView list;
    @BindView(R.id.swipeContainer)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.parent)
    RelativeLayout parent;

    @Inject
    HomePresenter presenter;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        injectPresenter();
        toolbar.setTitle("Questions");
        setSupportActionBar(toolbar);
        setupViews();
    }

    private void injectPresenter() {
        DaggerHomePresenterComponent
                .builder()
                .homePresenterModule(new HomePresenterModule(this))
                .questionRepositoryComponent(DaggerQuestionRepositoryComponent.builder().build())
                .build()
                .inject(this);
    }

    private void setupViews() {
        refreshLayout.setColorSchemeResources(R.color.red,
                R.color.green,
                R.color.orange,
                R.color.blue);
        refreshLayout.setSize(SwipeRefreshLayout.LARGE);
        refreshLayout.invalidate();
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.setData(null);
                presenter.getQuestions();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        adapter = new ListAdapter();
        list.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        refreshLayout.setRefreshing(true);
        presenter.start();
    }

    @Override
    public void showErrors() {
        if (refreshLayout.isRefreshing()) refreshLayout.setRefreshing(false);
        Snackbar.make(parent, "Ohh noo.. Error occurred.", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void hideProgressBar() {
        if (refreshLayout.isRefreshing()) refreshLayout.setRefreshing(false);
    }

    @Override
    public void setDataInList(List<Question> questions) {
        adapter.setData(questions);
    }

}
