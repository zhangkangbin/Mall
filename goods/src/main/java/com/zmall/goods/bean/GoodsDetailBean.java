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
     * data : {"apiGoodsShowDto":{"goodsNo":"1","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","subName":"名媛气质 迷人曲线 优雅女神范 高贵轻熟女","price":363,"marketPrice":499},"imgeList":[{"picUri":"https://img.alicdn.com/imgextra/i1/2178558361/TB2QPrEnQZmBKNjSZPiXXXFNVXa_!!2178558361-0-item_pic.jpg","comment":"商品图片"},{"picUri":"https://img.alicdn.com/imgextra/i2/2178558361/TB2BN6inY3nBKNjSZFMXXaUSFXa_!!2178558361.jpg","comment":"商品图片"},{"picUri":"https://img.alicdn.com/imgextra/i1/2178558361/TB2fYmSn8jTBKNjSZFDXXbVgVXa_!!2178558361.jpg","comment":"商品图片"},{"picUri":"https://img.alicdn.com/imgextra/i1/2178558361/TB2XwLenVooBKNjSZFPXXXa2XXa_!!2178558361.jpg","comment":"商品图片"}],"goodsClassAttrList":["主要颜色","尺码"],"goodsEvaluateInfoList":[{"headPortrait":"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3797481993,1929347741&fm=27&gp=0.jpg","userName":"河畔小溪人家","evaluateInfo":"质量不错挺实惠的下次还来"},{"headPortrait":"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3797481993,1929347741&fm=27&gp=0.jpg","userName":"听雨者","evaluateInfo":"朋友介绍的，物美价廉"},{"headPortrait":"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3797481993,1929347741&fm=27&gp=0.jpg","userName":"沉默是金","evaluateInfo":"质量很好"}],"goodsClassParaList":["风格版型","袖长","裙长"],"goodsEvaluateTitleList":[{"title":"质量很好","quantity":66},{"title":"物超所值","quantity":125},{"title":"物流快","quantity":74}],"goodsStaticParticularsList":[{"idGoodsDtlInfo":"1","picInfoUri":"https://img.alicdn.com/imgextra/i2/269385296/O1CN011ozc1HikrKeCCC6_!!269385296.jpg","sortNo":1},{"idGoodsDtlInfo":"2","picInfoUri":"https://img.alicdn.com/imgextra/i2/269385296/TB29r8XI1SSBuNjy0FlXXbBpVXa_!!269385296.jpg","sortNo":2},{"idGoodsDtlInfo":"3","picInfoUri":"https://img.alicdn.com/imgextra/i4/269385296/TB2BBHRnYZnBKNjSZFKXXcGOVXa_!!269385296.jpg","sortNo":3},{"idGoodsDtlInfo":"4","picInfoUri":"https://img.alicdn.com/imgextra/i2/269385296/O1CN011ozc1ac6sqhQoJq_!!269385296.jpg","sortNo":4},{"idGoodsDtlInfo":"5","picInfoUri":"https://img.alicdn.com/imgextra/i2/269385296/TB2SQk_b7zoK1RjSZFlXXai4VXa_!!269385296.jpg","sortNo":5},{"idGoodsDtlInfo":"6","picInfoUri":"https://img.alicdn.com/imgextra/i3/269385296/O1CN011ozc1GS9v19M511_!!269385296.jpg","sortNo":6},{"idGoodsDtlInfo":"7","picInfoUri":"https://img.alicdn.com/imgextra/i4/269385296/O1CN011ozc1LaHUTSktE8_!!269385296.jpg","sortNo":7}],"goodsSafeguardList":["7天无理由","9天内发货"]}
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
         * apiGoodsShowDto : {"goodsNo":"1","goodsName":"名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子","subName":"名媛气质 迷人曲线 优雅女神范 高贵轻熟女","price":363,"marketPrice":499}
         * imgeList : [{"picUri":"https://img.alicdn.com/imgextra/i1/2178558361/TB2QPrEnQZmBKNjSZPiXXXFNVXa_!!2178558361-0-item_pic.jpg","comment":"商品图片"},{"picUri":"https://img.alicdn.com/imgextra/i2/2178558361/TB2BN6inY3nBKNjSZFMXXaUSFXa_!!2178558361.jpg","comment":"商品图片"},{"picUri":"https://img.alicdn.com/imgextra/i1/2178558361/TB2fYmSn8jTBKNjSZFDXXbVgVXa_!!2178558361.jpg","comment":"商品图片"},{"picUri":"https://img.alicdn.com/imgextra/i1/2178558361/TB2XwLenVooBKNjSZFPXXXa2XXa_!!2178558361.jpg","comment":"商品图片"}]
         * goodsClassAttrList : ["主要颜色","尺码"]
         * goodsEvaluateInfoList : [{"headPortrait":"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3797481993,1929347741&fm=27&gp=0.jpg","userName":"河畔小溪人家","evaluateInfo":"质量不错挺实惠的下次还来"},{"headPortrait":"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3797481993,1929347741&fm=27&gp=0.jpg","userName":"听雨者","evaluateInfo":"朋友介绍的，物美价廉"},{"headPortrait":"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3797481993,1929347741&fm=27&gp=0.jpg","userName":"沉默是金","evaluateInfo":"质量很好"}]
         * goodsClassParaList : ["风格版型","袖长","裙长"]
         * goodsEvaluateTitleList : [{"title":"质量很好","quantity":66},{"title":"物超所值","quantity":125},{"title":"物流快","quantity":74}]
         * goodsStaticParticularsList : [{"idGoodsDtlInfo":"1","picInfoUri":"https://img.alicdn.com/imgextra/i2/269385296/O1CN011ozc1HikrKeCCC6_!!269385296.jpg","sortNo":1},{"idGoodsDtlInfo":"2","picInfoUri":"https://img.alicdn.com/imgextra/i2/269385296/TB29r8XI1SSBuNjy0FlXXbBpVXa_!!269385296.jpg","sortNo":2},{"idGoodsDtlInfo":"3","picInfoUri":"https://img.alicdn.com/imgextra/i4/269385296/TB2BBHRnYZnBKNjSZFKXXcGOVXa_!!269385296.jpg","sortNo":3},{"idGoodsDtlInfo":"4","picInfoUri":"https://img.alicdn.com/imgextra/i2/269385296/O1CN011ozc1ac6sqhQoJq_!!269385296.jpg","sortNo":4},{"idGoodsDtlInfo":"5","picInfoUri":"https://img.alicdn.com/imgextra/i2/269385296/TB2SQk_b7zoK1RjSZFlXXai4VXa_!!269385296.jpg","sortNo":5},{"idGoodsDtlInfo":"6","picInfoUri":"https://img.alicdn.com/imgextra/i3/269385296/O1CN011ozc1GS9v19M511_!!269385296.jpg","sortNo":6},{"idGoodsDtlInfo":"7","picInfoUri":"https://img.alicdn.com/imgextra/i4/269385296/O1CN011ozc1LaHUTSktE8_!!269385296.jpg","sortNo":7}]
         * goodsSafeguardList : ["7天无理由","9天内发货"]
         */

        private ApiGoodsShowDtoBean apiGoodsShowDto;
        private List<ImgeListBean> imgeList;
        private List<String> goodsClassAttrList;
        private List<GoodsEvaluateInfoListBean> goodsEvaluateInfoList;
        private List<String> goodsClassParaList;
        private List<GoodsEvaluateTitleListBean> goodsEvaluateTitleList;
        private List<GoodsStaticParticularsListBean> goodsStaticParticularsList;
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

        public List<GoodsStaticParticularsListBean> getGoodsStaticParticularsList() {
            return goodsStaticParticularsList;
        }

        public void setGoodsStaticParticularsList(List<GoodsStaticParticularsListBean> goodsStaticParticularsList) {
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
             * goodsNo : 1
             * goodsName : 名嫒气质2018秋季新款V领修身显瘦金丝绒连衣裙礼服中长款A字裙子
             * subName : 名媛气质 迷人曲线 优雅女神范 高贵轻熟女
             * price : 363.0
             * marketPrice : 499.0
             */

            private String goodsNo;
            private String goodsName;
            private String subName;
            private double price;
            private double marketPrice;

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

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public double getMarketPrice() {
                return marketPrice;
            }

            public void setMarketPrice(double marketPrice) {
                this.marketPrice = marketPrice;
            }
        }

        public static class ImgeListBean {
            /**
             * picUri : https://img.alicdn.com/imgextra/i1/2178558361/TB2QPrEnQZmBKNjSZPiXXXFNVXa_!!2178558361-0-item_pic.jpg
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

        public static class GoodsStaticParticularsListBean {
            /**
             * idGoodsDtlInfo : 1
             * picInfoUri : https://img.alicdn.com/imgextra/i2/269385296/O1CN011ozc1HikrKeCCC6_!!269385296.jpg
             * sortNo : 1
             */

            private String idGoodsDtlInfo;
            private String picInfoUri;
            private int sortNo;

            public String getIdGoodsDtlInfo() {
                return idGoodsDtlInfo;
            }

            public void setIdGoodsDtlInfo(String idGoodsDtlInfo) {
                this.idGoodsDtlInfo = idGoodsDtlInfo;
            }

            public String getPicInfoUri() {
                return picInfoUri;
            }

            public void setPicInfoUri(String picInfoUri) {
                this.picInfoUri = picInfoUri;
            }

            public int getSortNo() {
                return sortNo;
            }

            public void setSortNo(int sortNo) {
                this.sortNo = sortNo;
            }
        }
    }
}
