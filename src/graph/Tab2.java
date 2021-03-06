package graph;

import Model.DataModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by novas on 2016/3/13.
 */
public class Tab2 extends JPanel
{
    DataModel dataModel;
    ChartPanel chart;
    private JInternalFrame tablepanel;
    Chart chartPanel;
    public Tab2(DataModel dataModel,int width,int height) {
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
        ctr1.weightx = 1;
        ctr1.anchor = GridBagConstraints.WEST;
        ctr1.fill = GridBagConstraints.BOTH;
        this.add(chart,ctr1);

        GridBagConstraints ctr2 = new GridBagConstraints();
        ctr2.gridx = 0;
        ctr2.gridy = 1;
        ctr2.weighty = 2;
        ctr2.weightx = 1;
        ctr2.anchor = GridBagConstraints.WEST;
        ctr2.fill = GridBagConstraints.BOTH;
        this.add(tablepanel,ctr2);
        this.setVisible(true);
        this.setSize(width,height);
    }
}
