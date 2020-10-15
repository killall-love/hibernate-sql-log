package com.xiaolan.hibernate.tools.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.xiaolan.hibernate.tools.click.ShowOut;
import org.jetbrains.annotations.NotNull;

/**
 * @ProjectName: logcatSql
 * @Package: com.xiaolan.hibernate.tools.action
 * @ClassName: ClearAction
 * @Author: 烟花小神
 * @Description: 清空
 * @Date: 2020/10/15 15:32
 * @Version: 1.0
 */
public class ClearAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        Project project = anActionEvent.getData(PlatformDataKeys.PROJECT);
        String title = "Hibernate Sql Log-烟花小神";
        //显示对话框
        Messages.showMessageDialog(project, "清理成功", title, Messages.getInformationIcon());
        ShowOut.init();
    }
}
