package first.test.a1217.view;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import first.test.a1217.R;
import first.test.a1217.adapter.HomeAdapter;
import first.test.a1217.base.BaseActivity;
import first.test.a1217.base.BasePresenter;
import first.test.a1217.base.BaseView;
import first.test.a1217.bean.SchoolBean;
import first.test.a1217.contract.SchoolContract;
import first.test.a1217.presenter.SchoolPresenterImp;

public class MainActivity extends BaseActivity<SchoolPresenterImp> implements SchoolContract.MainView {

    private RecyclerView mRecycler;
    private ArrayList<SchoolBean.NewsBean> list;
    private HomeAdapter homeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    @Override
    protected int getLayouID() {
        return R.layout.activity_main;
    }

    protected void initView() {
        mRecycler = findViewById(R.id.recycler);
        list = new ArrayList<>();
        homeAdapter = new HomeAdapter(this, list);
        mRecycler.setAdapter(homeAdapter);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    @Override
    protected void initData() {
        persenter.par();
    }

    @Override
    protected SchoolPresenterImp getPersenter() {
        return new SchoolPresenterImp(this);
    }

    @Override
    public void getSchool(SchoolBean schoolBean) {
        List<SchoolBean.NewsBean> news = schoolBean.getNews();
        list.addAll(news);
        homeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String error) {
        Log.e("TAG", "onError: 错误异常"+error);
    }
}