package com.bw.week1_one.contract;

import com.bw.week1_one.model.bean.JiBean;

/**
 * DateTime:2020/2/22 0022
 * author:朱贵全(Administrator)
 * function:
 */
public interface JiContract {
    interface IView{
        void onJiSuccess(JiBean jiBean);
        void onJiFailure(Throwable throwable);
    }
    interface IPresenter{
        void getJiData();

    }
    interface IModel{
        void getJiData(IModelCallback iModelCallback);
        interface IModelCallback{
            void onJiSuccess(JiBean jiBean);
            void onJiFailure(Throwable throwable);
        }
    }

}
