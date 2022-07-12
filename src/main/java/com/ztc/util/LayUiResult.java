package com.ztc.util;

import java.util.HashMap;
import java.util.Map;

public class LayUiResult {

    /**
     * 数据返回给前台（layui要求的格式）
     *
     * @param code  0有数据 1没数据
     * @param msg   提示信息
     * @param count 数据总条数（用于分页）
     * @param list  返回的数据
     * @return
     */
    public static Map<String, Object> toClient(String code, String msg, int count, Object list) {
        Map<String, Object> rslMap = new HashMap<String, Object>();
        rslMap.put("code", code);
        rslMap.put("msg", msg);
        rslMap.put("count", count);
        rslMap.put("data", list);
        return rslMap;
    }

    /**
     * 数据返回给前台（layui要求的格式）
     *
     * @param code 0有数据 1没数据
     * @param msg  提示信息
     * @return
     */
    public static Map<String, Object> toClient(String code, String msg) {
        Map<String, Object> rslMap = new HashMap<String, Object>();
        rslMap.put("code", code);
        rslMap.put("msg", msg);
        return rslMap;
    }
}
