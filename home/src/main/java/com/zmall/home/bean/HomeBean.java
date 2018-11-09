package com.zmall.home.bean;

import com.z.baselibrary.net.BaseBean;

import java.util.List;

/**
 * @author zhangkb
 */
public class HomeBean extends BaseBean{


    /**
     * data : {"goodsClassList":[{"classNo":"1","classDes":"女装"},{"classNo":"2","classDes":"男装"}],"updateInfo":{"apkUrl":"http://fast.yingyonghui.com/1f544c3f6aad52739f89902e04ecd36e/5bcad97b/apk/6194379/9aa6c72f9b4e6a290975428dd4c76855","updateIntroduce":"1,海量商品\n2,优化体验","version":"1.1","versionCode":2,"apkMd5":"9AA6C72F9B4E6A290975428DD4C76855","forceUpdate":false},"slideShowList":[{"picUri":"http://d.hiphotos.baidu.com/image/pic/item/b64543a98226cffc254c32acb4014a90f603ea4e.jpg","comment":"主页大幕轮播图"},{"picUri":"http://c.hiphotos.baidu.com/image/h%3D300/sign=cfce96dfa251f3dedcb2bf64a4eff0ec/4610b912c8fcc3ce912597269f45d688d43f2039.jpg","comment":"主页大幕轮播图"},{"picUri":"http://a.hiphotos.baidu.com/image/h%3D300/sign=63b030ff6fd9f2d33f1122ef99ec8a53/3bf33a87e950352ade182a165e43fbf2b2118bb6.jpg","comment":"主页大幕轮播图"},{"picUri":"http://f.hiphotos.baidu.com/image/h%3D300/sign=dc7e87bdfb03738dc14a0a22831ab073/08f790529822720e698c1ae776cb0a46f21fab69.jpg","comment":"主页大幕轮播图"},{"picUri":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3423454844,2988036531&fm=26&gp=0.jpg","comment":"主页大幕轮播图"}]}
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
         * goodsClassList : [{"classNo":"1","classDes":"女装"},{"classNo":"2","classDes":"男装"}]
         * updateInfo : {"apkUrl":"http://fast.yingyonghui.com/1f544c3f6aad52739f89902e04ecd36e/5bcad97b/apk/6194379/9aa6c72f9b4e6a290975428dd4c76855","updateIntroduce":"1,海量商品\n2,优化体验","version":"1.1","versionCode":2,"apkMd5":"9AA6C72F9B4E6A290975428DD4C76855","forceUpdate":false}
         * slideShowList : [{"picUri":"http://d.hiphotos.baidu.com/image/pic/item/b64543a98226cffc254c32acb4014a90f603ea4e.jpg","comment":"主页大幕轮播图"},{"picUri":"http://c.hiphotos.baidu.com/image/h%3D300/sign=cfce96dfa251f3dedcb2bf64a4eff0ec/4610b912c8fcc3ce912597269f45d688d43f2039.jpg","comment":"主页大幕轮播图"},{"picUri":"http://a.hiphotos.baidu.com/image/h%3D300/sign=63b030ff6fd9f2d33f1122ef99ec8a53/3bf33a87e950352ade182a165e43fbf2b2118bb6.jpg","comment":"主页大幕轮播图"},{"picUri":"http://f.hiphotos.baidu.com/image/h%3D300/sign=dc7e87bdfb03738dc14a0a22831ab073/08f790529822720e698c1ae776cb0a46f21fab69.jpg","comment":"主页大幕轮播图"},{"picUri":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3423454844,2988036531&fm=26&gp=0.jpg","comment":"主页大幕轮播图"}]
         */

        private UpdateInfoBean updateInfo;
        private List<GoodsClassListBean> goodsClassList;
        private List<SlideShowListBean> slideShowList;

        public UpdateInfoBean getUpdateInfo() {
            return updateInfo;
        }

        public void setUpdateInfo(UpdateInfoBean updateInfo) {
            this.updateInfo = updateInfo;
        }

        public List<GoodsClassListBean> getGoodsClassList() {
            return goodsClassList;
        }

        public void setGoodsClassList(List<GoodsClassListBean> goodsClassList) {
            this.goodsClassList = goodsClassList;
        }

        public List<SlideShowListBean> getSlideShowList() {
            return slideShowList;
        }

        public void setSlideShowList(List<SlideShowListBean> slideShowList) {
            this.slideShowList = slideShowList;
        }

        public static class UpdateInfoBean {
            /**
             * apkUrl : http://fast.yingyonghui.com/1f544c3f6aad52739f89902e04ecd36e/5bcad97b/apk/6194379/9aa6c72f9b4e6a290975428dd4c76855
             * updateIntroduce : 1,海量商品
             2,优化体验
             * version : 1.1
             * versionCode : 2
             * apkMd5 : 9AA6C72F9B4E6A290975428DD4C76855
             * forceUpdate : false
             */

            private String apkUrl;
            private String updateIntroduce;
            private String version;
            private int versionCode;
            private String apkMd5;
            private boolean forceUpdate;

            public String getApkUrl() {
                return apkUrl;
            }

            public void setApkUrl(String apkUrl) {
                this.apkUrl = apkUrl;
            }

            public String getUpdateIntroduce() {
                return updateIntroduce;
            }

            public void setUpdateIntroduce(String updateIntroduce) {
                this.updateIntroduce = updateIntroduce;
            }

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }

            public int getVersionCode() {
                return versionCode;
            }

            public void setVersionCode(int versionCode) {
                this.versionCode = versionCode;
            }

            public String getApkMd5() {
                return apkMd5;
            }

            public void setApkMd5(String apkMd5) {
                this.apkMd5 = apkMd5;
            }

            public boolean isForceUpdate() {
                return forceUpdate;
            }

            public void setForceUpdate(boolean forceUpdate) {
                this.forceUpdate = forceUpdate;
            }
        }

        public static class GoodsClassListBean {
            /**
             * classNo : 1
             * classDes : 女装
             */

            private String classNo;
            private String classDes;

            public String getClassNo() {
                return classNo;
            }

            public void setClassNo(String classNo) {
                this.classNo = classNo;
            }

            public String getClassDes() {
                return classDes;
            }

            public void setClassDes(String classDes) {
                this.classDes = classDes;
            }
        }

        public static class SlideShowListBean {
            /**
             * picUri : http://d.hiphotos.baidu.com/image/pic/item/b64543a98226cffc254c32acb4014a90f603ea4e.jpg
             * comment : 主页大幕轮播图
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
    }
}
