package com.bw.week1_one.view.fragment;


import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.model.ModelLoader;
import com.bw.week1_one.R;
import com.bw.week1_one.base.BaseFragment;
import com.bw.week1_one.contract.ZhengContract;
import com.bw.week1_one.database.DaoMaster;
import com.bw.week1_one.database.GetJsonDao;
import com.bw.week1_one.model.GetJson;
import com.bw.week1_one.model.bean.ZhengBean;
import com.bw.week1_one.presenter.Zhengpresenter;
import com.bw.week1_one.util.NetUtil;
import com.bw.week1_one.view.adapter.ZhengAdapter;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhengFragment extends BaseFragment<Zhengpresenter> implements ZhengContract.IView {


    @BindView(R.id.xRecyle)
    XRecyclerView xRecyle;
    private GetJsonDao getJsonDao;
    List<ZhengBean.SubjectsBean> subjects=new ArrayList<>();
    int page=1;
    @Override
    protected void initData() {
        if(NetUtil.getInstance().hasNet(getContext())){
            mPresenter.getZhengData();
        }else{
            List<GetJson> list = getJsonDao.queryBuilder().list();
            for (int i = 0; i <list.size() ; i++) {
                GetJson getJson = list.get(i);
                String json = getJson.getJson();
                ZhengBean zhengBean = new Gson().fromJson(json, ZhengBean.class);
                List<ZhengBean.SubjectsBean> subjects2 = zhengBean.getSubjects();
                subjects.addAll(subjects2);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                xRecyle.setLayoutManager(linearLayoutManager);
                ZhengAdapter zhengAdapter = new ZhengAdapter(subjects);
                xRecyle.setAdapter(zhengAdapter);

            }
        }


    }

    @Override
    protected void initView(View inflate) {
        xRecyle.setLoadingMoreEnabled(true);
        xRecyle.setPullRefreshEnabled(true);
        xRecyle.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
              xRecyle.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                xRecyle.loadMoreComplete();

            }
        });


        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getContext(), "app.db");
        SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(writableDatabase);
        getJsonDao = daoMaster.newSession().getGetJsonDao();

    }

    @Override
    protected Zhengpresenter proviePresenter() {
        return new Zhengpresenter();
    }

    @Override
    protected int layouutId() {
        return R.layout.fragment_zheng;
    }

    @Override
    public void onZhengSuccess(ZhengBean zhengbean) {
        Toast.makeText(getContext(), "成功", Toast.LENGTH_SHORT).show();

        String s = new Gson().toJson(zhengbean);
        getJsonDao.insert(new GetJson(null,s));

        List<ZhengBean.SubjectsBean> subjects1 = zhengbean.getSubjects();
        subjects.addAll(subjects1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        xRecyle.setLayoutManager(linearLayoutManager);
        ZhengAdapter zhengAdapter = new ZhengAdapter(subjects);
        xRecyle.setAdapter(zhengAdapter);


    }

    @Override
    public void onZhengFailure(Throwable throwable) {
        Toast.makeText(getContext(), "失败", Toast.LENGTH_SHORT).show();


    }
}
