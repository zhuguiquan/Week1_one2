package com.bw.week1_one.model;

import com.bw.week1_one.contract.ZhengContract;
import com.bw.week1_one.model.bean.ZhengBean;
import com.bw.week1_one.util.NetUtil;
import com.bw.week1_one.util.NetUtil1;
import com.google.gson.Gson;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * DateTime:2020/2/22 0022
 * author:朱贵全(Administrator)
 * function:
 */
public class ZhengModel implements ZhengContract.IModel {
    @Override
    public void getZhengData( IModelCallback iModelCallback) {
        NetUtil.getInstance().getApi().getZheng()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZhengBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ZhengBean zhengBean) {
                        iModelCallback.onZhengSuccess(zhengBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onZhengFailure(e);

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
