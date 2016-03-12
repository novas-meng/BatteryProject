package graph;
import Model.DataModel;


public class graphtest  {
    private static DataModel dataModel;
/*
    private static graphtest frame;
    private static Tab1 tab1;
    private javax.swing.JTabbedPane jTabbedPane;
    int width=1000;
    int height=800;
    static DataModel dataModel=new DataModel();
    public graphtest() {
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
        JPanel jPanel=new JPanel();
        jPanel.setVisible(true);
        jPanel.setBackground(Color.black);
        JPanel jPanel1=new JPanel();
        jPanel.setVisible(true);
        jPanel1.setBackground(Color.blue);
        jTabbedPane.addTab("数据管理与可视化", null,tab1);
        jTabbedPane.addTab("Tab2", null,jPanel);
        jTabbedPane.addTab("Tab3", null,jPanel1);
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
                                .add(jTabbedPane, GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
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
        setBounds((screenSize.width-1000)/2, (screenSize.height-800)/2, width, height);
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
        frame.setTitle("电池健康管理与剩余寿命预测系统");
    }
    public static void displayTab(int index) {
        frame.setVisible(true);
        frame.jTabbedPane.setSelectedIndex(index);
        frame.toFront();
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
    public static void close() {
        frame.dispose();
    }
    */
    public static void main(String[] args) {
        dataModel=new DataModel();
        dataModel.initTableNodeArray();
        //awt的事件处理线程会按照队列的顺序依次调用每个待处理的事件来运行
        //awt是单线程模式的，所有awt的组件只能在(推荐方式)事件处理线程中访问，从而保证组件状态的可确定性。
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mainframe frame = new mainframe(dataModel);
                frame.displayTab(0);
            }
        });
    }
}
