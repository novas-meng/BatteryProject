package graph;

import java.awt.*;

import Model.DataModel;
import Model.LineChartModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;

public class zhexianChartPanel implements Chart
{
    ChartPanel frame1;
    DataModel dataModel;
    LineChartModel lineChartModel;
    public zhexianChartPanel(DataModel dataModel){
        this.dataModel=dataModel;
        lineChartModel=dataModel.getLineChartModel();
      //  String[] rowKeys = lineChartModel.getAllKeys();
      //  double[][] data = new double[][]{
      //          {672, 1766, 223, 540, 126},
      //          {325, 521, 210, 340, 106},
      //          {332, 256, 523, 240, 526}
     //   };
      //  double[][] data=lineChartModel.getYValues();
       // String[] columnKeys = {"����", "�Ϻ�", "����", "�ɶ�", "����"};
      //  String[] columnKeys=lineChartModel.getXValues();
        XYDataset xyDataset=createDataset(lineChartModel);
        JFreeChart chart = ChartFactory.createXYLineChart(StringConstants.label, StringConstants.X, StringConstants.Y,
                xyDataset, PlotOrientation.VERTICAL, true, true, false);

        chart.setTextAntiAlias(false);
        chart.setBackgroundPaint(Color.WHITE);
        // ����ͼ�����������������title
        Font font = new Font("����", Font.BOLD, 25);
        TextTitle title = new TextTitle(StringConstants.label);
        title.setFont(font);
        chart.setTitle(title);
        // �����������
        Font labelFont = new Font("SansSerif", Font.TRUETYPE_FONT, 12);

        chart.setBackgroundPaint(Color.WHITE);

        chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
        XYPlot categoryplot = (XYPlot) chart.getPlot();
        // x�� // �����������Ƿ�ɼ�
        categoryplot.setDomainGridlinesVisible(true);
        // y�� //�����������Ƿ�ɼ�
        categoryplot.setRangeGridlinesVisible(true);

        categoryplot.setRangeGridlinePaint(Color.WHITE);// ����ɫ��

        categoryplot.setDomainGridlinePaint(Color.WHITE);// ����ɫ��

        categoryplot.setBackgroundPaint(Color.lightGray);

        // ����������֮��ľ���
        // categoryplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));

        ValueAxis domainAxis = categoryplot.getDomainAxis();

        domainAxis.setLabelFont(labelFont);// �����

        domainAxis.setTickLabelFont(labelFont);// ����ֵ

       // domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // �����ϵ�
        // Lable
        // 45����б
        // ���þ���ͼƬ��˾���

        domainAxis.setLowerMargin(0.0);
        // ���þ���ͼƬ�Ҷ˾���
        domainAxis.setUpperMargin(0.0);
        domainAxis.setTickLabelFont(new Font("����", Font.PLAIN, 11));

        domainAxis.setLabelFont(new Font("����", Font.PLAIN, 12));
        //����Y��������ʽ7
        NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
        numberaxis.setUpperBound(2);
        numberaxis.setLowerBound(1);
        numberaxis.setTickLabelFont(new Font("����", Font.PLAIN, 12));
        numberaxis.setLabelFont(new Font("����", Font.PLAIN, 12));
        // categoryplot.get
        // ���renderer ע���������������͵�lineandshaperenderer����
        XYLineAndShapeRenderer lineandshaperenderer = (XYLineAndShapeRenderer) categoryplot.getRenderer();

        lineandshaperenderer.setBaseShapesVisible(true); // series �㣨�����ݵ㣩�ɼ�

        lineandshaperenderer.setBaseLinesVisible(true); // series �㣨�����ݵ㣩�������߿ɼ�
/*
       // CategoryDataset xyDataset = getBarData(data, rowKeys, columnKeys);
        //JFreeChart chart = ChartFactory.createLineChart(StringConstants.label, StringConstants.X, StringConstants.Y,
          //      xyDataset, PlotOrientation.VERTICAL, true, true, false);

        chart.setTextAntiAlias(false);
        chart.setBackgroundPaint(Color.WHITE);
        // ����ͼ�����������������title
        Font font = new Font("����", Font.BOLD, 25);
        TextTitle title = new TextTitle(StringConstants.label);
        title.setFont(font);
        chart.setTitle(title);
        // �����������
        Font labelFont = new Font("SansSerif", Font.TRUETYPE_FONT, 12);

        chart.setBackgroundPaint(Color.WHITE);

        chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
        CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();
        // x�� // �����������Ƿ�ɼ�
        categoryplot.setDomainGridlinesVisible(true);
        // y�� //�����������Ƿ�ɼ�
        categoryplot.setRangeGridlinesVisible(true);

        categoryplot.setRangeGridlinePaint(Color.WHITE);// ����ɫ��

        categoryplot.setDomainGridlinePaint(Color.WHITE);// ����ɫ��

        categoryplot.setBackgroundPaint(Color.lightGray);

        // ����������֮��ľ���
        // categoryplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));

        CategoryAxis domainAxis = categoryplot.getDomainAxis();

        domainAxis.setLabelFont(labelFont);// �����

        domainAxis.setTickLabelFont(labelFont);// ����ֵ

        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // �����ϵ�
        // Lable
        // 45����б
        // ���þ���ͼƬ��˾���

        domainAxis.setLowerMargin(0.0);
        // ���þ���ͼƬ�Ҷ˾���
        domainAxis.setUpperMargin(0.0);
        domainAxis.setTickLabelFont(new Font("����", Font.PLAIN, 11));

        domainAxis.setLabelFont(new Font("����", Font.PLAIN, 12));
        //����Y��������ʽ7
        NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
        numberaxis.setUpperBound(2);
        numberaxis.setLowerBound(1);
        numberaxis.setTickLabelFont(new Font("����", Font.PLAIN, 12));
        numberaxis.setLabelFont(new Font("����", Font.PLAIN, 12));
       // categoryplot.get
        // ���renderer ע���������������͵�lineandshaperenderer����
        LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryplot.getRenderer();

        lineandshaperenderer.setBaseShapesVisible(true); // series �㣨�����ݵ㣩�ɼ�

        lineandshaperenderer.setBaseLinesVisible(true); // series �㣨�����ݵ㣩�������߿ɼ�
        */
        frame1=new ChartPanel(chart,true);
        frame1.setSize(300,200);
        frame1.setVisible(true);

    }
    // ��״ͼ,����ͼ ���ݼ�
   // public CategoryDataset getBarData(double[][] data, String[] rowKeys,
                                  //    String[] columnKeys) {
     //   return DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);

  //  }
    public  XYDataset createDataset(LineChartModel lineChartModel)
    {
        DefaultXYDataset dataset=new DefaultXYDataset();
        String[] keys=lineChartModel.getAllKeys();
        for(int i=0;i<keys.length;i++)
        {
            System.out.println("keys[i]="+keys[i]);
            double[] xs=lineChartModel.getXValues(keys[i]);
            double[] ys=lineChartModel.getYValue(keys[i]);
            double[][] points=new double[2][xs.length];
            //x�����ֵ
            points[0]=xs;
          //  points[0][1]=2;
           // points[0][2]=3;
         //   points[0][3]=4;
            //��Ӧ��y���Ӧ����ֵ
            points[1]=ys;
          //  points[1][1]=9.5;
           // points[1][2]=20.3;
           // points[1][3]=45.6;
            dataset.addSeries(keys[i],points);
        }
        return dataset;
    }

    public JPanel getChartPanel(){
        return frame1;

    }
}