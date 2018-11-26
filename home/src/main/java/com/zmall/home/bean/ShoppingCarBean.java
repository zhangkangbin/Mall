package com.zmall.home.bean;

import com.z.baselibrary.net.BaseBean;

import java.util.List;

/**
 * @author kang
 * @date 2018/11/26 0026
 */
public class ShoppingCarBean extends BaseBean {


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
         * idShoppingCart : 1
         * skuNo : 2
         * goodsName : 名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子
         * attrDesc : S码,白色
         * price : 279
         * num : 1
         * isValid : 1
         */

        private String picUri;
        private String goodsNo;
        private String idShoppingCart;
        private String skuNo;
        private String goodsName;
        private String attrDesc;
        private String price;
        private int num;
        private String isValid;

        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
        }

        /**
         * isSelect 本地属性
         */
        private boolean isSelect;

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

        public String getIdShoppingCart() {
            return idShoppingCart;
        }

        public void setIdShoppingCart(String idShoppingCart) {
            this.idShoppingCart = idShoppingCart;
        }

        public String getSkuNo() {
            return skuNo;
        }

        public void setSkuNo(String skuNo) {
            this.skuNo = skuNo;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public String getAttrDesc() {
            return attrDesc;
        }

        public void setAttrDesc(String attrDesc) {
            this.attrDesc = attrDesc;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getIsValid() {
            return isValid;
        }

        public void setIsValid(String isValid) {
            this.isValid = isValid;
        }
    }
}
