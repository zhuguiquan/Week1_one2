package com.bw.week1_one.view.fragment;


import android.util.Log;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.week1_one.R;
import com.bw.week1_one.base.BaseFragment;
import com.bw.week1_one.contract.JiContract;
import com.bw.week1_one.model.bean.JiBean;
import com.bw.week1_one.presenter.JiPresenter;
import com.bw.week1_one.view.adapter.JiAdapter;
import com.bw.week1_one.view.adapter.ZhengAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class JiFragment extends BaseFragment<JiPresenter> implements JiContract.IView {


    @BindView(R.id.recyle)
    XRecyclerView recyle;

    @Override
    protected void initData() {
        mPresenter.getJiData();

    }

    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected JiPresenter proviePresenter() {
        return new JiPresenter();
    }

    @Override
    protected int layouutId() {
        return R.layout.fragment_ji;
    }

    @Override
    public void onJiSuccess(JiBean jiBean) {
        Log.i("xxx",jiBean.getTitle());
        List<JiBean.SubjectsBean> subjects = jiBean.getSubjects();
        GridLayoutManager linearLayoutManager = new GridLayoutManager(getContext(), 3);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyle.setLayoutManager(linearLayoutManager);
        JiAdapter jiAdapter = new JiAdapter(subjects);
        recyle.setAdapter(jiAdapter);

    }

    @Override
    public void onJiFailure(Throwable throwable) {

    }
}
