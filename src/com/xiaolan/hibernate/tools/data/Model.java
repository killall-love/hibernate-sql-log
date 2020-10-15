package com.xiaolan.hibernate.tools.data;

/**
 * @ProjectName: logcatSql
 * @Package: com.xiaolan.hibernate.tools.data
 * @ClassName: Model
 * @Author: 烟花小神
 * @Description: 数据
 * @Date: 2020/10/15 14:47
 * @Version: 1.0
 */
public class Model {

    private static StringBuffer sb = new StringBuffer();

    public static StringBuffer getSb() {
        return sb;
    }

    public static void setText(String line) {
        sb.append(line);
    }
    public static void init() {
        sb = new StringBuffer();
    }
}
