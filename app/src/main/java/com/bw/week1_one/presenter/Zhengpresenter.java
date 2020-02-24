package com.bw.week1_one.presenter;

import com.bw.week1_one.base.BasePresenter;
import com.bw.week1_one.contract.ZhengContract;
import com.bw.week1_one.model.bean.ZhengBean;
import com.bw.week1_one.model.ZhengModel;

/**
 * DateTime:2020/2/22 0022
 * author:朱贵全(Administrator)
 * function:
 */
public class Zhengpresenter extends BasePresenter<ZhengContract.IView> implements ZhengContract.IPresenter {

    private ZhengModel zhengModel;

    @Override
    protected void initModel() {
        zhengModel = new ZhengModel();
    }

    @Override
    public void getZhengData() {
        zhengModel.getZhengData( new ZhengContract.IModel.IModelCallback() {
            @Override
            public void onZhengSuccess(ZhengBean zhengbean) {
                view.onZhengSuccess(zhengbean);
            }

            @Override
            public void onZhengFailure(Throwable throwable) {
                view.onZhengFailure(throwable);
            }
        });

    }
}
