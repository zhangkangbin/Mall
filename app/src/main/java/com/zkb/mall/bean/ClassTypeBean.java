package com.zkb.mall.bean;

import com.z.baselibrary.net.BaseBean;

import java.util.List;

/**
 * @author kang
 */
public class ClassTypeBean extends BaseBean {


    /**
     * data : {"goodsClassList":[{"classNo":"1","classDes":"女装"},{"classNo":"2","classDes":"男装"}],"recommendedClass":[{"classNo":"3","classDes":"连衣裙","iconUrl":"null"}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<GoodsClassListBean> goodsClassList;
        private List<RecommendedClassBean> recommendedClass;

        public List<GoodsClassListBean> getGoodsClassList() {
            return goodsClassList;
        }

        public void setGoodsClassList(List<GoodsClassListBean> goodsClassList) {
            this.goodsClassList = goodsClassList;
        }

        public List<RecommendedClassBean> getRecommendedClass() {
            return recommendedClass;
        }

        public void setRecommendedClass(List<RecommendedClassBean> recommendedClass) {
            this.recommendedClass = recommendedClass;
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

        public static class RecommendedClassBean {
            /**
             * classNo : 3
             * classDes : 连衣裙
             * iconUrl : null
             */

            private String classNo;
            private String classDes;
            private String iconUrl;

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

            public String getIconUrl() {
                return iconUrl;
            }

            public void setIconUrl(String iconUrl) {
                this.iconUrl = iconUrl;
            }
        }
    }
}
