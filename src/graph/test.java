package graph;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.io.FileOutputStream;

public class test {

    int width;// ͼ����

    int height; // ͼ��߶�

    String chartTitle;// ͼ�����

    String subtitle;// ������

    String xTitle;// X�����

    String yTitle;// Y�����

    String[] cutline;// ͼ������

    String category[]; // ͳ������

    Double[][] data;// ��ͼ����

    String servletURI = "/servlet/DisplayChart";// ӳ��·��

    public test() {
        this.width = 450;
        this.height = 325;
        this.chartTitle = "Ԥ������ͼ";
        this.subtitle = "";
        this.xTitle = "Ԥ������";
        this.yTitle = "Ԥ������";
        this.cutline = new String[] { "��9��Ԥ������ͼ" };
        this.category = new String[] { "200809", "200810", "200811", "200812", "200901", "200902"  };//��������
        this.data = new Double[cutline.length][category.length];//������double����
        for (int m = 0; m < cutline.length; m++) {
            for (int n = 0; n < category.length; n++) {
                data[m][n] = 1 + Math.random() * 100;
            }
        }

    }

    public test(int width, int height, String chartTitle,
                             String subtitle, String xTitle, String yTitle, String[] cutline,
                             String[] category, Double[][] data) {
        this.width = width;
        this.height = height;
        this.chartTitle = chartTitle;
        this.subtitle = subtitle;
        this.xTitle = xTitle;
        this.yTitle = yTitle;
        this.cutline = cutline;
        this.category = category;
        this.data = data;
    }

    public test(int width, int height, String chartTitle,
                             String subtitle, String xTitle, String yTitle, String[] cutline,
                             String[] category, Double[][] data, String servletURI) {
        this.width = width;
        this.height = height;
        this.chartTitle = chartTitle;
        this.subtitle = subtitle;
        this.xTitle = xTitle;
        this.yTitle = yTitle;
        this.cutline = cutline;
        this.category = category;
        this.data = data;
        this.servletURI = servletURI;
    }

    public String draw(String path) {

        // ������ͼ���ݼ�
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int m = 0; m < cutline.length; m++) {
            for (int n = 0; n < category.length; n++) {
                dataset.addValue(data[m][n], cutline[m], category[n]);
            }
        }

        // ����ͼ�����
        JFreeChart chart = ChartFactory.createLineChart(chartTitle, // ͼ�����
                xTitle, // X�����
                yTitle, // Y�����
                dataset, // ��ͼ���ݼ�
                PlotOrientation.VERTICAL, // ���Ʒ���
                true, // ��ʾͼ��
                true, // ���ñ�׼������
                false // ��������
        );
        // �Զ���ͼ��ʼ��

        if (subtitle.length() > 0) {// ��Ӹ�����
            chart.addSubtitle(new TextTitle(subtitle));
        }

        GradientPaint chartGP = new GradientPaint(0, 0,
                new Color(219, 227, 127), 0, height, Color.WHITE, false);// ��������ɫ����
        chart.setBackgroundPaint(chartGP);// ����ͼƬ����ɫ

        // ͨ����ͼ�����󣬿������ø���Ļ�ͼ����
        CategoryPlot plot = chart.getCategoryPlot();

        plot.setBackgroundPaint(Color.WHITE);// ���û�ͼ������ɫ

        plot.setRangeGridlinePaint(Color.RED);// ����ˮƽ���򱳾�����ɫ
        plot.setRangeGridlinesVisible(true);// �����Ƿ���ʾˮƽ���򱳾���,Ĭ��ֵΪtrue

        plot.setDomainGridlinePaint(Color.RED);// ���ô�ֱ���򱳾�����ɫ
        plot.setDomainGridlinesVisible(true);// �����Ƿ���ʾ��ֱ���򱳾���,Ĭ��ֵΪfalse

        // ��ȡ���߶���
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot
                .getRenderer();

        // ����������ɫ
        Color color[] = new Color[cutline.length];
        color[0] = Color.GREEN;
        for (int i = 0; i < color.length; i++) {
            renderer.setSeriesPaint(i, color[i]);
        }

        // �������߻��Ʒ��
        BasicStroke realLine = new BasicStroke(1.6f);
        float dashes[] = { 8.0f };// ������������
        BasicStroke brokenLine = new BasicStroke(1.6f,// ������ϸ
                BasicStroke.CAP_ROUND,// �˵���
                BasicStroke.JOIN_ROUND,// �۵���
                8.f,// �۵㴦��취
                dashes,// ��������
                0.0f);// ����ƫ����
        int special = 0;
        for (int i = 0; i < cutline.length; i++) {
            if (i == special) {
                renderer.setSeriesStroke(i, realLine);
            } else {
                renderer.setSeriesStroke(i, brokenLine);
            }
        }

        // ��ú������
        CategoryAxis domainAxis = plot.getDomainAxis();

        // ���ú����������
        domainAxis.setAxisLineStroke(new BasicStroke(1.6f));// �������ߴ�ϸ
        domainAxis.setAxisLinePaint(Color.BLACK);// ����������ɫ
        domainAxis.setCategoryLabelPositionOffset(5);// ����ͳ�����������ߵ���ɫ
        domainAxis.setLabelFont(new Font("����", Font.BOLD, 16));// �����������������
        domainAxis.setLabelPaint(Color.BLACK);// ���������������ɫ
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.STANDARD);// ���������������ת�Ƕ�

        // ����������
        ValueAxis rangeAxis = plot.getRangeAxis();

        // ���������������
        rangeAxis.setAxisLineStroke(new BasicStroke(1.6f));// �������ߴ�ϸ
        rangeAxis.setAxisLinePaint(Color.BLACK);// ����������ɫ
        //rangeAxis.setUpperBound(100.0f);// �����������ֵ
        //rangeAxis.setTickMarkStroke(new BasicStroke(1.6f));// ���������Ǵ�С
        rangeAxis.setTickMarkPaint(Color.BLACK);// ������������ɫ
        rangeAxis.setLabelFont(new Font("����", Font.BOLD, 16));// �����������������
        rangeAxis.setLabelPaint(Color.BLACK);// ���������������ɫ
        rangeAxis.setLabelAngle(Math.PI / 2);// ���������������ת�Ƕ�

        // �Զ���ͼ�������

        // �̶��÷�
        ChartRenderingInfo info = new ChartRenderingInfo(
                new StandardEntityCollection());

        //���������������
        CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();
        NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
        CategoryAxis domainAxis1 = categoryplot.getDomainAxis();
        TextTitle textTitle = chart.getTitle();

        textTitle.setFont(new Font("����", Font.PLAIN, 20));

        domainAxis1.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));

        domainAxis1.setLabelFont(new Font("����", Font.PLAIN, 12));

        numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));

        numberaxis.setLabelFont(new Font("����", Font.PLAIN, 12));

        chart.getLegend().setItemFont(new Font("����", Font.PLAIN, 12));


        //��ͼƬд��ָ��·��������ͼƬ
        FileOutputStream fos_jpg = null;

        try {
            String imagePath = path+"\\fruit4.jpeg";
            fos_jpg = new FileOutputStream(path+"\\fruit4.jpeg");
            ChartUtilities
                    .writeChartAsJPEG(fos_jpg, chart, width, height);
        } catch (Exception e) {
        } finally {
            try {
                fos_jpg.close();
            } catch (Exception e) {
            }
        }

        // ����ͼƬ���·��
        return null;

    }

}  