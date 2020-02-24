package com.bw.week1_one.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;


/**
 * DateTime:2020/2/23 0023
 * author:朱贵全(Administrator)
 * function:
 */
@Entity
public class GetJson {
    @Id
    Long id;
    String json;
    @Generated(hash = 1319163777)
    public GetJson(Long id, String json) {
        this.id = id;
        this.json = json;
    }
    @Generated(hash = 738079428)
    public GetJson() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getJson() {
        return this.json;
    }
    public void setJson(String json) {
        this.json = json;
    }

}
