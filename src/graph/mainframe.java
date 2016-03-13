package graph;

import Model.DataModel;
import javafx.scene.control.Tab;
import layout.GroupLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

/**
 * Created by novas on 2016/2/6.
 */
public class mainframe extends JFrame
{
   // private static mainframe frame;
    private Tab1 tab1;
    private Tab2 tab2;
    private Tab3 tab3;
    private javax.swing.JTabbedPane jTabbedPane;
    int width=1000;
    int height=700;
    static DataModel dataModel;
    public mainframe(DataModel dataModel) {
        this.dataModel=dataModel;
        initComponents();
    }

    private void initComponents() {
        jTabbedPane = new javax.swing.JTabbedPane();
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("电池健康管理与剩余寿命预测系统");
        //setIconImage(new ImageIcon(Commons.IDLE_ICON).getImage());
        setIconImage(null);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tab1 = new Tab1(dataModel,width,height);
        tab2 = new Tab2(dataModel,width,height);
        tab3 = new Tab3(dataModel,width,height);
        jTabbedPane.addTab("数据管理与可视化", null,tab1);
        jTabbedPane.addTab("容量预测", null,tab2);
        jTabbedPane.addTab("性能分析", null,tab3);
        jTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPaneStateChanged(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jTabbedPane, GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.LEADING)
                        .add(GroupLayout.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jTabbedPane, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-width)/2, (screenSize.height-height)/2, width, height);
       // this.pack();
     //   setBounds(0,0,width,height);
    }
    private void jTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPaneStateChanged
        //在这里可以加入你需要触发的事件
        System.out.println("点击"+(jTabbedPane.getSelectedIndex()));
        switch (jTabbedPane.getSelectedIndex()) {

            case 0:
                displayTab(0);
                break;
            case 1:
                displayTab(1);
                break;
            case 2:
                displayTab(2);
                break;
        }
        this.setTitle("电池健康管理与剩余寿命预测系统");
    }
    public  void displayTab(int index) {
        this.setVisible(true);
        this.jTabbedPane.setSelectedIndex(index);
        this.toFront();
    }
    //处理来自windows消息
    private void formWindowClosing(WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (evt.getID() == WindowEvent.WINDOW_CLOSING) {
            close();
        } else{
            super.processWindowEvent(evt);
        }
    }
    //关闭窗体并释放资源
    public  void close() {
        this.dispose();
    }

}
