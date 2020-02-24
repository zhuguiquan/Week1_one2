package com.bw.week1_one.model;

import com.bw.week1_one.contract.JiContract;
import com.bw.week1_one.model.bean.JiBean;
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
public class JiModel implements JiContract.IModel {
    @Override
    public void getJiData(IModelCallback iModelCallback) {
        NetUtil.getInstance().getApi().getJi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JiBean jiBean) {
                        iModelCallback.onJiSuccess(jiBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onJiFailure(e);

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
