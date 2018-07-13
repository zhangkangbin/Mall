package com.z.baselibrary.webview;

/**
 * Created by zhangkb on 2017/12/22 0022.
 */

import java.lang.reflect.Method;

/**
 * @author RePlugin Team
 */
public class ReflectUtil {
    @SuppressWarnings({
            "rawtypes", "unchecked"
    })

    public static Object invokeStaticMethod(String clzName, String methodName, Class<?>[] methodParamTypes, Object... methodParamValues) {
        try {
            Class clz = Class.forName(clzName);
            if (clz != null) {
                Method method = clz.getDeclaredMethod(methodName, methodParamTypes);
                if (method != null) {
                    method.setAccessible(true);
                    return method.invoke(null, methodParamValues);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}