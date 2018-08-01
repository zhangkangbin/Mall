package com.zkb.mall.bean;

import com.z.baselibrary.net.BaseBean;

import java.util.List;

/**
 * @author zhangkb
 */
public class HomeBean  extends BaseBean{

    public List<DataBean> getList() {
        return list;
    }

    public void setList(List<DataBean> list) {
        this.list = list;
    }

    List<DataBean> list;

    public static class DataBean{

        public String getPirce() {
            return pirce;
        }

        public void setPirce(String pirce) {
            this.pirce = pirce;
        }

        String pirce;


    }

}
