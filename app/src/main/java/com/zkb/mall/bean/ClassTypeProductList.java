package com.zkb.mall.bean;

import com.z.baselibrary.net.BaseBean;

import java.util.List;

/**
 * @author kang
 */
public class ClassTypeProductList extends BaseBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * picUri : https://img.alicdn.com/imgextra/i1/2178558361/TB2QPrEnQZmBKNjSZPiXXXFNVXa_!!2178558361-0-item_pic.jpg
         * goodsNo : 1
         * goodsName : 名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子
         * price : 363.0
         */

        private String picUri;
        private String goodsNo;
        private String goodsName;
        private double price;

        public String getPicUri() {
            return picUri;
        }

        public void setPicUri(String picUri) {
            this.picUri = picUri;
        }

        public String getGoodsNo() {
            return goodsNo;
        }

        public void setGoodsNo(String goodsNo) {
            this.goodsNo = goodsNo;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
