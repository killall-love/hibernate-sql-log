package com.xiaolan.hibernate.tools;

import com.intellij.execution.filters.ConsoleFilterProvider;
import com.intellij.execution.filters.Filter;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * @ProjectName: logcatSql
 * @Package: aaa.aaa
 * @ClassName: Main
 * @Author: 烟花小神
 * @Description:
 * @Date: 2020/10/15 13:05
 * @Version: 1.0
 */
public class MyConsoleFilterProvider implements ConsoleFilterProvider {
    @NotNull
    @Override
    public Filter[] getDefaultFilters(@NotNull Project project) {
        Filter ma = new OutLogSql();
        return new Filter[]{ma};
    }
}
