package com.xiaolan.hibernate.tools.view;

import com.intellij.openapi.wm.ToolWindow;
import com.xiaolan.hibernate.tools.click.ShowOut;
import com.xiaolan.hibernate.tools.data.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ProjectName: logcatSql
 * @Package: com.xiaolan.hibernate.tools.view
 * @ClassName: ConsoleViewAction
 * @Author: 烟花小神
 * @Description: ConsoleViewAction
 * @Date: 2020/10/20 9:52
 * @Version: 1.0
 */
public class ToolViewBottom  {
    private JPanel myToolWindowContent;
    private JButton outPut;
    private JButton clean;
    public JTextArea textArea;


    public ToolViewBottom(ToolWindow toolWindow) {
        init();
        outPut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Model.getState())
                    Model.close();
                else
                    Model.open();

                if (Model.getState()){
                    outPut.setText("正在监听");
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                while (Model.getState()) {
                                    StringBuffer init = ShowOut.init();
                                    if (init == null) continue;
                                    textArea.setText(init.toString());
                                    Thread.sleep(1500);
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }else {
                    outPut.setText("停止监听");
                    Model.close();
                }
            }
        });
        clean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolWindow.setTitle("清理成功");
                Model.init();
                textArea.setText("");
            }
        });
    }

    private void init() {
        outPut = new JButton("输出");
        clean = new JButton("清除");
        myToolWindowContent = new JPanel();
        myToolWindowContent.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        myToolWindowContent.add(panel, BorderLayout.NORTH);
        panel.add(outPut);
        panel.add(clean);
        JScrollPane scrollPane = new JScrollPane();
        myToolWindowContent.add(scrollPane, BorderLayout.CENTER);
        textArea = new JTextArea();
        Font x = new Font("Serif",0,20);
        textArea.setFont(x);
        scrollPane.setViewportView(textArea);
    }

    public JPanel getContent() {
        return myToolWindowContent;
    }
}
