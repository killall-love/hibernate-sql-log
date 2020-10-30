package com.xiaolan.hibernate.tools.click;

import com.xiaolan.hibernate.tools.data.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ProjectName: logcatSql
 * @Package: com.xiaolan.hibernate.tools.click
 * @ClassName: ShowOut
 * @Author: 烟花小神
 * @Description: 输出
 * @Date: 2020/10/15 14:49
 * @Version: 1.0
 */
public class ShowOut {

    public static StringBuffer init(){
        if (Model.getSb().toString().isEmpty()) return null;
        StringBuffer author= new StringBuffer();
        author.append("-- Author: 烟花小神\r\n");
        author.append("-- Version: 1.0\r\n");
        author.append("-- ProjectName: logcatSqlOut\r\n");
        StringBuffer sb = new StringBuffer();
        String[] split = Model.getSb().toString().split("Hibernate: ");
        String yyyyMMdd = new SimpleDateFormat("yyyyMMdd").format(new Date());
        for (String s1 : split) {
            String[] split1 = s1.split("-" + yyyyMMdd);
            if(!split1[0].isEmpty()){
                if (split1[0].contains("from")){
                    sb.append(split1[0]);
                    sb.append("\r\n-- ---------------\r\n");
                }
            }
        }
        if (!sb.toString().isEmpty()){
            sb.insert(0,author);
            return sb;
        }
        return null;
    }

}
