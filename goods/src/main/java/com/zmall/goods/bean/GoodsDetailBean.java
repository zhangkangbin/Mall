package com.zmall.goods.bean;

import com.z.baselibrary.net.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhangkb
 * @date on 2018/10/20.
 */
public class GoodsDetailBean extends BaseBean implements Serializable {


    /**
     * data : {"apiGoodsShowDto":{"goodsNo":"3","goodsName":"茉莉2018秋冬高领保暖复古钉花手工花朵中长款针织拼网纱连衣裙","subName":"保暖长袖 洋气黑泽","price":248,"marketPrice":456},"imgeList":[{"picUri":"https://gd3.alicdn.com/imgextra/i3/60638636/TB2qs3pbhSYBuNjSsphXXbGvVXa_!!60638636.jpg","comment":"商品图片"},{"picUri":"https://gd1.alicdn.com/imgextra/i3/60638636/TB2HEYJaNTI8KJjSspiXXbM4FXa_!!60638636.jpg","comment":"商品图片"},{"picUri":"https://gd3.alicdn.com/imgextra/i3/60638636/TB2EXyCaFHM8KJjSZJiXXbx3FXa_!!60638636.jpg","comment":"商品图片"},{"picUri":"https://gd2.alicdn.com/imgextra/i2/60638636/TB2wJgubXmWBuNjSspdXXbugXXa_!!60638636.jpg","comment":"商品图片"}],"goodsClassAttrList":["主要颜色","尺码"],"goodsEvaluateInfoList":[{"headPortrait":"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3797481993,1929347741&fm=27&gp=0.jpg","userName":"河畔小溪人家","evaluateInfo":"质量不错挺实惠的下次还来"},{"headPortrait":"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3797481993,1929347741&fm=27&gp=0.jpg","userName":"听雨者","evaluateInfo":"朋友介绍的，物美价廉"},{"headPortrait":"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3797481993,1929347741&fm=27&gp=0.jpg","userName":"沉默是金","evaluateInfo":"质量很好"}],"goodsClassParaList":["风格版型","袖长","裙长"],"goodsEvaluateTitleList":[{"title":"质量很好","quantity":66},{"title":"物超所值","quantity":125},{"title":"物流快","quantity":74}],"goodsStaticParticularsList":[],"goodsSafeguardList":["7天无理由","9天内发货"]}
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
         * apiGoodsShowDto : {"goodsNo":"3","goodsName":"茉莉2018秋冬高领保暖复古钉花手工花朵中长款针织拼网纱连衣裙","subName":"保暖长袖 洋气黑泽","price":248,"marketPrice":456}
         * imgeList : [{"picUri":"https://gd3.alicdn.com/imgextra/i3/60638636/TB2qs3pbhSYBuNjSsphXXbGvVXa_!!60638636.jpg","comment":"商品图片"},{"picUri":"https://gd1.alicdn.com/imgextra/i3/60638636/TB2HEYJaNTI8KJjSspiXXbM4FXa_!!60638636.jpg","comment":"商品图片"},{"picUri":"https://gd3.alicdn.com/imgextra/i3/60638636/TB2EXyCaFHM8KJjSZJiXXbx3FXa_!!60638636.jpg","comment":"商品图片"},{"picUri":"https://gd2.alicdn.com/imgextra/i2/60638636/TB2wJgubXmWBuNjSspdXXbugXXa_!!60638636.jpg","comment":"商品图片"}]
         * goodsClassAttrList : ["主要颜色","尺码"]
         * goodsEvaluateInfoList : [{"headPortrait":"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3797481993,1929347741&fm=27&gp=0.jpg","userName":"河畔小溪人家","evaluateInfo":"质量不错挺实惠的下次还来"},{"headPortrait":"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3797481993,1929347741&fm=27&gp=0.jpg","userName":"听雨者","evaluateInfo":"朋友介绍的，物美价廉"},{"headPortrait":"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3797481993,1929347741&fm=27&gp=0.jpg","userName":"沉默是金","evaluateInfo":"质量很好"}]
         * goodsClassParaList : ["风格版型","袖长","裙长"]
         * goodsEvaluateTitleList : [{"title":"质量很好","quantity":66},{"title":"物超所值","quantity":125},{"title":"物流快","quantity":74}]
         * goodsStaticParticularsList : []
         * goodsSafeguardList : ["7天无理由","9天内发货"]
         */

        private ApiGoodsShowDtoBean apiGoodsShowDto;
        private List<ImgeListBean> imgeList;
        private List<String> goodsClassAttrList;
        private List<GoodsEvaluateInfoListBean> goodsEvaluateInfoList;
        private List<String> goodsClassParaList;
        private List<GoodsEvaluateTitleListBean> goodsEvaluateTitleList;
        private List<?> goodsStaticParticularsList;
        private List<String> goodsSafeguardList;

        public ApiGoodsShowDtoBean getApiGoodsShowDto() {
            return apiGoodsShowDto;
        }

        public void setApiGoodsShowDto(ApiGoodsShowDtoBean apiGoodsShowDto) {
            this.apiGoodsShowDto = apiGoodsShowDto;
        }

        public List<ImgeListBean> getImgeList() {
            return imgeList;
        }

        public void setImgeList(List<ImgeListBean> imgeList) {
            this.imgeList = imgeList;
        }

        public List<String> getGoodsClassAttrList() {
            return goodsClassAttrList;
        }

        public void setGoodsClassAttrList(List<String> goodsClassAttrList) {
            this.goodsClassAttrList = goodsClassAttrList;
        }

        public List<GoodsEvaluateInfoListBean> getGoodsEvaluateInfoList() {
            return goodsEvaluateInfoList;
        }

        public void setGoodsEvaluateInfoList(List<GoodsEvaluateInfoListBean> goodsEvaluateInfoList) {
            this.goodsEvaluateInfoList = goodsEvaluateInfoList;
        }

        public List<String> getGoodsClassParaList() {
            return goodsClassParaList;
        }

        public void setGoodsClassParaList(List<String> goodsClassParaList) {
            this.goodsClassParaList = goodsClassParaList;
        }

        public List<GoodsEvaluateTitleListBean> getGoodsEvaluateTitleList() {
            return goodsEvaluateTitleList;
        }

        public void setGoodsEvaluateTitleList(List<GoodsEvaluateTitleListBean> goodsEvaluateTitleList) {
            this.goodsEvaluateTitleList = goodsEvaluateTitleList;
        }

        public List<?> getGoodsStaticParticularsList() {
            return goodsStaticParticularsList;
        }

        public void setGoodsStaticParticularsList(List<?> goodsStaticParticularsList) {
            this.goodsStaticParticularsList = goodsStaticParticularsList;
        }

        public List<String> getGoodsSafeguardList() {
            return goodsSafeguardList;
        }

        public void setGoodsSafeguardList(List<String> goodsSafeguardList) {
            this.goodsSafeguardList = goodsSafeguardList;
        }

        public static class ApiGoodsShowDtoBean {
            /**
             * goodsNo : 3
             * goodsName : 茉莉2018秋冬高领保暖复古钉花手工花朵中长款针织拼网纱连衣裙
             * subName : 保暖长袖 洋气黑泽
             * price : 248.0
             * marketPrice : 456.0
             */

            private String goodsNo;
            private String goodsName;
            private String subName;
            private String price;
            private String marketPrice;

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

            public String getSubName() {
                return subName;
            }

            public void setSubName(String subName) {
                this.subName = subName;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getMarketPrice() {
                return marketPrice;
            }

            public void setMarketPrice(String marketPrice) {
                this.marketPrice = marketPrice;
            }
        }

        public static class ImgeListBean {
            /**
             * picUri : https://gd3.alicdn.com/imgextra/i3/60638636/TB2qs3pbhSYBuNjSsphXXbGvVXa_!!60638636.jpg
             * comment : 商品图片
             */

            private String picUri;
            private String comment;

            public String getPicUri() {
                return picUri;
            }

            public void setPicUri(String picUri) {
                this.picUri = picUri;
            }

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }
        }

        public static class GoodsEvaluateInfoListBean {
            /**
             * headPortrait : https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3797481993,1929347741&fm=27&gp=0.jpg
             * userName : 河畔小溪人家
             * evaluateInfo : 质量不错挺实惠的下次还来
             */

            private String headPortrait;
            private String userName;
            private String evaluateInfo;

            public String getHeadPortrait() {
                return headPortrait;
            }

            public void setHeadPortrait(String headPortrait) {
                this.headPortrait = headPortrait;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getEvaluateInfo() {
                return evaluateInfo;
            }

            public void setEvaluateInfo(String evaluateInfo) {
                this.evaluateInfo = evaluateInfo;
            }
        }

        public static class GoodsEvaluateTitleListBean {
            /**
             * title : 质量很好
             * quantity : 66
             */

            private String title;
            private int quantity;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }
        }
    }
}
