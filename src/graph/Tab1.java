package graph;

import Model.DataModel;
import layout.GroupLayout;

import java.awt.*;

import javax.swing.*;


public class Tab1 extends JPanel {

	DataModel dataModel;
	ChartPanel chart;
	private JInternalFrame tablepanel;
	Chart chartPanel;
    public Tab1(DataModel dataModel,int width,int height) {
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
		// ctr1.gridwidth = 4;
		// ctr1.gridheight = 1;
		ctr1.anchor = GridBagConstraints.WEST;
		ctr1.fill = GridBagConstraints.BOTH;
		this.add(chart,ctr1);

		GridBagConstraints ctr2 = new GridBagConstraints();
		ctr2.gridx = 0;
		ctr2.gridy = 1;
		ctr2.weighty = 2;
		ctr2.weightx = 1;
		// ctr2.gridwidth = 2;
		// ctr2.gridheight = 1;
		ctr2.anchor = GridBagConstraints.WEST;
		ctr2.fill = GridBagConstraints.BOTH;
		this.add(tablepanel,ctr2);
		this.setVisible(true);
		this.setSize(width,height);
        updateStatus();
    }
    private void initComponents() {

    	 GroupLayout layout = new GroupLayout(this);
    	 this.setLayout(layout);
		/*
    	 layout.setHorizontalGroup(
    	            layout.createParallelGroup(GroupLayout.LEADING)
    	            .add(layout.createSequentialGroup()
    	                .addContainerGap()
    	                .add(layout.createParallelGroup(GroupLayout.LEADING)
    	                    .add(layout.createSequentialGroup()
									// .add(12, 12, 12)
									.add(chart, 600, 700, 800)
									.addPreferredGap(LayoutStyle.RELATED))))
    	        );
    	 layout.setVerticalGroup(
 	            layout.createParallelGroup(GroupLayout.LEADING)
 	            .add(layout.createSequentialGroup()
 	                .addContainerGap()
 	                .add(layout.createParallelGroup(GroupLayout.LEADING)
 	                    .add(layout.createSequentialGroup()
								// .add(12, 12, 12)
								.add(chart, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.RELATED))))
 	        );
 	        */
    }
    public void updateStatus() {
    
    }
}
