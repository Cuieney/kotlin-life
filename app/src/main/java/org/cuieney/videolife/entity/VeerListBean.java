package org.cuieney.videolife.entity;

import org.cuieney.videolife.entity.VeerBean.DataBean;
import org.cuieney.videolife.entity.VeerBean.PaginationBean;

import java.util.List;

/**
 * Created by cuieney on 2017/6/6.
 */

public class VeerListBean {


    private int code;
    private String message;
    private PaginationBean pagination;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PaginationBean getPagination() {
        return pagination;
    }

    public void setPagination(PaginationBean pagination) {
        this.pagination = pagination;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }


}
