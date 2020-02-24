package com.bw.week1_one;

import com.bw.week1_one.model.bean.JiBean;
import com.bw.week1_one.model.bean.ZhengBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * DateTime:2020/1/3 0003
 * author:朱贵全(Administrator)
 * function:
 */
public interface Api {
    @GET("api/movie/in_theaters.json")
    Observable<ZhengBean>getZheng();
    @GET("api/movie/coming_soon.json")
    Observable<JiBean>getJi();
}
