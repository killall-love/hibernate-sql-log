package com.xiaolan.hibernate.tools.view.show;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Condition;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.xiaolan.hibernate.tools.view.ToolViewBottom;
import org.jetbrains.annotations.NotNull;

/**
 * @ProjectName: logcatSql
 * @Package: com.xiaolan.hibernate.tools.view.show
 * @ClassName: CustomExecutor
 * @Author: 烟花小神
 * @Description: CustomExecutor
 * @Date: 2020/10/20 9:54
 * @Version: 1.0
 */
public class ToolViewShow implements ToolWindowFactory, Condition<Project> {

    /**
     * 创建 tool window
     * @param project
     * @param toolWindow
     */
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        ToolViewBottom myToolWindow = new ToolViewBottom(toolWindow);
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(myToolWindow.getContent(), "输出控制台", false);
        toolWindow.getContentManager().addContent(content);
    }


    /**
     * 控制tool window是否展示
     * @param project
     * @return
     */
    @Override
    public boolean value(Project project) {
        return true;
    }
}
