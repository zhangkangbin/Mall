package com.zmall.order.bean;

import com.z.baselibrary.net.BaseBean;

import java.util.List;

public class AllOrderBean extends BaseBean {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * orderId : 1
         * dealSum : 1100.99
         * dataState : 4
         * rateBuyer : 0
         * goodsList : [{"idShoppingCart":null,"skuNo":"1","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","attrDesc":"XS码,白色","price":279,"num":2},{"idShoppingCart":null,"skuNo":"3","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","attrDesc":"M码,白色","price":279,"num":2}]
         */

        private String orderId;
        private String dealSum;
        private String dataState;
        private String rateBuyer;
        private String dataStateStr;
        private List<GoodsListBean> goodsList;
        public String getDataStateStr() {
            return dataStateStr;
        }

        public void setDataStateStr(String dataStateStr) {
            this.dataStateStr = dataStateStr;
        }
        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getDealSum() {
            return dealSum;
        }

        public void setDealSum(String dealSum) {
            this.dealSum = dealSum;
        }

        public String getDataState() {
            return dataState;
        }

        public void setDataState(String dataState) {
            this.dataState = dataState;
        }

        public String getRateBuyer() {
            return rateBuyer;
        }

        public void setRateBuyer(String rateBuyer) {
            this.rateBuyer = rateBuyer;
        }

        public List<GoodsListBean> getGoodsList() {
            return goodsList;
        }

        public void setGoodsList(List<GoodsListBean> goodsList) {
            this.goodsList = goodsList;
        }

        public static class GoodsListBean {
            /**
             * idShoppingCart : null
             * skuNo : 1
             * goodsName : 名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子
             * attrDesc : XS码,白色
             * price : 279.0
             * num : 2
             */

            private Object idShoppingCart;
            private String skuNo;
            private String goodsName;
            private String attrDesc;
            private String price;
            private int num;

            public String getPicUri() {
                return picUri;
            }

            public void setPicUri(String picUri) {
                this.picUri = picUri;
            }

            private String picUri;
            public Object getIdShoppingCart() {
                return idShoppingCart;
            }

            public void setIdShoppingCart(Object idShoppingCart) {
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
        }
    }
}
