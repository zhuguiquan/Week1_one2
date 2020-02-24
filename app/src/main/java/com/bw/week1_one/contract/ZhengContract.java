package com.bw.week1_one.contract;

import com.bw.week1_one.model.bean.ZhengBean;

/**
 * DateTime:2020/2/22 0022
 * author:朱贵全(Administrator)
 * function:
 */
public interface ZhengContract {
    interface IView{
        void onZhengSuccess(ZhengBean zhengbean);
        void onZhengFailure(Throwable throwable);
    }
    interface IPresenter{
        void getZhengData();

    }
    interface IModel{
        void getZhengData(IModelCallback iModelCallback);
        interface IModelCallback{
            void onZhengSuccess(ZhengBean zhengbean);
            void onZhengFailure(Throwable throwable);
        }
    }

}
