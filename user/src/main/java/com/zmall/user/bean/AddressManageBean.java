package com.zmall.user.bean;

import com.z.baselibrary.net.BaseBean;

import java.io.Serializable;
import java.util.List;

public class AddressManageBean extends BaseBean implements Serializable {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * idUserAddrMgr : 3
         * receiverName : 李四
         * receiverMobile : 17765528954
         * receiverState : 上海直辖市
         * receiverCity : 上海市
         * receiverDistrict : 虹桥区
         * receiverAddressDetail : 岳阳路河图口御河社区25D-1109
         * defaultSite : 1
         */

        private String idUserAddrMgr;
        private String receiverName;
        private String receiverMobile;
        private String receiverState;
        private String receiverCity;
        private String receiverDistrict;
        private String receiverAddressDetail;
        private String defaultSite;

        public String getIdUserAddrMgr() {
            return idUserAddrMgr;
        }

        public void setIdUserAddrMgr(String idUserAddrMgr) {
            this.idUserAddrMgr = idUserAddrMgr;
        }

        public String getReceiverName() {
            return receiverName;
        }

        public void setReceiverName(String receiverName) {
            this.receiverName = receiverName;
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

        public String getDefaultSite() {
            return defaultSite;
        }

        public void setDefaultSite(String defaultSite) {
            this.defaultSite = defaultSite;
        }
    }
}
