package com.z.baselibrary.test;

import com.z.baselibrary.net.BaseBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangkb
 * @date on 2018/9/15.
 */
public class BaseList extends BaseBean {

    public List<ProductList> getProductListList() {
        return productListList;
    }

    public void setProductListList(List<ProductList> productListList) {
        this.productListList = productListList;
    }

    private List<ProductList> productListList;

    public static class ProductList {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;

    }
    public static List<ProductList> getTestList() {
        return getTestList(15);
    }
    public static List<ProductList> getTestList(int count) {
        List<ProductList> lists = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ProductList productList = new ProductList();
            productList.setName("短裤朝森OO");
            lists.add(productList);
        }
        return lists;
    }
}
