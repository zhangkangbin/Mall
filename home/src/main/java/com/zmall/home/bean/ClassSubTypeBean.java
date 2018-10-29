package com.zmall.home.bean;

import com.z.baselibrary.net.BaseBean;

import java.util.List;

/**
 * @author kang
 */
public class ClassSubTypeBean extends BaseBean {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
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
