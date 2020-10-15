package com.xiaolan.hibernate.tools.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiFile;
import com.xiaolan.hibernate.tools.OutLogSql;
import com.xiaolan.hibernate.tools.click.ShowOut;

import javax.swing.filechooser.FileSystemView;
import java.io.File;

/**
 * @ProjectName: logcatSql
 * @Package: com.xiaolan.hibernate.tools.action
 * @ClassName: ShowAction
 * @Author: 烟花小神
 * @Description: 显示
 * @Date: 2020/10/15 14:54
 * @Version: 1.0
 */
public class ShowAction extends AnAction {

    private static File fsv = FileSystemView.getFileSystemView().getHomeDirectory();
    @Override
    public void actionPerformed(AnActionEvent e) {
        Project project = e.getData(PlatformDataKeys.PROJECT);
        String title = "Hibernate Sql Log-烟花小神";
        //显示对话框
        Messages.showMessageDialog(project, "输出路径  "+fsv.getPath()+"\\log.sql", title, Messages.getInformationIcon());
        ShowOut.init();
    }
}
