package com.zmall.order.bean;

import com.z.baselibrary.net.BaseBean;

import java.util.List;

public class OrderDetailBean extends BaseBean {


    /**
     * data : {"shippingList":[],"shippingInfo":{"idOrderShipping":"14584848","shippingCode":"255515465982672779","shippingName":"顺丰速运"},"orderAllInfo":{"title":"交易关闭","orderId":"1","goodsList":[{"picUri":"https://img.alicdn.com/imgextra/i1/2178558361/TB2QPrEnQZmBKNjSZPiXXXFNVXa_!!2178558361-0-item_pic.jpg","goodsId":null,"idShoppingCart":null,"skuNo":"1","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","attrDesc":"XS码,白色","price":279,"num":2},{"picUri":"https://img.alicdn.com/imgextra/i2/2178558361/TB2BN6inY3nBKNjSZFMXXaUSFXa_!!2178558361.jpg","goodsId":null,"idShoppingCart":null,"skuNo":"1","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","attrDesc":"XS码,白色","price":279,"num":2},{"picUri":"https://img.alicdn.com/imgextra/i1/2178558361/TB2fYmSn8jTBKNjSZFDXXbVgVXa_!!2178558361.jpg","goodsId":null,"idShoppingCart":null,"skuNo":"1","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","attrDesc":"XS码,白色","price":279,"num":2},{"picUri":"https://img.alicdn.com/imgextra/i1/2178558361/TB2XwLenVooBKNjSZFPXXXa2XXa_!!2178558361.jpg","goodsId":null,"idShoppingCart":null,"skuNo":"1","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","attrDesc":"XS码,白色","price":279,"num":2},{"picUri":"https://img.alicdn.com/imgextra/i1/2178558361/TB2QPrEnQZmBKNjSZPiXXXFNVXa_!!2178558361-0-item_pic.jpg","goodsId":null,"idShoppingCart":null,"skuNo":"3","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","attrDesc":"M码,白色","price":279,"num":2},{"picUri":"https://img.alicdn.com/imgextra/i2/2178558361/TB2BN6inY3nBKNjSZFMXXaUSFXa_!!2178558361.jpg","goodsId":null,"idShoppingCart":null,"skuNo":"3","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","attrDesc":"M码,白色","price":279,"num":2},{"picUri":"https://img.alicdn.com/imgextra/i1/2178558361/TB2fYmSn8jTBKNjSZFDXXbVgVXa_!!2178558361.jpg","goodsId":null,"idShoppingCart":null,"skuNo":"3","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","attrDesc":"M码,白色","price":279,"num":2},{"picUri":"https://img.alicdn.com/imgextra/i1/2178558361/TB2XwLenVooBKNjSZFPXXXa2XXa_!!2178558361.jpg","goodsId":null,"idShoppingCart":null,"skuNo":"3","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","attrDesc":"M码,白色","price":279,"num":2}],"receiverName":"李四","receiverPhone":"7003219","receiverMobile":"17765528954","receiverState":"上海直辖市","receiverCity":"上海市","receiverDistrict":"虹桥区","receiverAddressDetail":"岳阳路河图口御河社区25D-1109","dataState":"6","paymentDate":"2018-10-25T02:18:30.000+0000","rateBuyer":"0","postFee":16.5,"paymentType":"1","dealSum":1100.99,"invoiceType":"1","invoiceHead":"www.qianhaiwuyin@gou.com","invoiceContent":"普通日用商品"}}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * shippingList : []
         * shippingInfo : {"idOrderShipping":"14584848","shippingCode":"255515465982672779","shippingName":"顺丰速运"}
         * orderAllInfo : {"title":"交易关闭","orderId":"1","goodsList":[{"picUri":"https://img.alicdn.com/imgextra/i1/2178558361/TB2QPrEnQZmBKNjSZPiXXXFNVXa_!!2178558361-0-item_pic.jpg","goodsId":null,"idShoppingCart":null,"skuNo":"1","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","attrDesc":"XS码,白色","price":279,"num":2},{"picUri":"https://img.alicdn.com/imgextra/i2/2178558361/TB2BN6inY3nBKNjSZFMXXaUSFXa_!!2178558361.jpg","goodsId":null,"idShoppingCart":null,"skuNo":"1","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","attrDesc":"XS码,白色","price":279,"num":2},{"picUri":"https://img.alicdn.com/imgextra/i1/2178558361/TB2fYmSn8jTBKNjSZFDXXbVgVXa_!!2178558361.jpg","goodsId":null,"idShoppingCart":null,"skuNo":"1","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","attrDesc":"XS码,白色","price":279,"num":2},{"picUri":"https://img.alicdn.com/imgextra/i1/2178558361/TB2XwLenVooBKNjSZFPXXXa2XXa_!!2178558361.jpg","goodsId":null,"idShoppingCart":null,"skuNo":"1","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","attrDesc":"XS码,白色","price":279,"num":2},{"picUri":"https://img.alicdn.com/imgextra/i1/2178558361/TB2QPrEnQZmBKNjSZPiXXXFNVXa_!!2178558361-0-item_pic.jpg","goodsId":null,"idShoppingCart":null,"skuNo":"3","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","attrDesc":"M码,白色","price":279,"num":2},{"picUri":"https://img.alicdn.com/imgextra/i2/2178558361/TB2BN6inY3nBKNjSZFMXXaUSFXa_!!2178558361.jpg","goodsId":null,"idShoppingCart":null,"skuNo":"3","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","attrDesc":"M码,白色","price":279,"num":2},{"picUri":"https://img.alicdn.com/imgextra/i1/2178558361/TB2fYmSn8jTBKNjSZFDXXbVgVXa_!!2178558361.jpg","goodsId":null,"idShoppingCart":null,"skuNo":"3","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","attrDesc":"M码,白色","price":279,"num":2},{"picUri":"https://img.alicdn.com/imgextra/i1/2178558361/TB2XwLenVooBKNjSZFPXXXa2XXa_!!2178558361.jpg","goodsId":null,"idShoppingCart":null,"skuNo":"3","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","attrDesc":"M码,白色","price":279,"num":2}],"receiverName":"李四","receiverPhone":"7003219","receiverMobile":"17765528954","receiverState":"上海直辖市","receiverCity":"上海市","receiverDistrict":"虹桥区","receiverAddressDetail":"岳阳路河图口御河社区25D-1109","dataState":"6","paymentDate":"2018-10-25T02:18:30.000+0000","rateBuyer":"0","postFee":16.5,"paymentType":"1","dealSum":1100.99,"invoiceType":"1","invoiceHead":"www.qianhaiwuyin@gou.com","invoiceContent":"普通日用商品"}
         */

        private ShippingInfoBean shippingInfo;
        private OrderAllInfoBean orderAllInfo;
        private List<?> shippingList;

        public ShippingInfoBean getShippingInfo() {
            return shippingInfo;
        }

        public void setShippingInfo(ShippingInfoBean shippingInfo) {
            this.shippingInfo = shippingInfo;
        }

        public OrderAllInfoBean getOrderAllInfo() {
            return orderAllInfo;
        }

        public void setOrderAllInfo(OrderAllInfoBean orderAllInfo) {
            this.orderAllInfo = orderAllInfo;
        }

        public List<?> getShippingList() {
            return shippingList;
        }

        public void setShippingList(List<?> shippingList) {
            this.shippingList = shippingList;
        }

        public static class ShippingInfoBean {
            /**
             * idOrderShipping : 14584848
             * shippingCode : 255515465982672779
             * shippingName : 顺丰速运
             */

            private String idOrderShipping;
            private String shippingCode;
            private String shippingName;

            public String getIdOrderShipping() {
                return idOrderShipping;
            }

            public void setIdOrderShipping(String idOrderShipping) {
                this.idOrderShipping = idOrderShipping;
            }

            public String getShippingCode() {
                return shippingCode;
            }

            public void setShippingCode(String shippingCode) {
                this.shippingCode = shippingCode;
            }

            public String getShippingName() {
                return shippingName;
            }

            public void setShippingName(String shippingName) {
                this.shippingName = shippingName;
            }
        }

        public static class OrderAllInfoBean {
            /**
             * title : 交易关闭
             * orderId : 1
             * goodsList : [{"picUri":"https://img.alicdn.com/imgextra/i1/2178558361/TB2QPrEnQZmBKNjSZPiXXXFNVXa_!!2178558361-0-item_pic.jpg","goodsId":null,"idShoppingCart":null,"skuNo":"1","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","attrDesc":"XS码,白色","price":279,"num":2},{"picUri":"https://img.alicdn.com/imgextra/i2/2178558361/TB2BN6inY3nBKNjSZFMXXaUSFXa_!!2178558361.jpg","goodsId":null,"idShoppingCart":null,"skuNo":"1","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","attrDesc":"XS码,白色","price":279,"num":2},{"picUri":"https://img.alicdn.com/imgextra/i1/2178558361/TB2fYmSn8jTBKNjSZFDXXbVgVXa_!!2178558361.jpg","goodsId":null,"idShoppingCart":null,"skuNo":"1","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","attrDesc":"XS码,白色","price":279,"num":2},{"picUri":"https://img.alicdn.com/imgextra/i1/2178558361/TB2XwLenVooBKNjSZFPXXXa2XXa_!!2178558361.jpg","goodsId":null,"idShoppingCart":null,"skuNo":"1","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","attrDesc":"XS码,白色","price":279,"num":2},{"picUri":"https://img.alicdn.com/imgextra/i1/2178558361/TB2QPrEnQZmBKNjSZPiXXXFNVXa_!!2178558361-0-item_pic.jpg","goodsId":null,"idShoppingCart":null,"skuNo":"3","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","attrDesc":"M码,白色","price":279,"num":2},{"picUri":"https://img.alicdn.com/imgextra/i2/2178558361/TB2BN6inY3nBKNjSZFMXXaUSFXa_!!2178558361.jpg","goodsId":null,"idShoppingCart":null,"skuNo":"3","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","attrDesc":"M码,白色","price":279,"num":2},{"picUri":"https://img.alicdn.com/imgextra/i1/2178558361/TB2fYmSn8jTBKNjSZFDXXbVgVXa_!!2178558361.jpg","goodsId":null,"idShoppingCart":null,"skuNo":"3","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","attrDesc":"M码,白色","price":279,"num":2},{"picUri":"https://img.alicdn.com/imgextra/i1/2178558361/TB2XwLenVooBKNjSZFPXXXa2XXa_!!2178558361.jpg","goodsId":null,"idShoppingCart":null,"skuNo":"3","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","attrDesc":"M码,白色","price":279,"num":2}]
             * receiverName : 李四
             * receiverPhone : 7003219
             * receiverMobile : 17765528954
             * receiverState : 上海直辖市
             * receiverCity : 上海市
             * receiverDistrict : 虹桥区
             * receiverAddressDetail : 岳阳路河图口御河社区25D-1109
             * dataState : 6
             * paymentDate : 2018-10-25T02:18:30.000+0000
             * rateBuyer : 0
             * postFee : 16.5
             * paymentType : 1
             * dealSum : 1100.99
             * invoiceType : 1
             * invoiceHead : www.qianhaiwuyin@gou.com
             * invoiceContent : 普通日用商品
             */

            private String title;
            private String orderId;
            private String receiverName;
            private String receiverPhone;
            private String receiverMobile;
            private String receiverState;
            private String receiverCity;
            private String receiverDistrict;
            private String receiverAddressDetail;
            private String dataState;
            private String paymentDate;
            private String rateBuyer;
            private double postFee;
            private String paymentType;
            private double dealSum;
            private String invoiceType;
            private String invoiceHead;
            private String invoiceContent;
            private List<GoodsListBean> goodsList;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public String getReceiverName() {
                return receiverName;
            }

            public void setReceiverName(String receiverName) {
                this.receiverName = receiverName;
            }

            public String getReceiverPhone() {
                return receiverPhone;
            }

            public void setReceiverPhone(String receiverPhone) {
                this.receiverPhone = receiverPhone;
            }

            public String getReceiverMobile() {
                return receiverMobile;
            }

            public void setReceiverMobile(String receiverMobile) {
                this.receiverMobile = receiverMobile;
            }

            public String getReceiverState() {
                return receiverState;
            }

            public void setReceiverState(String receiverState) {
                this.receiverState = receiverState;
            }

            public String getReceiverCity() {
                return receiverCity;
            }

            public void setReceiverCity(String receiverCity) {
                this.receiverCity = receiverCity;
            }

            public String getReceiverDistrict() {
                return receiverDistrict;
            }

            public void setReceiverDistrict(String receiverDistrict) {
                this.receiverDistrict = receiverDistrict;
            }

            public String getReceiverAddressDetail() {
                return receiverAddressDetail;
            }

            public void setReceiverAddressDetail(String receiverAddressDetail) {
                this.receiverAddressDetail = receiverAddressDetail;
            }

            public String getDataState() {
                return dataState;
            }

            public void setDataState(String dataState) {
                this.dataState = dataState;
            }

            public String getPaymentDate() {
                return paymentDate;
            }

            public void setPaymentDate(String paymentDate) {
                this.paymentDate = paymentDate;
            }

            public String getRateBuyer() {
                return rateBuyer;
            }

            public void setRateBuyer(String rateBuyer) {
                this.rateBuyer = rateBuyer;
            }

            public double getPostFee() {
                return postFee;
            }

            public void setPostFee(double postFee) {
                this.postFee = postFee;
            }

            public String getPaymentType() {
                return paymentType;
            }

            public void setPaymentType(String paymentType) {
                this.paymentType = paymentType;
            }

            public double getDealSum() {
                return dealSum;
            }

            public void setDealSum(double dealSum) {
                this.dealSum = dealSum;
            }

            public String getInvoiceType() {
                return invoiceType;
            }

            public void setInvoiceType(String invoiceType) {
                this.invoiceType = invoiceType;
            }

            public String getInvoiceHead() {
                return invoiceHead;
            }

            public void setInvoiceHead(String invoiceHead) {
                this.invoiceHead = invoiceHead;
            }

            public String getInvoiceContent() {
                return invoiceContent;
            }

            public void setInvoiceContent(String invoiceContent) {
                this.invoiceContent = invoiceContent;
            }

            public List<GoodsListBean> getGoodsList() {
                return goodsList;
            }

            public void setGoodsList(List<GoodsListBean> goodsList) {
                this.goodsList = goodsList;
            }

            public static class GoodsListBean {
                /**
                 * picUri : https://img.alicdn.com/imgextra/i1/2178558361/TB2QPrEnQZmBKNjSZPiXXXFNVXa_!!2178558361-0-item_pic.jpg
                 * goodsId : null
                 * idShoppingCart : null
                 * skuNo : 1
                 * goodsName : 名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子
                 * attrDesc : XS码,白色
                 * price : 279.0
                 * num : 2
                 */

                private String picUri;
                private Object goodsId;
                private Object idShoppingCart;
                private String skuNo;
                private String goodsName;
                private String attrDesc;
                private double price;
                private int num;

                public String getPicUri() {
                    return picUri;
                }

                public void setPicUri(String picUri) {
                    this.picUri = picUri;
                }

                public Object getGoodsId() {
                    return goodsId;
                }

                public void setGoodsId(Object goodsId) {
                    this.goodsId = goodsId;
                }

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

                public double getPrice() {
                    return price;
                }

                public void setPrice(double price) {
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
}