package Model;

import graph.StringConstants;

import java.util.HashMap;

/**
 * Created by novas on 2016/2/6.
 */
//����ͼ����Model
public class LineChartModel
{
    //�����Ӧÿ����ص�����-������Ϣ
    HashMap<String,double[]> rongliangdata=new HashMap<String, double[]>();
    //�����Ӧÿ����ص�����-�¶���Ϣ
    HashMap<String,double[]> wendudata=new HashMap<String, double[]>();
    //�����Ӧÿ����ص�����-��ѹ��Ϣ
    HashMap<String,double[]> dianyadata=new HashMap<String, double[]>();
    public HashMap getData(String show)
    {
        if(show.equals(StringConstants.rongliang))
        {
            return this.rongliangdata;
        }
        else if(show.equals(StringConstants.wendu))
        {
            return this.wendudata;
        }
        else if(show.equals(StringConstants.dianya))
        {
            return this.dianyadata;
        }
        return null;
    }
    public LineChartModel()
    {

    }
    public void add(String key,double[] value)
    {
      //  Xlength=value.length;
        rongliangdata.put(key,value);
    }
    public double[] getYValue(String show,String key)
    {
        HashMap<String,double[]> data=getData(show);
        return data.get(key);
    }
    public String[] getAllKeys(String show)
    {

        HashMap<String,double[]> data=getData(show);
        String[] strs=new String[data.size()];
        data.keySet().toArray(strs);
        return strs;
    }
    public double[] getXValues(String show,String key)
    {
        HashMap<String,double[]> data=getData(show);
        int Xlength=data.get(key).length;
        double[] xs=new double[Xlength];
        for(int i=0;i<xs.length;i++)
        {
            xs[i]=i;
        }
        return xs;
    }
}
