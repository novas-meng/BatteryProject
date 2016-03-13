package graph;

import Model.DataModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by novas on 2016/3/13.
 */
public class Tab3 extends JPanel
{
    DataModel dataModel;
    ChartPanel chart;
    private JInternalFrame tablepanel;
    Chart chartPanel;
    //下拉列表框
    JComboBox comboBox;
    JLabel label;
    public Tab3(DataModel dataModel,int width,int height) {
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(gb);
        chartPanel=new zhexianChartPanel(dataModel);
        this.dataModel=dataModel;
        chart=new ChartPanel(width,height,chartPanel);
        tablepanel=new paramtable(dataModel,width,height/2);
        GridBagConstraints ctr1 = new GridBagConstraints();
        ctr1.gridx = 0;
        ctr1.gridy = 0;
        ctr1.weighty = 5;
        ctr1.weightx = 7;
        ctr1.gridheight=10;
        ctr1.anchor = GridBagConstraints.WEST;
        ctr1.fill = GridBagConstraints.BOTH;
        this.add(chart,ctr1);

        label=new JLabel("请选择对比数据");
        GridBagConstraints ctr4 = new GridBagConstraints();
        ctr4.gridx = 1;
        ctr4.gridy = 3;
        ctr4.insets.top=50;
        ctr4.insets.right=50;
        ctr4.anchor = GridBagConstraints.WEST;
        ctr4.fill = GridBagConstraints.BOTH;
        this.add(label,ctr4);


        String[] options={"电压","温度"};
        comboBox=new JComboBox(options);
        GridBagConstraints ctr3 = new GridBagConstraints();
        ctr3.gridx = 1;
        ctr3.gridy = 5;
        ctr3.insets.top=50;
        ctr3.insets.right=50;
        ctr3.anchor = GridBagConstraints.WEST;
        ctr3.fill = GridBagConstraints.BOTH;
        this.add(comboBox,ctr3);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(comboBox.getSelectedIndex()+"  "+comboBox.getSelectedItem());
            }
        });


        GridBagConstraints ctr2 = new GridBagConstraints();
        ctr2.gridx = 0;
        ctr2.gridy = 10;
        ctr2.weighty = 3;
        ctr2.weightx = 1;
        ctr2.gridwidth=2;
        ctr2.gridheight=10;

        ctr2.anchor = GridBagConstraints.WEST;
        ctr2.fill = GridBagConstraints.BOTH;
        this.add(tablepanel,ctr2);
        this.setVisible(true);
        this.setSize(width,height);
    }
}
