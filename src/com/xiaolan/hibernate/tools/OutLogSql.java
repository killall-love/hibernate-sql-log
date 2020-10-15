package com.xiaolan.hibernate.tools;

import com.intellij.execution.filters.Filter;
import com.xiaolan.hibernate.tools.data.Model;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


/**
 * @ProjectName: logcatSql
 * @Package: aaa.aaa
 * @ClassName: Ma
 * @Author: 烟花小神
 * @Description:
 * @Date: 2020/10/15 13:07
 * @Version: 1.0
 */
public class OutLogSql implements Filter {
    @Nullable
    @Override
    public Result applyFilter(@NotNull String s, int i) {
        if (s.isEmpty()) return null;
        Model.setText(s);
        return null;
    }
}
