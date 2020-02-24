package com.bw.week1_one.presenter;

import com.bw.week1_one.base.BasePresenter;
import com.bw.week1_one.contract.JiContract;
import com.bw.week1_one.model.JiModel;
import com.bw.week1_one.model.bean.JiBean;

/**
 * DateTime:2020/2/22 0022
 * author:朱贵全(Administrator)
 * function:
 */
public class JiPresenter extends BasePresenter<JiContract.IView> implements JiContract.IPresenter {

    private JiModel jiModel;

    @Override
    protected void initModel() {
        jiModel = new JiModel();
    }

    @Override
    public void getJiData() {
        jiModel.getJiData( new JiContract.IModel.IModelCallback() {
            @Override
            public void onJiSuccess(JiBean jiBean) {
                view.onJiSuccess(jiBean);
            }

            @Override
            public void onJiFailure(Throwable throwable) {
                view.onJiFailure(throwable);
            }
        });

    }
}
