package graph;

import javax.swing.*;

/**
 * Created by novas on 2016/2/24.
 */
public class ChartPanel extends JPanel
{
    int parentwidth;
    int parentheight;

    public ChartPanel(int parentwidth,int parentheight,Chart abstractChart)
    {
        this.parentwidth=parentwidth;
        this.parentheight=parentheight;
        JPanel panel=abstractChart.getChartPanel();
        this.add(panel);
        this.setVisible(true);
      //  this.setBounds(20,10,5*parentwidth/8,(int)(1.7*parentheight/3)-10);
    }
}
